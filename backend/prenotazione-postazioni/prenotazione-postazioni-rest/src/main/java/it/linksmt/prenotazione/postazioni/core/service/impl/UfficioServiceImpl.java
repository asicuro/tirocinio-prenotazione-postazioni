package it.linksmt.prenotazione.postazioni.core.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import it.linksmt.prenotazione.postazioni.core.converter.UfficioConverter;
import it.linksmt.prenotazione.postazioni.core.dto.UfficioDto;
import it.linksmt.prenotazione.postazioni.core.model.Ufficio;
import it.linksmt.prenotazione.postazioni.core.repository.UfficioRepository;
import it.linksmt.prenotazione.postazioni.core.service.api.UfficioService;

public class UfficioServiceImpl implements UfficioService{
	
	@Autowired
	UfficioRepository ufficioRepository;
	
	@Autowired
	UfficioConverter ufficioConverter;
	

	public UfficioDto findUfficiobyId(Long id) {
		if (id == null || id<0) {
			return null;
		}
		Optional<Ufficio> ufficioOptional=ufficioRepository.findById(id);
		if (ufficioOptional.isEmpty()) {
			return null;
		}
		return ufficioConverter.toDto(ufficioOptional.get());
	}

}
