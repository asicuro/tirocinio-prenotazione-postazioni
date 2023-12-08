package it.linksmt.prenotazione.postazioni.core.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.linksmt.prenotazione.postazioni.core.converter.UtenteConverter;
import it.linksmt.prenotazione.postazioni.core.dto.UtenteDto;
import it.linksmt.prenotazione.postazioni.core.exceptions.InvalidValueException;
import it.linksmt.prenotazione.postazioni.core.exceptions.MissingValueException;
import it.linksmt.prenotazione.postazioni.core.filters.UtenteFilter;
import it.linksmt.prenotazione.postazioni.core.model.Postazione;
import it.linksmt.prenotazione.postazioni.core.model.Prenotazione;
import it.linksmt.prenotazione.postazioni.core.model.Stanza;
import it.linksmt.prenotazione.postazioni.core.model.Ufficio;
import it.linksmt.prenotazione.postazioni.core.model.Utente;
import it.linksmt.prenotazione.postazioni.core.repository.PostazioneRepository;
import it.linksmt.prenotazione.postazioni.core.repository.StanzaRepository;
import it.linksmt.prenotazione.postazioni.core.repository.UfficioRepository;
import it.linksmt.prenotazione.postazioni.core.repository.UtenteRepository;
import it.linksmt.prenotazione.postazioni.core.service.api.UtenteService;

/**
 * Implementazione del servizio UtenteService che gestisce le operazioni relative agli utenti.
 */
@Service
public class UtenteServiceImpl implements UtenteService {

	private static final String NOME_ENTITA = "Utente";

	@Autowired
	private UtenteRepository utenteRepository;

	@Autowired
	private PostazioneRepository postazioneRepository;

	@Autowired
	private StanzaRepository stanzaRepository;

	@Autowired
	private UfficioRepository ufficioRepository;

	@Autowired
	private UtenteConverter utenteConverter;

	@Autowired
	private EntityManager entityManager;

	/**
	 * Trova un utente dato il suo ID.
	 *
	 * @param id L'ID dell'utente da cercare.
	 * @return Il DTO dell'utente trovato.
	 * @throws MissingValueException se l'utente non viene trovato.
	 * @throws InvalidValueException se l'ID è nullo o negativo.
	 */
	@Override
	public UtenteDto findUtenteById(Long id) throws MissingValueException, InvalidValueException {

		checkId(id);

		return utenteConverter.toDto(takeUser(id));

	}

	/**
	 * Salva un nuovo utente.
	 *
	 * @param utenteDto Il DTO dell'utente da salvare.
	 * @return Il DTO dell'utente salvato.
	 * @throws InvalidValueException se il DTO contiene valori non validi.
	 */
	@Override
	public UtenteDto saveUtente(UtenteDto utenteDto) throws InvalidValueException {

		validateDto(utenteDto);

		return utenteConverter.toDto(utenteRepository.save(utenteConverter.toEntity(utenteDto)));

	}

	/**
	 * Restituisce la lista di tutti gli utenti.
	 *
	 * @return La lista di DTO degli utenti.
	 */
	@Override
	public List<UtenteDto> getUtenti() {

		List<Utente> utenti = (List<Utente>) utenteRepository.findAll();
		return utenti	.parallelStream()
						.map(utenteConverter::toDto)
						.collect(Collectors.toList());
	}

	/**
	 * Rimuove un utente dato il suo ID.
	 *
	 * @param id L'ID dell'utente da rimuovere.
	 * @return True se l'utente viene rimosso con successo, false altrimenti.
	 * @throws InvalidValueException se l'ID è nullo o negativo.
	 * @throws MissingValueException se l'utente non viene trovato.
	 */
	@Override
	public boolean removeUtente(Long id) throws InvalidValueException, MissingValueException {

		checkId(id);

		if (!utenteRepository.existsById(id))
			throw new MissingValueException(NOME_ENTITA, id);

		utenteRepository.deleteById(id);

		return !utenteRepository.existsById(id);

	}

	/**
	 * Aggiorna le informazioni di un utente esistente.
	 *
	 * @param utenteDto Il DTO dell'utente da aggiornare.
	 * @return Il DTO dell'utente aggiornato.
	 * @throws InvalidValueException se il DTO contiene valori non validi.
	 * @throws MissingValueException se l'utente non viene trovato.
	 */
	@Override
	public UtenteDto updateUtente(UtenteDto utenteDto)
			throws InvalidValueException, MissingValueException {

		if (utenteDto.getId() == null || utenteDto.getId() < 0)
			throw new InvalidValueException("id", utenteDto.getId());

		if (!utenteRepository.existsById(utenteDto.getId()))
			throw new MissingValueException(NOME_ENTITA, utenteDto.getId());

		validateDto(utenteDto);

		return utenteConverter.toDto(utenteRepository.save(utenteConverter.toEntity(utenteDto)));

	}

	/**
	 * Rimuove tutti gli utenti.
	 *
	 * @return True se la rimozione è completata con successo, false altrimenti.
	 */
	@Override
	public boolean removeAll() {

		utenteRepository.deleteAll();
		return utenteRepository.count() == 0;
	}

