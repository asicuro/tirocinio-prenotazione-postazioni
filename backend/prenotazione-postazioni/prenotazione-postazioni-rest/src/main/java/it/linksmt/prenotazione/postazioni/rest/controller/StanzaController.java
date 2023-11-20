package it.linksmt.prenotazione.postazioni.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.linksmt.prenotazione.postazioni.core.dto.StanzaDto;
import it.linksmt.prenotazione.postazioni.core.service.api.StanzaService;
import it.linksmt.prenotazione.postazioni.rest.constants.PrenotazionePostzioniConst;

@RestController
@RequestMapping(PrenotazionePostzioniConst.STANZA_PATH)
public class StanzaController {

	@Autowired
	StanzaService stanzaService;
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StanzaDto> getStanza(@PathVariable("id") Long id) {
		return ResponseEntity.ok(stanzaService.findStanzaById(id));
	}
	
	@PostMapping(value = "/save")
	public void saveStanza(@RequestBody StanzaDto stanzaDto) {
		stanzaService.saveStanza(stanzaDto);
	}
}
