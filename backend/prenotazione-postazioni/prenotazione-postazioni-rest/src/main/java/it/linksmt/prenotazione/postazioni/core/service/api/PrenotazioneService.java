package it.linksmt.prenotazione.postazioni.core.service.api;

import java.util.List;

import it.linksmt.prenotazione.postazioni.core.dto.PrenotazioneDto;
import it.linksmt.prenotazione.postazioni.core.exceptions.InvalidValueException;
import it.linksmt.prenotazione.postazioni.core.exceptions.MissingValueException;

public interface PrenotazioneService {

	public PrenotazioneDto findPrenotazioneById(Long id) throws InvalidValueException, MissingValueException;

	public PrenotazioneDto savePrenotazione(PrenotazioneDto prenotazioneDto) throws InvalidValueException, MissingValueException;

	public List<PrenotazioneDto> getPrenotazione();

	public boolean removePrenotazione(Long id) throws InvalidValueException, MissingValueException;

	public PrenotazioneDto updatePrenotazione(PrenotazioneDto prenotazioneDto) throws InvalidValueException, MissingValueException;
}
