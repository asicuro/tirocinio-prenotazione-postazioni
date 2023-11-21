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
import it.linksmt.prenotazione.postazioni.core.service.api.UtenteService;
import it.linksmt.prenotazione.postazioni.rest.constants.PrenotazionePostzioniConst;

@RestController
@RequestMapping(PrenotazionePostzioniConst.USER_PATH)
public class UtenteController {

	@Autowired
	private UtenteService utenteService;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UtenteDto> getUtente(@PathVariable("id") Long id)
			throws MissingValueException, InvalidValueException {
		return ResponseEntity.ok(utenteService.findUtenteById(id));
	}

	@PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UtenteDto> saveUtente(@RequestBody UtenteDto utenteDto) throws InvalidValueException {
		return ResponseEntity.ok(utenteService.saveUtente(utenteDto));
	}

	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UtenteDto>> getUtenti() {
		return ResponseEntity.ok(utenteService.getUtenti());
	}

	@DeleteMapping(value = "/{id}")
	public boolean removeUtente(@PathVariable("id") Long id) throws InvalidValueException, MissingValueException {
		return utenteService.removeUtente(id);
	}

	@PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UtenteDto> updateUtente(@RequestBody UtenteDto utenteDto)
			throws InvalidValueException, MissingValueException {
		return ResponseEntity.ok(utenteService.updateUtente(utenteDto));
	}

}
