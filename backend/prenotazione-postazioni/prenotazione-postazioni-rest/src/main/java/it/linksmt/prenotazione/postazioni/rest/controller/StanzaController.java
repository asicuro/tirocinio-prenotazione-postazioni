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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.linksmt.prenotazione.postazioni.core.dto.StanzaDto;
import it.linksmt.prenotazione.postazioni.core.exceptions.InvalidValueException;
import it.linksmt.prenotazione.postazioni.core.exceptions.MissingValueException;
import it.linksmt.prenotazione.postazioni.core.service.api.StanzaService;
import it.linksmt.prenotazione.postazioni.rest.constants.PrenotazionePostzioniConst;

@RestController
@RequestMapping(PrenotazionePostzioniConst.STANZA_PATH)
public class StanzaController {

	@Autowired
	StanzaService stanzaService;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StanzaDto> getStanza(@PathVariable("id") Long id)
			throws InvalidValueException, MissingValueException {
		return ResponseEntity.ok(stanzaService.findStanzaById(id));
	}

	@PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StanzaDto> saveStanza(@RequestBody StanzaDto stanzaDto,
			@RequestParam("createUserId") Long createUserId) throws InvalidValueException {
		return ResponseEntity.ok(stanzaService.saveStanza(stanzaDto, createUserId));
	}

	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<StanzaDto>> getStanze() {
		return ResponseEntity.ok(stanzaService.getStanze());
	}

	@DeleteMapping(value = "/{id}")
	public boolean removeStanza(@PathVariable("id") Long id) throws InvalidValueException, MissingValueException {
		return stanzaService.removeStanza(id);
	}

	@PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StanzaDto> updateStanza(@RequestBody StanzaDto stanzaDto,
			@RequestParam("updateUserId") Long updateUserId) throws InvalidValueException, MissingValueException {
		return ResponseEntity.ok(stanzaService.updateStanza(stanzaDto, updateUserId));
	}
}
