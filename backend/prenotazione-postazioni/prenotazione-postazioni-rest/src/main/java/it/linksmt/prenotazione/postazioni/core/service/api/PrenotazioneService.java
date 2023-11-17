package it.linksmt.prenotazione.postazioni.core.service.api;

import it.linksmt.prenotazione.postazioni.core.dto.PrenotazioneDto;

public interface PrenotazioneService {
	
	public PrenotazioneDto findPrenotazioneById(Long id);
	public void savePrenotazione(PrenotazioneDto prenotazioneDto);

}
