package it.linksmt.prenotazione.postazioni.core.service.api;

import java.util.List;

import it.linksmt.prenotazione.postazioni.core.dto.UfficioDto;
import it.linksmt.prenotazione.postazioni.core.exceptions.InvalidValueException;

public interface UfficioService {

	public UfficioDto findUfficioById(Long id) throws InvalidValueException;

	public UfficioDto saveUfficio(UfficioDto ufficioDto) throws InvalidValueException;

	public boolean removeUfficioById(Long id) throws InvalidValueException;

	public List<UfficioDto> getUffici();

	public UfficioDto updateUfficio(UfficioDto ufficioDto)throws InvalidValueException;
}
