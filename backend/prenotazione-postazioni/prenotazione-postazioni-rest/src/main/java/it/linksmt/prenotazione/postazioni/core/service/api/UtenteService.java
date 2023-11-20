package it.linksmt.prenotazione.postazioni.core.service.api;

import java.util.List;

import it.linksmt.prenotazione.postazioni.core.dto.UtenteDto;

public interface UtenteService {

	public UtenteDto findUtenteById(Long id);

	public void saveUtente(UtenteDto utente);

	public List<UtenteDto> getUtenti();

	public void removeUtente(Long id);
}
