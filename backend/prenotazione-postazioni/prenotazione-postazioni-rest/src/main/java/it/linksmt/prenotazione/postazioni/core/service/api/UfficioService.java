package it.linksmt.prenotazione.postazioni.core.service.api;

import java.util.List;

import it.linksmt.prenotazione.postazioni.core.Exception.InvalidValueException;
import it.linksmt.prenotazione.postazioni.core.dto.UfficioDto;

public interface UfficioService {

	public UfficioDto findUfficioById(Long id);

	public UfficioDto saveUfficio(UfficioDto ufficioDto);

	public void removeUfficioById(Long id);

	public List<UfficioDto> getUffici();

	public UfficioDto updateUfficio(UfficioDto ufficioDto)throws InvalidValueException;
}
