package it.linksmt.prenotazione.postazioni.core.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import it.linksmt.prenotazione.postazioni.core.converter.StanzaConverter;
import it.linksmt.prenotazione.postazioni.core.dto.StanzaDto;
import it.linksmt.prenotazione.postazioni.core.model.Stanza;
import it.linksmt.prenotazione.postazioni.core.repository.StanzaRepository;
import it.linksmt.prenotazione.postazioni.core.service.api.StanzaService;

public class StanzaServiceImpl implements StanzaService{
	
	@Autowired
	StanzaRepository stanzaRepository;
	
	@Autowired
	StanzaConverter stanzaConverter;

	@Override
	public StanzaDto finStanzaById(Long id) {
		
		if (id == null || id < 0) return null;			
		Optional<Stanza> stanzaDto = stanzaRepository.findById(id);
		if (stanzaDto.isEmpty()) return null;
		
		return stanzaConverter.toDto(stanzaDto.get());
	}

}
