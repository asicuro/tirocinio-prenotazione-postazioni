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
	public ResponseEntity<PostazioneDto> getPostazioneDto(@PathVariable(value = "id") Long id) throws InvalidValueException, MissingValueException {
		return ResponseEntity.ok(postazioneService.findPostazioneById(id));
	}

	@PostMapping(value = "/save")
	public void savePostazione(@RequestBody PostazioneDto postazioneDto) throws InvalidValueException, MissingValueException {
		postazioneService.savePostazione(postazioneDto);
	}

	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PostazioneDto>> GetPostazioni() {
		return ResponseEntity.ok(postazioneService.getPostazioni());
	}

	@DeleteMapping(value = "/{id}")
	public void removePostazione(@PathVariable(value = "id") Long id) throws InvalidValueException, MissingValueException {
		postazioneService.removePostazione(id);
	}

	@PutMapping(value = "/{id}")
	public void updatePostazione(@RequestBody PostazioneDto postazioneDto) throws InvalidValueException, MissingValueException {
		postazioneService.updatePostazione(postazioneDto);
	}

}
