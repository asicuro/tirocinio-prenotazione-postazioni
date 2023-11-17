package it.linksmt.prenotazione.postazioni.core.service.api;

import it.linksmt.prenotazione.postazioni.core.dto.UfficioDto;

public interface UfficioService {
	
	public UfficioDto findUfficiobyId(Long id);
	
	public void saveUfficio(UfficioDto ufficioDto);
}
