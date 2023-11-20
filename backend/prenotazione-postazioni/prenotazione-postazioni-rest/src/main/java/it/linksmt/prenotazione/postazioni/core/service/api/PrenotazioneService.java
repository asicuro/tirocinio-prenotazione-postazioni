package it.linksmt.prenotazione.postazioni.core.service.api;

import java.util.List;

import it.linksmt.prenotazione.postazioni.core.dto.PrenotazioneDto;

public interface PrenotazioneService {

	public PrenotazioneDto findPrenotazioneById(Long id);

	public void savePrenotazione(PrenotazioneDto prenotazioneDto);

	public List<PrenotazioneDto> getPrenotazione();

	public void removePrenotazione(Long id);
}
