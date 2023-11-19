package it.linksmt.prenotazione.postazioni.core.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.linksmt.prenotazione.postazioni.core.converter.StanzaConverter;
import it.linksmt.prenotazione.postazioni.core.dto.StanzaDto;
import it.linksmt.prenotazione.postazioni.core.model.Stanza;
import it.linksmt.prenotazione.postazioni.core.repository.StanzaRepository;
import it.linksmt.prenotazione.postazioni.core.service.api.StanzaService;

@Service
public class StanzaServiceImpl implements StanzaService{
	
	@Autowired
	private StanzaRepository stanzaRepository;
	
	@Autowired
	private StanzaConverter stanzaConverter;

	@Override
	public StanzaDto findStanzaById(Long id) {
		
		if (id == null || id < 0) return null;			
		Optional<Stanza> stanzaDto = stanzaRepository.findById(id);
		if (stanzaDto.isEmpty()) return null;
		
		return stanzaConverter.toDto(stanzaDto.get());
	}

	@Override
	public void saveStanza(StanzaDto stanza) {
		
		if (stanzaRepository.existsById(stanza.getId())) return;
		stanzaRepository.save(stanzaConverter.toEntity(stanza));
	}

}
