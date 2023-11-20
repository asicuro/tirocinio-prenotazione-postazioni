package it.linksmt.prenotazione.postazioni.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.linksmt.prenotazione.postazioni.core.dto.UtenteDto;
import it.linksmt.prenotazione.postazioni.core.service.api.UtenteService;
import it.linksmt.prenotazione.postazioni.rest.constants.PrenotazionePostzioniConst;

@RestController
@RequestMapping(PrenotazionePostzioniConst.USER_PATH)
public class UtenteController {
	
	@Autowired
	private UtenteService utenteService;
		
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UtenteDto> getUtente(@PathVariable("id") Long id) {
		return ResponseEntity.ok(utenteService.findUtenteById(id));
	}
	
	@GetMapping(value = "/test", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<String> test() {
		return ResponseEntity.ok("HELLO WORLD");
	}

}
