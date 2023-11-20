package it.linksmt.prenotazione.postazioni.core.service.api;

import java.util.List;

import it.linksmt.prenotazione.postazioni.core.dto.UfficioDto;

public interface UfficioService {

	public UfficioDto findUfficioById(Long id);

	public void saveUfficio(UfficioDto ufficioDto);

	public void removeUfficioById(Long id);

	public List<UfficioDto> getUffici();
}
