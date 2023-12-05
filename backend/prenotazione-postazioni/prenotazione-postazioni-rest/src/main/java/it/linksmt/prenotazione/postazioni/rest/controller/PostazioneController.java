package it.linksmt.prenotazione.postazioni.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.linksmt.prenotazione.postazioni.core.dto.PostazioneDto;
import it.linksmt.prenotazione.postazioni.core.exceptions.InvalidValueException;
import it.linksmt.prenotazione.postazioni.core.exceptions.MissingValueException;
import it.linksmt.prenotazione.postazioni.core.service.api.PostazioneService;
import it.linksmt.prenotazione.postazioni.rest.constants.PrenotazionePostzioniConst;

@RestController
@RequestMapping(PrenotazionePostzioniConst.POSTAZIONE_PATH)
public class PostazioneController {

	@Autowired
	PostazioneService postazioneService;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PostazioneDto> getPostazioneDto(@PathVariable(value = "id") Long id)
			throws InvalidValueException, MissingValueException {
		return ResponseEntity.ok(postazioneService.findPostazioneById(id));
	}

	@PostMapping(value = "/save/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('admin')")
	public ResponseEntity<PostazioneDto> savePostazione(@RequestBody PostazioneDto postazioneDto,
			@PathVariable(value = "id") Long id) throws InvalidValueException, MissingValueException {
		return ResponseEntity.ok(postazioneService.savePostazione(postazioneDto, id));
	}

	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PostazioneDto>> getPostazioni() {
		return ResponseEntity.ok(postazioneService.getPostazioni());
	}

	@DeleteMapping(value = "/{id}")
	@PreAuthorize("hasRole('admin')")
	public boolean removePostazione(@PathVariable(value = "id") Long id)
			throws InvalidValueException, MissingValueException {
		return postazioneService.removePostazione(id);
	}

	@PutMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('admin')")
	public ResponseEntity<PostazioneDto> updatePostazione(@RequestBody PostazioneDto postazioneDto,
			@PathVariable(value = "id") Long id) throws InvalidValueException, MissingValueException {
		return ResponseEntity.ok(postazioneService.updatePostazione(postazioneDto, id));
	}

	@DeleteMapping(value = "/all")
	@PreAuthorize("hasRole('admin')")
	public boolean removeAll() {
		return postazioneService.removeAll();
	}

	@GetMapping(value = "/all/{stanzaId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PostazioneDto>> getPostazioniByStanzaId(@PathVariable(value = "stanzaId") Long stanzaId)
			throws InvalidValueException, MissingValueException {
		return ResponseEntity.ok(postazioneService.getPostazioniByStanzaId(stanzaId));
	}

}
