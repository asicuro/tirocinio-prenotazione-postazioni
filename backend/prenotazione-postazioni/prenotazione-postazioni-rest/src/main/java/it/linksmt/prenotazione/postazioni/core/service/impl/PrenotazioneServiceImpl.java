package it.linksmt.prenotazione.postazioni.core.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.linksmt.prenotazione.postazioni.core.converter.PrenotazioneConverter;
import it.linksmt.prenotazione.postazioni.core.dto.PrenotazioneDto;
import it.linksmt.prenotazione.postazioni.core.exceptions.InvalidValueException;
import it.linksmt.prenotazione.postazioni.core.exceptions.MissingValueException;
import it.linksmt.prenotazione.postazioni.core.model.Prenotazione;
import it.linksmt.prenotazione.postazioni.core.repository.PrenotazioneRepository;
import it.linksmt.prenotazione.postazioni.core.service.api.PrenotazioneService;

@Service
public class PrenotazioneServiceImpl implements PrenotazioneService {

	@Autowired
	PrenotazioneRepository prenotazioneRepository;

	@Autowired
	PrenotazioneConverter prenotazioneConverter;

	public PrenotazioneDto findPrenotazioneById(Long id) throws InvalidValueException, MissingValueException {

		if (id == null || id < 0) {
			throw new InvalidValueException("id", id);
		}

		Optional<Prenotazione> prenotazioneOptional = prenotazioneRepository.findById(id);

		if (prenotazioneOptional.isEmpty()) {
			throw new MissingValueException("prenotazione", id);
		}
		return prenotazioneConverter.toDto(prenotazioneOptional.get());
	}

	@Override
	public PrenotazioneDto savePrenotazione(PrenotazioneDto prenotazioneDto, Long id) throws InvalidValueException {

		if (prenotazioneDto.getUtenteId() == null) {
			throw new InvalidValueException("utente", prenotazioneDto.getUtenteId());
		}
		if (prenotazioneDto.getPostazioneId() == null) {
			throw new InvalidValueException("postazione", prenotazioneDto.getPostazioneId());
		}

		prenotazioneDto.setDataCreazione(new Date());
		prenotazioneDto.setCreateUserId(id);
		prenotazioneDto.setCreateDate(new Date());
		Prenotazione p = prenotazioneRepository.save(prenotazioneConverter.toEntity(prenotazioneDto));
		return prenotazioneConverter.toDto(p);
	}

	@Override
	public List<PrenotazioneDto> getPrenotazione() {

		List<PrenotazioneDto> prenotazioni = new ArrayList<>();

		for (Prenotazione prenotazione : prenotazioneRepository.findAll()) {
			prenotazioni.add(prenotazioneConverter.toDto(prenotazione));
		}
		return prenotazioni;
	}

	@Override
	public boolean removePrenotazione(Long id) throws InvalidValueException, MissingValueException {
		if (id == null || id < 0) {
			throw new InvalidValueException("id", id);
		}
		if (!prenotazioneRepository.existsById(id)) {
			throw new MissingValueException("Prenotazione", id);
		}
		prenotazioneRepository.deleteById(id);
		return !prenotazioneRepository.existsById(id);
	}

	@Override
	public PrenotazioneDto updatePrenotazione(PrenotazioneDto prenotazioneDto, Long id)
			throws InvalidValueException, MissingValueException {

		if (!prenotazioneRepository.existsById(prenotazioneDto.getId())) {
			throw new MissingValueException("Prenotazione", prenotazioneDto.getId());
		}

		Optional<Prenotazione> prenotaOptional = prenotazioneRepository.findById(id);

		if (prenotaOptional.isEmpty()) {
			throw new MissingValueException("Prenotazione", id);
		}

		if (prenotazioneDto.getUtenteId() == null) {
			throw new InvalidValueException("utente", prenotazioneDto.getUtenteId());
		}
		if (prenotazioneDto.getPostazioneId() == null) {
			throw new InvalidValueException("postazione", prenotazioneDto.getPostazioneId());
		}
		prenotazioneDto.setCreateDate(prenotaOptional.get().getCreateDate());
		prenotazioneDto.setCreateUserId(prenotaOptional.get().getCreateUserId());
		prenotazioneDto.setEditDate(new Date());
		prenotazioneDto.setEditUserId(id);

		Prenotazione p = prenotazioneRepository.save(prenotazioneConverter.toEntity(prenotazioneDto));
		return prenotazioneConverter.toDto(p);
	}

}
