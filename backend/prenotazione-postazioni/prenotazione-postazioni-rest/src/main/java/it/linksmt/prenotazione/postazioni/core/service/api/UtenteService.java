package it.linksmt.prenotazione.postazioni.core.service.api;

import org.springframework.stereotype.Service;

import it.linksmt.prenotazione.postazioni.core.dto.UtenteDto;

@Service
public interface UtenteService {
	
	public UtenteDto findUtente(Long id);
}
