package it.linksmt.prenotazione.postazioni.core.service.api;

import java.util.List;
import it.linksmt.prenotazione.postazioni.core.dto.UtenteDto;
import it.linksmt.prenotazione.postazioni.core.exceptions.InvalidValueException;
import it.linksmt.prenotazione.postazioni.core.exceptions.MissingValueException;
import it.linksmt.prenotazione.postazioni.core.filters.UtenteFilter;

/**
 * Interfaccia per gestire le operazioni relative agli utenti.
 */
public interface UtenteService {

	/**
	 * Trova un utente per ID.
	 *
	 * @param id Identificativo univoco dell'utente.
	 * @return UtenteDto rappresentante dell'utente trovato.
	 * @throws MissingValueException Se l'utente non è stato trovato.
	 * @throws InvalidValueException Se l'ID fornito è invalido.
	 */
	public UtenteDto findUtenteById(Long id) throws MissingValueException, InvalidValueException;

	/**
	 * Salva un nuovo utente.
	 *
	 * @param utente UtenteDto da salvare.
	 * @return UtenteDto rappresentante dell'utente salvato.
	 * @throws InvalidValueException Se i valori dell'utente sono invalidi.
	 */
	public UtenteDto saveUtente(UtenteDto utente) throws InvalidValueException;

	/**
	 * Aggiorna un utente esistente.
	 *
	 * @param utente UtenteDto da aggiornare.
	 * @return UtenteDto rappresentante dell'utente aggiornato.
	 * @throws InvalidValueException Se i valori dell'utente sono invalidi.
	 * @throws MissingValueException Se l'utente da aggiornare non è stato trovato.
	 */
	public UtenteDto updateUtente(UtenteDto utente)
			throws InvalidValueException, MissingValueException;

	/**
	 * Ottiene la lista di tutti gli utenti.
	 *
	 * @return Lista di UtenteDto rappresentanti degli utenti disponibili.
	 */
	public List<UtenteDto> getUtenti();

	/**
	 * Rimuove un utente per ID.
	 *
	 * @param id Identificativo univoco dell'utente da rimuovere.
	 * @return true se l'utente è stato rimosso con successo, false altrimenti.
	 * @throws InvalidValueException Se l'ID fornito è invalido.
	 * @throws MissingValueException Se l'utente da rimuovere non è stato trovato.
	 */
	public boolean removeUtente(Long id) throws InvalidValueException, MissingValueException;

	/**
	 * Rimuove tutti gli utenti.
	 *
	 * @return true se tutti gli utenti sono stati rimossi con successo, false altrimenti.
	 */
	public boolean removeAll();

	/**
	 * Filtra gli utenti in base ai criteri specificati nel filtro.
	 *
	 * @param filter Filtro per gli utenti.
	 * @return Lista di UtenteDto rappresentanti degli utenti filtrati.
	 * @throws MissingValueException Se il filtro contiene valori mancanti.
	 */
	public List<UtenteDto> filter(UtenteFilter filter) throws MissingValueException;
}
