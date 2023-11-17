package it.linksmt.prenotazione.postazioni.core.service.api;

import it.linksmt.prenotazione.postazioni.core.dto.StanzaDto;

public interface StanzaService {

	public StanzaDto finStanzaById(Long id);
	public void saveStanza(StanzaDto stanza);
}
