package it.linksmt.prenotazione.postazioni.core.service.api;

import org.springframework.stereotype.Service;

import it.linksmt.prenotazione.postazioni.core.dto.UfficioDto;

@Service
public interface UfficioService {
	
	public UfficioDto findUfficiobyId(Long id);

}
