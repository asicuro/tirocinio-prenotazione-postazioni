package it.linksmt.prenotazione.postazioni.core.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.linksmt.prenotazione.postazioni.core.converter.PostazioneConverter;
import it.linksmt.prenotazione.postazioni.core.converter.PrenotazioneConverter;
import it.linksmt.prenotazione.postazioni.core.dto.PrenotazioneDto;
import it.linksmt.prenotazione.postazioni.core.exceptions.InvalidValueException;
import it.linksmt.prenotazione.postazioni.core.exceptions.MissingValueException;
import it.linksmt.prenotazione.postazioni.core.model.Postazione;
import it.linksmt.prenotazione.postazioni.core.model.Prenotazione;
import it.linksmt.prenotazione.postazioni.core.model.Utente;
import it.linksmt.prenotazione.postazioni.core.repository.PostazioneRepository;
import it.linksmt.prenotazione.postazioni.core.repository.PrenotazioneRepository;
import it.linksmt.prenotazione.postazioni.core.repository.UtenteRepository;
import it.linksmt.prenotazione.postazioni.core.service.api.PrenotazioneService;

@Service
public class PrenotazioneServiceImpl implements PrenotazioneService {

	@Autowired
	PrenotazioneRepository prenotazioneRepository;

	@Autowired
	PrenotazioneConverter prenotazioneConverter;

	@Autowired
	PostazioneRepository postazioneRepository;

	@Autowired
	UtenteRepository utenteRepository;

	@Autowired
	PostazioneConverter postazioneConverter;

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
		List<Prenotazione> prenotazioneList = prenotazioneRepository.findByDataPrenotazioneGreaterThan(new Date());

		Optional<Prenotazione> prenotazioneTrovataOptional = prenotazioneList.stream().filter(p -> p.getId().equals(id))
				.findFirst();

		if (prenotazioneTrovataOptional.isEmpty()) {
			throw new MissingValueException("prenotazione", id);
		}

		prenotazioneRepository.delete(prenotazioneTrovataOptional.get());
		return !prenotazioneRepository.existsById(id);
	}

	@Override
	public PrenotazioneDto updatePrenotazione(PrenotazioneDto prenotazioneDto, Long id)
			throws InvalidValueException, MissingValueException {

		Optional<Prenotazione> prenotaOptional = prenotazioneRepository.findById(prenotazioneDto.getId());

		if (prenotaOptional.isEmpty()) {
			throw new MissingValueException("Prenotazione", prenotazioneDto.getId());
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

	@Override
	public boolean removeAll() {
		prenotazioneRepository.deleteAll();
		return prenotazioneRepository.count() == 0;
	}

	@Override
	public boolean controlloDisponibilita(Date data, Long id) throws MissingValueException, InvalidValueException {

		Optional<Postazione> postazione = postazioneRepository.findById(id);

		if (id == null || id < 0) {
			throw new InvalidValueException("id", id);
		}

		if (postazione.isEmpty()) {
			throw new MissingValueException("postazione", id);
		}
		for (Prenotazione p : prenotazioneRepository.findByPostazione(postazione.get())) {
			if (p.getDataPrenotazione().equals(data)) {
				return false;
			}

		}
		return true;
	}

	@Override
	public boolean controlloUserPrenotazione(Date data, Long id) throws MissingValueException, InvalidValueException {

		Optional<Utente> utente = utenteRepository.findById(id);

		if (id == null || id < 0) {
			throw new InvalidValueException("id", id);
		}

		if (utente.isEmpty()) {
			throw new MissingValueException("utente", id);
		}
		for (Prenotazione p : prenotazioneRepository.findByUtente(utente.get())) {
			if (p.getDataPrenotazione().equals(data)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public List<PrenotazioneDto> findPrenotazioniByUserId(Long id) throws InvalidValueException, MissingValueException {

		List<PrenotazioneDto> prenotazioniUtente = new ArrayList<>();

		if (prenotazioneRepository.findAll() == null) {
			throw new MissingValueException("Prenotazioni", id);
		}

		if (id == null || id < 0) {
			throw new InvalidValueException("id", id);
		}

		for (Prenotazione prenotazione : prenotazioneRepository.findAll()) {

			if (prenotazione.getUtente().getId() == id) {
				prenotazioniUtente.add(prenotazioneConverter.toDto(prenotazione));
			}
		}
		return prenotazioniUtente;
	}
}