package it.linksmt.prenotazione.postazioni.core.service.api;

import java.util.List;
import it.linksmt.prenotazione.postazioni.core.dto.StanzaDto;
import it.linksmt.prenotazione.postazioni.core.exceptions.InvalidValueException;
import it.linksmt.prenotazione.postazioni.core.exceptions.MissingValueException;
import it.linksmt.prenotazione.postazioni.core.exceptions.NestedEntityException;
import it.linksmt.prenotazione.postazioni.core.filters.StanzaFilter;

/**
 * Interfaccia per gestire le operazioni relative alle stanze.
 */
public interface StanzaService {

	/**
	 * Trova una stanza per ID.
	 *
	 * @param id Identificativo univoco della stanza.
	 * @return StanzaDto rappresentante della stanza trovata.
	 * @throws InvalidValueException Se l'ID fornito è invalido.
	 * @throws MissingValueException Se la stanza non è stata trovata.
	 */
	public StanzaDto findStanzaById(Long id) throws InvalidValueException, MissingValueException;

	/**
	 * Salva una nuova stanza.
	 *
	 * @param stanza La stanza da salvare.
	 * @param createUserId Identificativo univoco dell'utente che sta creando la stanza.
	 * @return StanzaDto rappresentante della stanza salvata.
	 * @throws InvalidValueException Se i valori della stanza sono invalidi.
	 */
	public StanzaDto saveStanza(StanzaDto stanza, Long createUserId) throws InvalidValueException;

	/**
	 * Aggiorna una stanza esistente.
	 *
	 * @param stanza La stanza da aggiornare.
	 * @param editUserId Identificativo univoco dell'utente che sta modificando la stanza.
	 * @return StanzaDto rappresentante della stanza aggiornata.
	 * @throws InvalidValueException Se i valori della stanza sono invalidi.
	 * @throws MissingValueException Se la stanza da aggiornare non è stata trovata.
	 */
	public StanzaDto updateStanza(StanzaDto stanza, Long editUserId)
			throws InvalidValueException, MissingValueException;

	/**
	 * Ottiene la lista di tutte le stanze.
	 *
	 * @return Lista di StanzaDto rappresentanti delle stanze disponibili.
	 */
	public List<StanzaDto> getStanze();

	/**
	 * Rimuove una stanza per ID.
	 *
	 * @param id Identificativo univoco della stanza da rimuovere.
	 * @return true se la stanza è stata rimossa con successo, false altrimenti.
	 * @throws InvalidValueException Se l'ID fornito è invalido.
	 * @throws MissingValueException Se la stanza da rimuovere non è stata trovata.
	 * @throws NestedEntityException Se la stanza contiene entità nidificate.
	 */
	public boolean removeStanza(Long id)
			throws InvalidValueException, MissingValueException, NestedEntityException;

	/**
	 * Rimuove tutte le stanze.
	 *
	 * @return true se tutte le stanze sono state rimosse con successo, false altrimenti.
	 */
	public boolean removeAll();

	/**
	 * Filtra le stanze in base ai criteri specificati nel filtro.
	 *
	 * @param filter Filtro per le stanze.
	 * @return Lista di StanzaDto rappresentanti delle stanze filtrate.
	 * @throws MissingValueException Se il filtro contiene valori mancanti.
	 */
	public List<StanzaDto> filter(StanzaFilter filter) throws MissingValueException;
}
