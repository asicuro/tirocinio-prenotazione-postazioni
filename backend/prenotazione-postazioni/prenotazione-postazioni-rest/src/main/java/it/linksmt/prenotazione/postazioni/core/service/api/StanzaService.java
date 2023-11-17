package it.linksmt.prenotazione.postazioni.core.service.api;

import org.springframework.stereotype.Service;

import it.linksmt.prenotazione.postazioni.core.dto.StanzaDto;

@Service
public interface StanzaService {

	public StanzaDto finStanzaById(Long id);
}
