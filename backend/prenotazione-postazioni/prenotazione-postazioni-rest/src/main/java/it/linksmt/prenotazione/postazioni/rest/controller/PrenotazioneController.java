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

import it.linksmt.prenotazione.postazioni.core.dto.PrenotazioneDto;
import it.linksmt.prenotazione.postazioni.core.exceptions.InvalidValueException;
import it.linksmt.prenotazione.postazioni.core.exceptions.MissingValueException;
import it.linksmt.prenotazione.postazioni.core.service.api.PrenotazioneService;
import it.linksmt.prenotazione.postazioni.rest.constants.PrenotazionePostzioniConst;

@RestController
@RequestMapping(PrenotazionePostzioniConst.PRENOTAZIONE_PATH)
public class PrenotazioneController {

	@Autowired
	PrenotazioneService prenotazioneService;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PrenotazioneDto> getPrenotazioneDtoEntity(@PathVariable(value = "id") Long id)
			throws InvalidValueException, MissingValueException {
		return ResponseEntity.ok(prenotazioneService.findPrenotazioneById(id));
	}

	@PostMapping(value = "/save/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PrenotazioneDto> savePrenotazione(@RequestBody PrenotazioneDto prenotazioneDto,
			@PathVariable(value = "id") Long id) throws InvalidValueException, MissingValueException {
		return ResponseEntity.ok(prenotazioneService.savePrenotazione(prenotazioneDto, id));
	}

	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PrenotazioneDto>> getPrenotazioni() {
		return ResponseEntity.ok(prenotazioneService.getPrenotazione());
	}

	@DeleteMapping(value = "/{id}")
	public boolean removePrenotazione(@PathVariable(value = "id") Long id)
			throws InvalidValueException, MissingValueException {
		return prenotazioneService.removePrenotazione(id);
	}

	@PutMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PrenotazioneDto> updatePrenotazione(@RequestBody PrenotazioneDto prenotazioneDto,
			@PathVariable(value = "id") Long id) throws InvalidValueException, MissingValueException {
		return ResponseEntity.ok(prenotazioneService.updatePrenotazione(prenotazioneDto, id));
	}

	@DeleteMapping(value = "/all")
	public boolean removeAll() {
		return prenotazioneService.removeAll();
	}
}
