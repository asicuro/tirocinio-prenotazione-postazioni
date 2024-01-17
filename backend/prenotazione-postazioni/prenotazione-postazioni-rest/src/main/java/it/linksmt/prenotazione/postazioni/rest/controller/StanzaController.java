package it.linksmt.prenotazione.postazioni.rest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.linksmt.prenotazione.postazioni.core.dto.StanzaDto;
import it.linksmt.prenotazione.postazioni.core.exceptions.InvalidValueException;
import it.linksmt.prenotazione.postazioni.core.exceptions.MissingValueException;
import it.linksmt.prenotazione.postazioni.core.exceptions.NestedEntityException;
import it.linksmt.prenotazione.postazioni.core.filters.StanzaFilter;
import it.linksmt.prenotazione.postazioni.core.service.api.StanzaService;
import it.linksmt.prenotazione.postazioni.rest.constants.PrenotazionePostzioniConst;

/**
 * Controller per gestire le operazioni relative alle stanze.
 */
@RestController
@RequestMapping(PrenotazionePostzioniConst.STANZA_PATH)
public class StanzaController {

	@Autowired
	StanzaService stanzaService;

	/**
	 * Ottiene una stanza per ID.
	 *
	 * @param id Identificativo univoco della stanza.
	 * @return ResponseEntity contenente la stanza trovata.
	 * @throws InvalidValueException Se l'ID fornito è invalido.
	 * @throws MissingValueException Se la stanza non è stata trovata.
	 */
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StanzaDto> getStanza(@PathVariable("id") Long id)
			throws InvalidValueException, MissingValueException {
		return ResponseEntity.ok(stanzaService.findStanzaById(id));
	}

	/**
	 * Salva una nuova stanza.
	 *
	 * @param stanzaDto La stanza da salvare.
	 * @param createUserId Identificativo univoco dell'utente che sta creando la stanza.
	 * @return ResponseEntity contenente la stanza salvata.
	 * @throws InvalidValueException Se i valori della stanza sono invalidi.
	 */
	@PostMapping(value = "/save/{createUserId}", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StanzaDto> saveStanza(
			@RequestBody StanzaDto stanzaDto,
			@PathVariable("createUserId") Long createUserId
	) throws InvalidValueException {
		return ResponseEntity.ok(stanzaService.saveStanza(stanzaDto, createUserId));
	}

	/**
	 * Ottiene la lista di tutte le stanze.
	 *
	 * @return ResponseEntity contenente la lista di stanze.
	 */
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<StanzaDto>> getStanze() {
		return ResponseEntity.ok(stanzaService.getStanze());
	}

	/**
	 * Rimuove una stanza per ID.
	 *
	 * @param id Identificativo univoco della stanza da rimuovere.
	 * @return ResponseEntity contenente un booleano indicante se la stanza è stata rimossa con
	 *         successo.
	 * @throws InvalidValueException Se l'ID fornito è invalido.
	 * @throws MissingValueException Se la stanza da rimuovere non è stata trovata.
	 * @throws NestedEntityException Se la stanza contiene entità nidificate.
	 */
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> removeStanza(@PathVariable("id") Long id)
			throws InvalidValueException, MissingValueException, NestedEntityException {
		return ResponseEntity.ok(stanzaService.removeStanza(id));
	}

	/**
	 * Aggiorna una stanza esistente.
	 *
	 * @param stanzaDto La stanza da aggiornare.
	 * @param editUserId Identificativo univoco dell'utente che sta modificando la stanza.
	 * @return ResponseEntity contenente la stanza aggiornata.
	 * @throws InvalidValueException Se i valori della stanza sono invalidi.
	 * @throws MissingValueException Se la stanza da aggiornare non è stata trovata.
	 */
	@PutMapping(value = "/update/{editUserId}", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StanzaDto> updateStanza(
			@RequestBody StanzaDto stanzaDto,
			@PathVariable("editUserId") Long editUserId
	) throws InvalidValueException, MissingValueException {
		return ResponseEntity.ok(stanzaService.updateStanza(stanzaDto, editUserId));
	}

	/**
	 * Rimuove tutte le stanze.
	 *
	 * @return true se tutte le stanze sono state rimosse con successo, false altrimenti.
	 */
	@DeleteMapping(value = "/all")
	public boolean removeAll() {
		return stanzaService.removeAll();
	}

	/**
	 * Filtra le stanze in base ai criteri specificati nel filtro.
	 *
	 * @param filter Filtro per le stanze.
	 * @return ResponseEntity contenente la lista di stanze filtrate.
	 * @throws MissingValueException Se il filtro contiene valori mancanti.
	 */
	@PostMapping(value = "/filter", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<StanzaDto>> filter(@RequestBody StanzaFilter filter)
			throws MissingValueException {
		return ResponseEntity.ok(stanzaService.filter(filter));
	}
}
