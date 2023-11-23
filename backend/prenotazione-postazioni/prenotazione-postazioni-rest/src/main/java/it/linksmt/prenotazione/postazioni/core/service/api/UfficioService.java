package it.linksmt.prenotazione.postazioni.core.service.api;

import java.util.List;

import it.linksmt.prenotazione.postazioni.core.dto.UfficioDto;
import it.linksmt.prenotazione.postazioni.core.exceptions.InvalidValueException;
import it.linksmt.prenotazione.postazioni.core.exceptions.MissingValueException;
import it.linksmt.prenotazione.postazioni.core.exceptions.NestedEntityException;

public interface UfficioService {

	public UfficioDto findUfficioById(Long id) throws InvalidValueException, MissingValueException;

	public UfficioDto saveUfficio(UfficioDto ufficioDto, Long requestId) throws InvalidValueException;

	public boolean removeUfficioById(Long id) throws InvalidValueException, MissingValueException, NestedEntityException;

	public List<UfficioDto> getUffici();

	public UfficioDto updateUfficio(UfficioDto ufficioDto, Long requestId)throws InvalidValueException, MissingValueException;
	
	public boolean removeUfficioall() throws InvalidValueException, MissingValueException;
	
	
}
