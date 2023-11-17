package it.linksmt.prenotazione.postazioni.core.service.api;

import it.linksmt.prenotazione.postazioni.core.dto.UtenteDto;

public interface UtenteService {
	
	public UtenteDto findUtenteById(Long id);
	public void saveUtente(UtenteDto utente);
}
