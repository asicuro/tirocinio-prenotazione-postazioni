package it.linksmt.prenotazione.postazioni.core.service.api;

import java.util.List;

import it.linksmt.prenotazione.postazioni.core.dto.UtenteDto;
import it.linksmt.prenotazione.postazioni.core.exceptions.InvalidValueException;

public interface UtenteService {

	public UtenteDto findUtenteById(Long id);

	public UtenteDto saveUtente(UtenteDto utente) throws InvalidValueException;

	public UtenteDto updateUtente(UtenteDto utente) throws InvalidValueException;

	public List<UtenteDto> getUtenti();

	public boolean removeUtente(Long id) throws InvalidValueException;
}