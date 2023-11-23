package it.linksmt.prenotazione.postazioni.core.service.api;

import java.util.List;

import it.linksmt.prenotazione.postazioni.core.dto.UtenteDto;
import it.linksmt.prenotazione.postazioni.core.exceptions.InvalidValueException;
import it.linksmt.prenotazione.postazioni.core.exceptions.MissingValueException;

public interface UtenteService {

	public UtenteDto findUtenteById(Long id) throws MissingValueException, InvalidValueException;

	public UtenteDto saveUtente(UtenteDto utente) throws InvalidValueException;

	public UtenteDto updateUtente(UtenteDto utente) throws InvalidValueException, MissingValueException;

	public List<UtenteDto> getUtenti();

	public boolean removeUtente(Long id) throws InvalidValueException, MissingValueException;

	public boolean removeAll();

	public boolean isPresent(String username, String password) throws InvalidValueException;
}