	/**
	 * Filtra gli utenti in base ai criteri specificati nel filtro.
	 *
	 * @param filter Il filtro per la ricerca degli utenti.
	 * @return La lista filtrata di DTO degli utenti.
	 * @throws MissingValueException se si verificano valori mancanti durante la ricerca.
	 */
	@Override
	public List<UtenteDto> filter(UtenteFilter filter) throws MissingValueException {

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Prenotazione> criteriaQuery = criteriaBuilder.createQuery(Prenotazione.class);
		List<Predicate> predicates = new ArrayList<>();
		Root<Prenotazione> prenotazioneRoot = criteriaQuery.from(Prenotazione.class);
		Join<Utente, Prenotazione> utenteJoin = prenotazioneRoot.join("utente");

		// Filtro: Utenti prenotati in una determinata data
		if (filter.getDataPrenotazione() != null) {
			Predicate giornoPredicate
					= criteriaBuilder.equal(
							utenteJoin.get("dataPrenotazione"),
							filter.getDataPrenotazione()
					);
			predicates.add(giornoPredicate);
		}

		// Filtro: Utenti prenotati in un determinato periodo
		if (filter.getInizioPeriodo() != null && filter.getFinePeriodo() != null) {
			Predicate periodoPredicate
					= criteriaBuilder.between(
							utenteJoin.get("dataPrenotazione"),
							filter.getInizioPeriodo(),
							filter.getFinePeriodo()
					);
			predicates.add(periodoPredicate);
		}

		// Filtro: Utenti che hanno prenotato una determinata Postazione
		if (filter.getPostazioneId() != null) {
			Long postazioneId = filter.getPostazioneId();
			Optional<Postazione> postazioneOptional = postazioneRepository.findById(postazioneId);

			if (postazioneOptional.isEmpty())
				throw new MissingValueException("Postazione", postazioneId);

			Predicate postazionePredicate
					= criteriaBuilder.equal(utenteJoin.get("postazione"), postazioneOptional.get());
			predicates.add(postazionePredicate);
		}

		// Filtro: Utenti che hanno prenotato in una determinata Stanza
		if (filter.getStanzaId() != null) {
			Long stanzaId = filter.getStanzaId();
			Optional<Stanza> stanzaOptional = stanzaRepository.findById(stanzaId);

			if (stanzaOptional.isEmpty())
				throw new MissingValueException("Stanza", stanzaId);

			Predicate stanzaPredicate
					= criteriaBuilder.equal(
							utenteJoin	.get("postazione")
										.get("stanza"),
							stanzaOptional.get()
					);
			predicates.add(stanzaPredicate);
		}

		// Filtro: Utenti che hanno prenotato in un determinato Ufficio
		if (filter.getUfficioId() != null) {
			Long ufficioId = filter.getUfficioId();
			Optional<Ufficio> ufficiOptional = ufficioRepository.findById(ufficioId);

			if (ufficiOptional.isEmpty())
				throw new MissingValueException("Ufficio", ufficioId);

			Predicate ufficioPredicate
					= criteriaBuilder.equal(
							utenteJoin	.get("postazione")
										.get("stanza")
										.get("ufficio"),
							ufficiOptional.get()
					);
			predicates.add(ufficioPredicate);
		}

		// Filtro: username dell'Utente
		if (filter.getUsername() != null) {

			Predicate usernamePredicate
					= criteriaBuilder.like(
							utenteJoin.get("username"),
							"%" + filter.getUsername() + "%"
					);
			predicates.add(usernamePredicate);
		}

		// Filtro: ruolo dell'Utente
		if (filter.getRuolo() != null) {

			Predicate ruoloPredicate
					= criteriaBuilder.like(utenteJoin.get("ruolo"), "%" + filter.getRuolo() + "%");
			predicates.add(ruoloPredicate);
		}

		criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
		TypedQuery<Prenotazione> query = entityManager.createQuery(criteriaQuery);

		return query.getResultList()
					.stream()
					.map(Prenotazione::getUtente)
					.distinct()
					.map(utenteConverter::toDto)
					.sorted(Comparator.comparingLong(UtenteDto::getId))
					.collect(Collectors.toList());
	}

	/**
	 * (Funzione estratta) Controlla se i campi obbligatori del DTO non sono nulli.
	 *
	 * @param utenteDto Il DTO dell'utente da validare.
	 * @throws InvalidValueException se uno dei campi obbligatori è nullo.
	 */
	private void validateDto(UtenteDto utenteDto) throws InvalidValueException {
		if (utenteDto.getUsername() == null)
			throw new InvalidValueException("username", utenteDto.getId());

		if (utenteDto.getPassword() == null)
			throw new InvalidValueException("password", utenteDto.getPassword());

		if (utenteDto.getRuolo() == null)
			throw new InvalidValueException("ruolo", utenteDto.getRuolo());
	}

	/**
	 * (Funzione estratta) Controlla se l'ID passato è nullo o minore di 0.
	 *
	 * @param id L'ID da controllare.
	 * @throws InvalidValueException se l'ID è nullo o negativo.
	 */
	private void checkId(Long id) throws InvalidValueException {
		if (id == null || id < 0)
			throw new InvalidValueException("id", id);
	}

	/**
	 * (Funzione estratta) Controlla se l'utente con l'ID passato esiste e lo restituisce.
	 *
	 * @param id L'ID dell'utente da cercare.
	 * @return L'utente trovato.
	 * @throws MissingValueException se l'utente non viene trovato.
	 */
	private Utente takeUser(Long id) throws MissingValueException {
		Optional<Utente> utenteOptional = utenteRepository.findById(id);

		if (utenteOptional.isEmpty())
			throw new MissingValueException(NOME_ENTITA, id);
		return utenteOptional.get();
	}

}
