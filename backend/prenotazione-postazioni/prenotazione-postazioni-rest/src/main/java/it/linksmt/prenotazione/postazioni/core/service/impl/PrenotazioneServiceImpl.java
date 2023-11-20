package it.linksmt.prenotazione.postazioni.core.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.linksmt.prenotazione.postazioni.core.converter.PrenotazioneConverter;
import it.linksmt.prenotazione.postazioni.core.dto.PrenotazioneDto;
import it.linksmt.prenotazione.postazioni.core.model.Prenotazione;
import it.linksmt.prenotazione.postazioni.core.repository.PrenotazioneRepository;
import it.linksmt.prenotazione.postazioni.core.service.api.PrenotazioneService;

@Service
public class PrenotazioneServiceImpl implements PrenotazioneService {

	@Autowired
	PrenotazioneRepository prenotazioneRepository;

	@Autowired
	PrenotazioneConverter prenotazioneConverter;

	public PrenotazioneDto findPrenotazioneById(Long id) {

		if (id == null || id < 0) {
			return null;
		}

		Optional<Prenotazione> prenotazioneOptional = prenotazioneRepository.findById(id);
		if (prenotazioneOptional.isEmpty()) {
			return null;
		}
		return prenotazioneConverter.toDto(prenotazioneOptional.get());
	}

	@Override
	public void savePrenotazione(PrenotazioneDto prenotazioneDto) {

		if (prenotazioneRepository.existsById(prenotazioneDto.getId())) {
			return;
		}

		prenotazioneRepository.save(prenotazioneConverter.toEntity(prenotazioneDto));
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
	public void removePrenotazione(Long id) {
		if (id == null || id < 0) {
			return;
		}
		prenotazioneRepository.deleteById(id);
	}

}
