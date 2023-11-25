package it.linksmt.prenotazione.postazioni.core.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.linksmt.prenotazione.postazioni.core.converter.StanzaConverter;
import it.linksmt.prenotazione.postazioni.core.dto.StanzaDto;
import it.linksmt.prenotazione.postazioni.core.exceptions.InvalidValueException;
import it.linksmt.prenotazione.postazioni.core.exceptions.MissingValueException;
import it.linksmt.prenotazione.postazioni.core.exceptions.NestedEntityException;
import it.linksmt.prenotazione.postazioni.core.model.Stanza;
import it.linksmt.prenotazione.postazioni.core.model.Ufficio;
import it.linksmt.prenotazione.postazioni.core.repository.StanzaRepository;
import it.linksmt.prenotazione.postazioni.core.repository.UfficioRepository;
import it.linksmt.prenotazione.postazioni.core.service.api.StanzaService;

@Service
public class StanzaServiceImpl implements StanzaService {

  private static final String NOME_ENTITA = "Stanza";

  @Autowired
  private StanzaRepository stanzaRepository;

  @Autowired
  private StanzaConverter stanzaConverter;

  @Autowired
  private UfficioRepository ufficioRepository;

  @Override
  public StanzaDto findStanzaById(Long id) throws InvalidValueException, MissingValueException {

    checkId(id);

    return stanzaConverter.toDto(takeStanza(id));
  }

  @Override
  public StanzaDto saveStanza(StanzaDto stanzaDto, Long createUserId) throws InvalidValueException {

    validateDto(stanzaDto);

    stanzaDto.setCreateDate(new Date());
    stanzaDto.setCreateUserId(createUserId);

    return stanzaConverter.toDto(stanzaRepository.save(stanzaConverter.toEntity(stanzaDto)));
  }

  @Override
  public List<StanzaDto> getStanze() {

    List<Stanza> stanze = (List<Stanza>) stanzaRepository.findAll();
    return stanze.parallelStream()
                 .map(stanzaConverter::toDto)
                 .collect(Collectors.toList());
  }

  @Override
  public boolean removeStanza(Long id)
      throws InvalidValueException, MissingValueException, NestedEntityException {

    checkId(id);

    Stanza stanza = takeStanza(id);
    if (!stanza.getPostazioni()
               .isEmpty())
      throw new NestedEntityException(NOME_ENTITA, id);

    stanzaRepository.deleteById(id);
    return !stanzaRepository.existsById(id);
  }

  @Override
  public StanzaDto updateStanza(StanzaDto stanzaDto, Long editUserId)
      throws InvalidValueException, MissingValueException {

    if (stanzaDto.getId() == null || stanzaDto.getId() < 0)
      throw new InvalidValueException("id", stanzaDto.getId());

    Stanza stanza = takeStanza(stanzaDto.getId());

    validateDto(stanzaDto);

    stanzaDto.setCreateDate(stanza.getCreateDate())
             .setCreateUserId(stanza.getCreateUserId())
             .setEditDate(new Date())
             .setEditUserId(editUserId);

    return stanzaConverter.toDto(stanzaRepository.save(stanzaConverter.toEntity(stanzaDto)));

  }

  @Override
  public boolean removeAll() {

    stanzaRepository.deleteAll();

    return stanzaRepository.count() == 0;
  }

  @Override
  public List<StanzaDto> getStanzeByUfficioId(Long idUfficio)
      throws InvalidValueException, MissingValueException {

    checkId(idUfficio);

    List<Stanza> stanze = stanzaRepository.findByUfficio(takeUfficio(idUfficio));

    return stanze.parallelStream()
                 .map(stanzaConverter::toDto)
                 .collect(Collectors.toList());
  }

  /** Controlla se i campi del DTO non sono nulli */
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

  /** Controlla se l'id passato è nullo o minore di 0 */
  private void checkId(Long id) throws InvalidValueException {
    if (id == null || id < 0)
      throw new InvalidValueException("id", id);
  }

  /** Controlla se la stanza con l'id passato esiste e la ritorna */
  private Stanza takeStanza(Long id) throws MissingValueException {
    Optional<Stanza> stanzaOptional = stanzaRepository.findById(id);

    if (stanzaOptional.isEmpty())
      throw new MissingValueException(NOME_ENTITA, id);
    return stanzaOptional.get();
  }

  /** Controlla se l'ufficio con l'id passato esiste e lo ritorna */
  private Ufficio takeUfficio(Long idUfficio) throws MissingValueException {
    Optional<Ufficio> ufficioOptional = ufficioRepository.findById(idUfficio);
    if (ufficioOptional.isEmpty())
      throw new MissingValueException("Ufficio", idUfficio);
    return ufficioOptional.get();
  }

}
