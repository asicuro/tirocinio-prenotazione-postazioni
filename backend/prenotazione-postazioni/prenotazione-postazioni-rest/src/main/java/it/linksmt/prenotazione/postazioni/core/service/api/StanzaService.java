package it.linksmt.prenotazione.postazioni.core.service.api;

import java.util.List;

import it.linksmt.prenotazione.postazioni.core.dto.StanzaDto;

public interface StanzaService {

	public StanzaDto findStanzaById(Long id);

	public void saveStanza(StanzaDto stanza);

	public List<StanzaDto> getStanze();
}
