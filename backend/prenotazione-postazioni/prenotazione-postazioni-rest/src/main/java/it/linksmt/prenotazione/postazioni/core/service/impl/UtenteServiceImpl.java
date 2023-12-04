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

  @Override
  public UtenteDto findUtenteById(Long id) throws MissingValueException, InvalidValueException {

    checkId(id);

    return utenteConverter.toDto(takeUser(id));

  }

  @Override
  public UtenteDto saveUtente(UtenteDto utenteDto) throws InvalidValueException {

    validateDto(utenteDto);

    return utenteConverter.toDto(utenteRepository.save(utenteConverter.toEntity(utenteDto)));

  }

  @Override
  public List<UtenteDto> getUtenti() {

    List<Utente> utenti = (List<Utente>) utenteRepository.findAll();
    return utenti.parallelStream()
                 .map(utenteConverter::toDto)
                 .collect(Collectors.toList());
  }

  @Override
  public boolean removeUtente(Long id) throws InvalidValueException, MissingValueException {

    checkId(id);

    if (!utenteRepository.existsById(id))
      throw new MissingValueException(NOME_ENTITA, id);

    utenteRepository.deleteById(id);

    return !utenteRepository.existsById(id);

  }

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

  @Override
  public boolean removeAll() {

    utenteRepository.deleteAll();
    return utenteRepository.count() == 0;
  }

  @Override
  public List<UtenteDto> filter(UtenteFilter filter) throws MissingValueException {

    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Prenotazione> criteriaQuery = criteriaBuilder.createQuery(Prenotazione.class);
    List<Predicate> predicates = new ArrayList<>();
    Root<Prenotazione> prenotazioneRoot = criteriaQuery.from(Prenotazione.class);
    Join<Utente, Prenotazione> utenteJoin = prenotazioneRoot.join("utente");

    if (filter.getDataPrenotazione() != null) {
      Predicate giornoPredicate =
          criteriaBuilder.equal(utenteJoin.get("dataPrenotazione"), filter.getDataPrenotazione());
      predicates.add(giornoPredicate);
    }

    if (filter.getInizioPeriodo() != null && filter.getFinePeriodo() != null) {
      Predicate periodoPredicate = criteriaBuilder.between(
          utenteJoin.get("dataPrenotazione"),
          filter.getInizioPeriodo(),
          filter.getFinePeriodo()
      );
      predicates.add(periodoPredicate);
    }

    if (filter.getPostazioneId() != null) {
      Long postazioneId = filter.getPostazioneId();
      Optional<Postazione> postazioneOptional = postazioneRepository.findById(postazioneId);

      if (postazioneOptional.isEmpty())
        throw new MissingValueException("Postazione", postazioneId);

      Predicate postazionePredicate =
          criteriaBuilder.equal(utenteJoin.get("postazione"), postazioneOptional.get());
      predicates.add(postazionePredicate);
    }

    if (filter.getStanzaId() != null) {
      Long stanzaId = filter.getStanzaId();
      Optional<Stanza> stanzaOptional = stanzaRepository.findById(stanzaId);

      if (stanzaOptional.isEmpty())
        throw new MissingValueException("Stanza", stanzaId);

      Predicate stanzaPredicate = criteriaBuilder.equal(
          utenteJoin.get("postazione")
                    .get("stanza"),
          stanzaOptional.get()
      );
      predicates.add(stanzaPredicate);
    }

    if (filter.getUfficioId() != null) {
      Long ufficioId = filter.getUfficioId();
      Optional<Ufficio> ufficiOptional = ufficioRepository.findById(ufficioId);

      if (ufficiOptional.isEmpty())
        throw new MissingValueException("Ufficio", ufficioId);

      Predicate ufficioPredicate = criteriaBuilder.equal(
          utenteJoin.get("postazione")
                    .get("stanza")
                    .get("ufficio"),
          ufficiOptional.get()
      );
      predicates.add(ufficioPredicate);
    }

    if (filter.getUsername() != null) {

      Predicate usernamePredicate =
          criteriaBuilder.like(utenteJoin.get("username"), "%" + filter.getUsername() + "%");
      predicates.add(usernamePredicate);
    }

    if (filter.getRuolo() != null) {

      Predicate ruoloPredicate =
          criteriaBuilder.like(utenteJoin.get("ruolo"), "%" + filter.getRuolo() + "%");
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

  /** Controlla se l'Utente è presente nel DB */
  @Override
  public boolean isPresent(String username, String password) throws InvalidValueException {

    if (username == null)
      throw new InvalidValueException("username", username);
    if (password == null)
      throw new InvalidValueException("password", password);

    return !utenteRepository.findByUsernameAndPassword(username, password)
                            .isEmpty();
  }

  /** Controlla se i campi del DTO non sono nulli */
  private void validateDto(UtenteDto utenteDto) throws InvalidValueException {
    if (utenteDto.getUsername() == null)
      throw new InvalidValueException("username", utenteDto.getId());

    if (utenteDto.getPassword() == null)
      throw new InvalidValueException("password", utenteDto.getPassword());

    if (utenteDto.getRuolo() == null)
      throw new InvalidValueException("ruolo", utenteDto.getRuolo());
  }

  /** Controlla se l'id passato è nullo o minore di 0 */
  private void checkId(Long id) throws InvalidValueException {
    if (id == null || id < 0)
      throw new InvalidValueException("id", id);
  }

  /** Controlla se l'utente con l'id passato esiste e lo ritorna */
  private Utente takeUser(Long id) throws MissingValueException {
    Optional<Utente> utenteOptional = utenteRepository.findById(id);

    if (utenteOptional.isEmpty())
      throw new MissingValueException(NOME_ENTITA, id);
    return utenteOptional.get();
  }

}
