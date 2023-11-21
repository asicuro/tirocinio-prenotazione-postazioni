package it.linksmt.prenotazione.postazioni.core.service.api;

import java.util.List;

import it.linksmt.prenotazione.postazioni.core.dto.StanzaDto;
import it.linksmt.prenotazione.postazioni.core.exceptions.InvalidValueException;
import it.linksmt.prenotazione.postazioni.core.exceptions.MissingValueException;

public interface StanzaService {

	public StanzaDto findStanzaById(Long id) throws InvalidValueException, MissingValueException;

	public StanzaDto saveStanza(StanzaDto stanza, Long createUserId) throws InvalidValueException;

	public StanzaDto updateStanza(StanzaDto stanza, Long editUserId) throws InvalidValueException, MissingValueException;

	public List<StanzaDto> getStanze();

	public boolean removeStanza(Long id) throws InvalidValueException, MissingValueException;

	public boolean removeAll();
}
