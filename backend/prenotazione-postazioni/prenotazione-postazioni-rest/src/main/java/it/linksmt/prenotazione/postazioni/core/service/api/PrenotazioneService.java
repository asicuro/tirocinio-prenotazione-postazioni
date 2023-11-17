package it.linksmt.prenotazione.postazioni.core.service.api;

import org.springframework.stereotype.Service;

import it.linksmt.prenotazione.postazioni.core.dto.PrenotazioneDto;

@Service
public interface PrenotazioneService{
	
	public PrenotazioneDto findPrenotazioneById(Long id);

}
