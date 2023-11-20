package it.linksmt.prenotazione.postazioni.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.linksmt.prenotazione.postazioni.core.dto.UfficioDto;
import it.linksmt.prenotazione.postazioni.core.service.api.UfficioService;
import it.linksmt.prenotazione.postazioni.rest.constants.PrenotazionePostzioniConst;

@RestController
@RequestMapping(PrenotazionePostzioniConst.UFFICIO_PATH)
public class UfficioController {

	@Autowired
	private UfficioService ufficioService;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UfficioDto> getUfficio(@PathVariable("id") Long id) {
		return ResponseEntity.ok(ufficioService.findUfficioById(id));
	}

	@PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createUfficio(@RequestBody UfficioDto ufficioDto) {
		ufficioService.saveUfficio(ufficioDto);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void deleteUfficio(@PathVariable("id") Long id) {
		ufficioService.removeUfficioById(id);
	}

	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UfficioDto>> getAllUfficio() {
		return ResponseEntity.ok(ufficioService.getUffici());

	}
}
