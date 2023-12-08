package it.linksmt.prenotazione.postazioni.core.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
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
import it.linksmt.prenotazione.postazioni.core.converter.StanzaConverter;
import it.linksmt.prenotazione.postazioni.core.dto.StanzaDto;
import it.linksmt.prenotazione.postazioni.core.exceptions.InvalidValueException;
import it.linksmt.prenotazione.postazioni.core.exceptions.MissingValueException;
import it.linksmt.prenotazione.postazioni.core.exceptions.NestedEntityException;
import it.linksmt.prenotazione.postazioni.core.filters.StanzaFilter;
import it.linksmt.prenotazione.postazioni.core.model.Postazione;
import it.linksmt.prenotazione.postazioni.core.model.Prenotazione;
import it.linksmt.prenotazione.postazioni.core.model.Stanza;
import it.linksmt.prenotazione.postazioni.core.model.Ufficio;
import it.linksmt.prenotazione.postazioni.core.model.Utente;
import it.linksmt.prenotazione.postazioni.core.repository.StanzaRepository;
import it.linksmt.prenotazione.postazioni.core.repository.UfficioRepository;
import it.linksmt.prenotazione.postazioni.core.repository.UtenteRepository;
import it.linksmt.prenotazione.postazioni.core.service.api.StanzaService;

/**
 * Implementazione del servizio StanzaService che gestisce le operazioni relative alle stanze.
 */
@Service
public class StanzaServiceImpl implements StanzaService {

	private static final String NOME_ENTITA = "Stanza";

	@Autowired
	private StanzaRepository stanzaRepository;

	@Autowired
	private UtenteRepository utenteRepository;

	@Autowired
	private StanzaConverter stanzaConverter;

	@Autowired
	private UfficioRepository ufficioRepository;

	@Autowired
	private EntityManager entityManager;

	/**
	 * Restituisce una stanza basata sull'ID specificato.
	 *
	 * @param id L'ID della stanza.
	 * @return La stanza corrispondente all'ID.
	 * @throws InvalidValueException Se l'ID è nullo o negativo.
	 * @throws MissingValueException Se la stanza non è trovata.
	 */
	@Override
	public StanzaDto findStanzaById(Long id) throws InvalidValueException, MissingValueException {

		checkId(id);

		return stanzaConverter.toDto(takeStanza(id));
	}

	/**
	 * Salva una nuova stanza.
	 *
	 * @param stanzaDto La stanza da salvare.
	 * @param createUserId L'ID dell'utente che crea la stanza.
	 * @return La stanza salvata.
	 * @throws InvalidValueException Se i valori della stanza sono invalidi.
	 */
	@Override
	public StanzaDto saveStanza(StanzaDto stanzaDto, Long createUserId)
			throws InvalidValueException {

		validateDto(stanzaDto);

		stanzaDto.setCreateDate(new Date());
		stanzaDto.setCreateUserId(createUserId);

		return stanzaConverter.toDto(stanzaRepository.save(stanzaConverter.toEntity(stanzaDto)));
	}

	/**
	 * Restituisce tutte le stanze.
	 *
	 * @return Lista di tutte le stanze.
	 */
	@Override
	public List<StanzaDto> getStanze() {

		List<Stanza> stanze = (List<Stanza>) stanzaRepository.findAll();
		return stanze	.parallelStream()
						.map(stanzaConverter::toDto)
						.collect(Collectors.toList());
	}

	/**
	 * Rimuove una stanza in base all'ID specificato.
	 *
	 * @param id L'ID della stanza da rimuovere.
	 * @return True se la stanza è stata rimossa con successo, altrimenti False.
	 * @throws InvalidValueException Se l'ID è nullo o negativo.
	 * @throws MissingValueException Se la stanza non è trovata.
	 * @throws NestedEntityException Se la stanza ha postazioni collegate.
	 */
	@Override
	public boolean removeStanza(Long id)
			throws InvalidValueException, MissingValueException, NestedEntityException {

		checkId(id);

		Stanza stanza = takeStanza(id);
		if (!stanza	.getPostazioni()
					.isEmpty())
			throw new NestedEntityException(NOME_ENTITA, id);

		stanzaRepository.deleteById(id);
		return !stanzaRepository.existsById(id);
	}

	/**
	 * Aggiorna una stanza esistente.
	 *
	 * @param stanzaDto La stanza da aggiornare.
	 * @param editUserId L'ID dell'utente che sta modificando la stanza.
	 * @return La stanza aggiornata.
	 * @throws InvalidValueException Se i valori della stanza sono invalidi.
	 * @throws MissingValueException Se la stanza non è trovata.
	 */
	@Override
	public StanzaDto updateStanza(StanzaDto stanzaDto, Long editUserId)
			throws InvalidValueException, MissingValueException {

		if (stanzaDto.getId() == null || stanzaDto.getId() < 0)
			throw new InvalidValueException("id", stanzaDto.getId());

		Stanza stanza = takeStanza(stanzaDto.getId());

		validateDto(stanzaDto);

		stanzaDto	.setCreateDate(stanza.getCreateDate())
					.setCreateUserId(stanza.getCreateUserId())
					.setEditDate(new Date())
					.setEditUserId(editUserId);

		return stanzaConverter.toDto(stanzaRepository.save(stanzaConverter.toEntity(stanzaDto)));

	}

