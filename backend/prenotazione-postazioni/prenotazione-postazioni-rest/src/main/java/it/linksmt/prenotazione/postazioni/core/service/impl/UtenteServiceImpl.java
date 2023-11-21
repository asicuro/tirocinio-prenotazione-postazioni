package it.linksmt.prenotazione.postazioni.core.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.linksmt.prenotazione.postazioni.core.converter.UtenteConverter;
import it.linksmt.prenotazione.postazioni.core.dto.UtenteDto;
import it.linksmt.prenotazione.postazioni.core.exceptions.InvalidValueException;
import it.linksmt.prenotazione.postazioni.core.exceptions.MissingValueException;
import it.linksmt.prenotazione.postazioni.core.model.Utente;
import it.linksmt.prenotazione.postazioni.core.repository.UtenteRepository;
import it.linksmt.prenotazione.postazioni.core.service.api.UtenteService;

@Service
public class UtenteServiceImpl implements UtenteService {

	private static final String NOME_ENTITA = "Utente";

	@Autowired
	UtenteRepository utenteRepository;

	@Autowired
	UtenteConverter utenteConverter;

	@Override
	public UtenteDto findUtenteById(Long id) throws MissingValueException, InvalidValueException {

		if (id == null || id < 0)
			throw new InvalidValueException("id", id);

		Optional<Utente> utenteOptional = utenteRepository.findById(id);

		if (utenteOptional.isEmpty())
			throw new MissingValueException(NOME_ENTITA, id);

		return utenteConverter.toDto(utenteOptional.get());

	}

	@Override
	public UtenteDto saveUtente(UtenteDto utenteDto) throws InvalidValueException {

		if (utenteDto.getUsername() == null)
			throw new InvalidValueException("username", utenteDto.getId());

		if (utenteDto.getPassword() == null)
			throw new InvalidValueException("password", utenteDto.getPassword());

		if (utenteDto.getRuolo() == null)
			throw new InvalidValueException("ruolo", utenteDto.getRuolo());

		return utenteConverter.toDto(utenteRepository.save(utenteConverter.toEntity(utenteDto)));

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
	public boolean removeUtente(Long id) throws InvalidValueException, MissingValueException {

		if (id == null || id < 0)
			throw new InvalidValueException("id", id);

		if (!utenteRepository.existsById(id))
			throw new MissingValueException(NOME_ENTITA, id);

		utenteRepository.deleteById(id);

		return !utenteRepository.existsById(id);

	}

	@Override
	public UtenteDto updateUtente(UtenteDto utenteDto) throws InvalidValueException, MissingValueException {

		if (utenteDto.getId() == null || utenteDto.getId() < 0)
			throw new InvalidValueException("id", utenteDto.getId());

		if (utenteRepository.existsById(utenteDto.getId()))
			throw new MissingValueException(NOME_ENTITA, utenteDto.getId());

		if (utenteDto.getUsername() == null)
			throw new InvalidValueException("username", utenteDto.getUsername());

		if (utenteDto.getPassword() == null)
			throw new InvalidValueException("password", utenteDto.getPassword());

		if (utenteDto.getRuolo() == null)
			throw new InvalidValueException("ruolo", utenteDto.getRuolo());

		return utenteConverter.toDto(utenteRepository.save(utenteConverter.toEntity(utenteDto)));

	}

}
