package it.linksmt.prenotazione.postazioni.rest.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.linksmt.prenotazione.postazioni.rest.constants.PrenotazionePostzioniConst;

@Controller
@RequestMapping(PrenotazionePostzioniConst.USER_PATH)
public class UtenteController {
	
	@GetMapping(value = "/test", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<String> testController() {
				
		return ResponseEntity.ok("HELLO WORLD");
	}

}