	/**
	 * Rimuove tutte le stanze.
	 *
	 * @return True se tutte le stanze sono state rimosse con successo, altrimenti False.
	 */
	@Override
	public boolean removeAll() {

		stanzaRepository.deleteAll();

		return stanzaRepository.count() == 0;
	}

	/**
	 * Filtra le stanze in base ai criteri specificati.
	 *
	 * @param filter Il filtro per le stanze.
	 * @return Lista di stanze filtrate.
	 * @throws MissingValueException Se mancano valori richiesti per il filtro.
	 */
	@Override
	public List<StanzaDto> filter(StanzaFilter filter) throws MissingValueException {

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Prenotazione> criteriaQuery = criteriaBuilder.createQuery(Prenotazione.class);
		List<Predicate> predicates = new ArrayList<>();
		Root<Prenotazione> prenotazioneRoot = criteriaQuery.from(Prenotazione.class);
		Join<Prenotazione, Postazione> postazioneJoin = prenotazioneRoot.join("postazione");
		Join<Postazione, Stanza> stanzaJoin = postazioneJoin.join("stanza");

		// Filtro: nome della Stanza
		if (filter.getName() != null) {

			Predicate namePredicate
					= criteriaBuilder.like(stanzaJoin.get("name"), "%" + filter.getName() + "%");
			predicates.add(namePredicate);
		}

		// Filtro: dimensioni della Stanza
		if (filter.getWidth() != null && filter.getHeight() != null) {

			Predicate dimensionPredicate
					= criteriaBuilder.and(
							criteriaBuilder.equal(stanzaJoin.get("width"), filter.getWidth()),
							criteriaBuilder.equal(stanzaJoin.get("height"), filter.getHeight())
					);
			predicates.add(dimensionPredicate);
		}

		// Filtro: Stanze usate da un Utente
		if (filter.getUtenteId() != null) {

			Long utenteId = filter.getUtenteId();
			Optional<Utente> utenteOptional = utenteRepository.findById(utenteId);

			if (utenteOptional.isEmpty())
				throw new MissingValueException("Utente", utenteId);

			Predicate utentePredicate
					= criteriaBuilder.equal(prenotazioneRoot.get("utente"), utenteOptional.get());
			predicates.add(utentePredicate);
		}

		// Filtro: Stanze contenute in un Ufficio
		if (filter.getUfficioId() != null) {

			Long ufficioId = filter.getUfficioId();
			Optional<Ufficio> ufficioOptional = ufficioRepository.findById(ufficioId);

			if (ufficioOptional.isEmpty())
				throw new MissingValueException("Ufficio", ufficioId);

			Predicate ufficioPredicate
					= criteriaBuilder.equal(
							prenotazioneRoot.get("postazione")
											.get("stanza")
											.get("ufficio"),
							ufficioOptional.get()
					);
			predicates.add(ufficioPredicate);
		}

		// Filtro: Stanze create da un Utente
		if (filter.getCreateUserId() != null) {

			Predicate createUserPredicate
					= criteriaBuilder.equal(
							stanzaJoin.get("createUserId"),
							filter.getCreateUserId()
					);
			predicates.add(createUserPredicate);
		}

		criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));

		TypedQuery<Prenotazione> prenotazioneTypedQuery = entityManager.createQuery(criteriaQuery);

		List<Prenotazione> prenotazioni = prenotazioneTypedQuery.getResultList();

		return prenotazioni	.stream()
							.map(Prenotazione::getPostazione)
							.map(Postazione::getStanza)
							.distinct()
							.map(stanzaConverter::toDto)
							.sorted(Comparator.comparingLong(StanzaDto::getId))
							.collect(Collectors.toList());
	}

	/**
	 * (Funzione estratta) Verifica se i valori della stanza sono validi.
	 *
	 * @param stanza La stanza da validare.
	 * @throws InvalidValueException Se uno dei valori è nullo o invalido.
	 */
	private void validateDto(StanzaDto stanza) throws InvalidValueException {
		if (stanza.getNome() == null)
			throw new InvalidValueException("nome", stanza.getNome());

		if (stanza.getWidth() == null)
			throw new InvalidValueException("width", stanza.getWidth());

		if (stanza.getHeight() == null)
			throw new InvalidValueException("height", stanza.getHeight());

		if (stanza.getX() == null)
			throw new InvalidValueException("x", stanza.getX());

		if (stanza.getY() == null)
			throw new InvalidValueException("y", stanza.getY());

		if (stanza.getUfficioId() == null)
			throw new InvalidValueException("ufficioId", stanza.getUfficioId());
	}

	/**
	 * (Funzione estratta) Verifica se l'ID è valido.
	 *
	 * @param id L'ID da verificare.
	 * @throws InvalidValueException Se l'ID è nullo o negativo.
	 */
	private void checkId(Long id) throws InvalidValueException {
		if (id == null || id < 0)
			throw new InvalidValueException("id", id);
	}

	/**
	 * (Funzione estratta) Restituisce una stanza basata sull'ID specificato.
	 *
	 * @param id L'ID della stanza.
	 * @return La stanza corrispondente all'ID.
	 * @throws MissingValueException Se la stanza non è trovata.
	 */
	private Stanza takeStanza(Long id) throws MissingValueException {
		Optional<Stanza> stanzaOptional = stanzaRepository.findById(id);

		if (stanzaOptional.isEmpty())
			throw new MissingValueException(NOME_ENTITA, id);
		return stanzaOptional.get();
	}
}
