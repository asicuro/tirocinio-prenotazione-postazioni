package it.linksmt.prenotazione.postazioni.core.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.linksmt.prenotazione.postazioni.core.converter.UtenteConverter;
import it.linksmt.prenotazione.postazioni.core.dto.UtenteDto;
import it.linksmt.prenotazione.postazioni.core.model.Utente;
import it.linksmt.prenotazione.postazioni.core.repository.UtenteRepository;
import it.linksmt.prenotazione.postazioni.core.service.api.UtenteService;

@Service
public class UtenteServiceImpl implements UtenteService {

	@Autowired
	UtenteRepository utenteRepository;

	@Autowired
	UtenteConverter utenteConverter;

	@Override
	public UtenteDto findUtenteById(Long id) {

		if (id == null || id < 0) {
			return null;
		}

		Optional<Utente> utenteOptional = utenteRepository.findById(id);
		if (utenteOptional.isEmpty()) {
			return null;
		}
		return utenteConverter.toDto(utenteOptional.get());

	}

	@Override
	public void saveUtente(UtenteDto utente) {
		if (utenteRepository.existsById(utente.getId()))
			return;
		utenteRepository.save(utenteConverter.toEntity(utente));

	}

	@Override
	public List<UtenteDto> getUtenti() {

		List<UtenteDto> utenti = new ArrayList<>();

		for (Utente utente : utenteRepository.findAll()) {
			utenti.add(utenteConverter.toDto(utente));
		}
		return utenti;
	}

	@Override
	public void removeUtente(Long id) {

		if (id == null || id < 0 || !utenteRepository.existsById(id))
			return;

		utenteRepository.deleteById(id);

	}

}
