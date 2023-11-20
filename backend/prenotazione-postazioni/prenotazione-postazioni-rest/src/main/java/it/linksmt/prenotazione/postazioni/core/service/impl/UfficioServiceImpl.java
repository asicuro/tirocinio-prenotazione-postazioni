package it.linksmt.prenotazione.postazioni.core.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.linksmt.prenotazione.postazioni.core.converter.UfficioConverter;
import it.linksmt.prenotazione.postazioni.core.dto.UfficioDto;
import it.linksmt.prenotazione.postazioni.core.model.Ufficio;
import it.linksmt.prenotazione.postazioni.core.repository.UfficioRepository;
import it.linksmt.prenotazione.postazioni.core.service.api.UfficioService;

@Service
public class UfficioServiceImpl implements UfficioService {

	@Autowired
	UfficioRepository ufficioRepository;

	@Autowired
	UfficioConverter ufficioConverter;

	@Override
	public UfficioDto findUfficioById(Long id) {
		if (id == null || id < 0) {
			return null;
		}
		Optional<Ufficio> ufficioOptional = ufficioRepository.findById(id);
		if (ufficioOptional.isEmpty()) {
			return null;
		}
		return ufficioConverter.toDto(ufficioOptional.get());
	}

	@Override
	public void saveUfficio(UfficioDto ufficioDto) {
		if (ufficioRepository.existsById(ufficioDto.getId())) {
			return;
		}
		ufficioRepository.save(ufficioConverter.toEntity(ufficioDto));
	}

	@Override
	public void removeUfficioById(Long id) {
		if (id == null || id < 0) {
			return;
		}
		ufficioRepository.deleteById(id);
	}

	@Override
	public List<UfficioDto> getUffici() {
		List<UfficioDto> uffici = new ArrayList<>();
		for (Ufficio ufficio : ufficioRepository.findAll()) {
			uffici.add(ufficioConverter.toDto(ufficio));
		}
		return uffici;
	}
}
