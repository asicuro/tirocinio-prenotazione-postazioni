package it.linksmt.prenotazione.postazioni.core.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import it.linksmt.prenotazione.postazioni.core.converter.PostazioneConverter;
import it.linksmt.prenotazione.postazioni.core.dto.PostazioneDto;
import it.linksmt.prenotazione.postazioni.core.model.Postazione;
import it.linksmt.prenotazione.postazioni.core.repository.PostazioneRepository;
import it.linksmt.prenotazione.postazioni.core.service.api.PostazioneService;

public class PostazioneServiceImpl implements PostazioneService{
	
	@Autowired
	PostazioneRepository postazioneRepository;
	
	@Autowired
	PostazioneConverter postazioneConverter;
	
public PostazioneDto findPostazioneById(Long id) {
	
	if (id == null || id < 0) {
		return null;
	}
	
	Optional<Postazione> postazioneOptional = postazioneRepository.findById(id);
		if(postazioneOptional.isEmpty()) {
			return null;
		}
		return postazioneConverter.toDto(postazioneOptional.get());
	}

	@Override
public void savePostazione(PostazioneDto postazioneDto) {
	
	if(postazioneRepository.existsById(postazioneDto.getId())) {
		
		return;
		
		}
	
	postazioneRepository.save(postazioneConverter.toEntity(postazioneDto));
	
	}
}
