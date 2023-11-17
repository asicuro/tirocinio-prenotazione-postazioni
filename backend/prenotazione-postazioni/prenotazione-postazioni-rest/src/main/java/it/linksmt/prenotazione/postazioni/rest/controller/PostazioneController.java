package it.linksmt.prenotazione.postazioni.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import it.linksmt.prenotazione.postazioni.core.dto.PostazioneDto;
import it.linksmt.prenotazione.postazioni.core.service.impl.PostazioneServiceImpl;
import it.linksmt.prenotazione.postazioni.rest.constants.PrenotazionePostzioniConst;

@Controller
@RequestMapping(PrenotazionePostzioniConst.POSTAZIONE_PATH)
public class PostazioneController {
	
	
//	@Autowired
//	PostazioneServiceImpl postazioneServiceImpl;
	
//	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
//	public PostazioneDto getPostazioneDto(@PathVariable(value="id")Long id) {
//		
//		return postazioneServiceImpl.findPostazioneById(id);
//		
//	}
	
}
