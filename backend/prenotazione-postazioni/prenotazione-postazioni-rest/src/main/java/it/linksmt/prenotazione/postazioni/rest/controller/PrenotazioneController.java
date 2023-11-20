package it.linksmt.prenotazione.postazioni.rest.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import it.linksmt.prenotazione.postazioni.core.dto.PrenotazioneDto;
import it.linksmt.prenotazione.postazioni.core.service.api.PrenotazioneService;
import it.linksmt.prenotazione.postazioni.rest.constants.PrenotazionePostzioniConst;

@Controller
@RequestMapping (PrenotazionePostzioniConst.PRENOTAZIONE_PATH)
public class PrenotazioneController {

	@Autowired
	PrenotazioneService prenotazioneService;
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<PrenotazioneDto> getPrenotazioneDtoEntity(@PathVariable(value="id")Long id){
		return ResponseEntity.ok(prenotazioneService.findPrenotazioneById(id));		
	}
}
