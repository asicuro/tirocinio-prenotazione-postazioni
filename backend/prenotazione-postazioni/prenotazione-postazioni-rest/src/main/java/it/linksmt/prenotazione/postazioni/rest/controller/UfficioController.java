package it.linksmt.prenotazione.postazioni.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import it.linksmt.prenotazione.postazioni.core.dto.UfficioDto;
import it.linksmt.prenotazione.postazioni.core.service.impl.UfficioServiceImpl;
import it.linksmt.prenotazione.postazioni.rest.constants.PrenotazionePostzioniConst;

@Controller
@RequestMapping(PrenotazionePostzioniConst.UFFICIO_PATH)
public class UfficioController {
	
	@GetMapping(value = "/test", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<String> testController() {
				
		return ResponseEntity.ok("HELLO WORLD");
	}
	
	@Autowired
	UfficioServiceImpl ufficioServiceImpl;
	
	
	@GetMapping(value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public UfficioDto getUfficioById(@PathVariable(value = "id") Long id){
		
		return ufficioServiceImpl.findUfficiobyId(id);
		
	}
}
