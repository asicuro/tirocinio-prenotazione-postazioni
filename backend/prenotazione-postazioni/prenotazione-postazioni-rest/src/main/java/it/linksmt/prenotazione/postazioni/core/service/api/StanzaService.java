package it.linksmt.prenotazione.postazioni.core.service.api;

import java.util.List;

import it.linksmt.prenotazione.postazioni.core.dto.StanzaDto;
import it.linksmt.prenotazione.postazioni.core.exceptions.InvalidValueException;

public interface StanzaService {

	public StanzaDto findStanzaById(Long id);

	public StanzaDto saveStanza(StanzaDto stanza) throws InvalidValueException;

	public StanzaDto updateStanza(StanzaDto stanza) throws InvalidValueException;

	public List<StanzaDto> getStanze();

	public boolean removeStanza(Long id) throws InvalidValueException;
}
