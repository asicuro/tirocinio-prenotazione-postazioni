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
import it.linksmt.prenotazione.postazioni.core.dto.UtenteDto;
import it.linksmt.prenotazione.postazioni.core.exceptions.InvalidValueException;
import it.linksmt.prenotazione.postazioni.core.exceptions.MissingValueException;
import it.linksmt.prenotazione.postazioni.core.filters.UtenteFilter;
import it.linksmt.prenotazione.postazioni.core.service.api.UtenteService;
import it.linksmt.prenotazione.postazioni.rest.constants.PrenotazionePostzioniConst;

/**
 * Controller per gestire le operazioni relative agli utenti.
 */
@RestController
@RequestMapping(PrenotazionePostzioniConst.USER_PATH)
public class UtenteController {

	@Autowired
	private UtenteService utenteService;

	/**
	 * Ottiene un utente per ID.
	 *
	 * @param id Identificativo univoco dell'utente.
	 * @return ResponseEntity contenente l'utente trovato.
	 * @throws MissingValueException Se l'utente non è stato trovato.
	 * @throws InvalidValueException Se l'ID fornito è invalido.
	 */
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UtenteDto> getUtente(@PathVariable("id") Long id)
			throws MissingValueException, InvalidValueException {
		return ResponseEntity.ok(utenteService.findUtenteById(id));
	}

	/**
	 * Salva un nuovo utente.
	 *
	 * @param utenteDto UtenteDto da salvare.
	 * @return ResponseEntity contenente l'utente salvato.
	 * @throws InvalidValueException Se i valori dell'utente sono invalidi.
	 */
	@PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UtenteDto> saveUtente(@RequestBody UtenteDto utenteDto)
			throws InvalidValueException {
		return ResponseEntity.ok(utenteService.saveUtente(utenteDto));
	}

	/**
	 * Ottiene la lista di tutti gli utenti.
	 *
	 * @return ResponseEntity contenente la lista di utenti.
	 */
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UtenteDto>> getUtenti() {
		return ResponseEntity.ok(utenteService.getUtenti());
	}

	/**
	 * Rimuove un utente per ID.
	 *
	 * @param id Identificativo univoco dell'utente da rimuovere.
	 * @return true se l'utente è stato rimosso con successo, false altrimenti.
	 * @throws InvalidValueException Se l'ID fornito è invalido.
	 * @throws MissingValueException Se l'utente da rimuovere non è stato trovato.
	 */
	@DeleteMapping(value = "/{id}")
	public boolean removeUtente(@PathVariable("id") Long id)
			throws InvalidValueException, MissingValueException {
		return utenteService.removeUtente(id);
	}

	/**
	 * Aggiorna un utente esistente.
	 *
	 * @param utenteDto UtenteDto da aggiornare.
	 * @return ResponseEntity contenente l'utente aggiornato.
	 * @throws InvalidValueException Se i valori dell'utente sono invalidi.
	 * @throws MissingValueException Se l'utente da aggiornare non è stato trovato.
	 */
	@PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UtenteDto> updateUtente(@RequestBody UtenteDto utenteDto)
			throws InvalidValueException, MissingValueException {
		return ResponseEntity.ok(utenteService.updateUtente(utenteDto));
	}

	/**
	 * Rimuove tutti gli utenti.
	 *
	 * @return true se tutti gli utenti sono stati rimossi con successo, false altrimenti.
	 */
	@DeleteMapping(value = "/all")
	public boolean removeAll() {
		return utenteService.removeAll();
	}

	/**
	 * Filtra gli utenti in base ai criteri specificati nel filtro.
	 *
	 * @param filter Filtro per gli utenti.
	 * @return ResponseEntity contenente la lista di utenti filtrati.
	 * @throws MissingValueException Se il filtro contiene valori mancanti.
	 */
	@PostMapping(value = "/filter", produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UtenteDto>> filter(@RequestBody UtenteFilter filter)
			throws MissingValueException {
		return ResponseEntity.ok(utenteService.filter(filter));
	}

}
