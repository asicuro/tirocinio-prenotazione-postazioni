package it.linksmt.prenotazione.postazioni.core.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import it.linksmt.prenotazione.postazioni.core.converter.UtenteConverter;
import it.linksmt.prenotazione.postazioni.core.dto.UtenteDto;
import it.linksmt.prenotazione.postazioni.core.model.Utente;
import it.linksmt.prenotazione.postazioni.core.repository.UtenteRepository;
import it.linksmt.prenotazione.postazioni.core.service.api.UtenteService;

public class UtenteServiceImpl implements UtenteService{
	
	@Autowired
	UtenteRepository utenteRepository;
	
	@Autowired
	UtenteConverter utenteConverter;

	@Override
	public UtenteDto findUtente(Long id) {
		
		Optional<Utente> utenteOptional = utenteRepository.findById(id);
		if (utenteOptional.isEmpty()) {
			return null;
		}
		return utenteConverter.toDto(utenteOptional.get());
		
	}

}
