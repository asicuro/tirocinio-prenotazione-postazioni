package it.linksmt.prenotazione.postazioni.core.service.api;

import java.util.Date;
import java.util.List;

import it.linksmt.prenotazione.postazioni.core.dto.PrenotazioneDto;
import it.linksmt.prenotazione.postazioni.core.exceptions.InvalidValueException;
import it.linksmt.prenotazione.postazioni.core.exceptions.MissingValueException;
import it.linksmt.prenotazione.postazioni.core.filters.PrenotazioneFilter;

public interface PrenotazioneService {

	public PrenotazioneDto findPrenotazioneById(Long id) throws InvalidValueException, MissingValueException;

	public PrenotazioneDto savePrenotazione(PrenotazioneDto prenotazioneDto, Long id)
			throws InvalidValueException, MissingValueException;

	public List<PrenotazioneDto> getPrenotazioni();

	public boolean removePrenotazione(Long id) throws InvalidValueException, MissingValueException;

	public PrenotazioneDto updatePrenotazione(PrenotazioneDto prenotazioneDto, Long id)
			throws InvalidValueException, MissingValueException;

	boolean removeAll();

	boolean controlloDisponibilita(Date data, Long id) throws MissingValueException, InvalidValueException;

	public List<PrenotazioneDto> filter(PrenotazioneFilter filtro) throws MissingValueException, InvalidValueException;

}
