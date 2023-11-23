package it.linksmt.prenotazione.postazioni.core.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.linksmt.prenotazione.postazioni.core.converter.UfficioConverter;
import it.linksmt.prenotazione.postazioni.core.dto.UfficioDto;
import it.linksmt.prenotazione.postazioni.core.exceptions.InvalidValueException;
import it.linksmt.prenotazione.postazioni.core.exceptions.MissingValueException;
import it.linksmt.prenotazione.postazioni.core.exceptions.NestedEntityException;
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
  public UfficioDto findUfficioById(Long id) throws InvalidValueException, MissingValueException {
    if (id == null || id < 0) {
      throw new InvalidValueException("id", id);
    }

    Optional < Ufficio > ufficioOptional = ufficioRepository.findById(id);

    if (ufficioOptional.isEmpty()) {
      throw new MissingValueException("ufficio", id);
    }
    return ufficioConverter.toDto(ufficioOptional.get());
  }

  @Override
  public UfficioDto saveUfficio(UfficioDto ufficioDto, Long requestId) throws InvalidValueException {
    if (ufficioDto.getIndirizzo() == null) {
      throw new InvalidValueException("indirizzo", ufficioDto.getIndirizzo());
    }
    if (ufficioDto.getNomeUfficio() == null) {
      throw new InvalidValueException("nomeUfficio", ufficioDto.getNomeUfficio());
    }
    ufficioDto.setCreateDate(new Date());
    ufficioDto.setCreateUserId(requestId);
    return ufficioConverter.toDto(ufficioRepository.save(ufficioConverter.toEntity(ufficioDto)));
  }

  @Override
  public UfficioDto updateUfficio(UfficioDto ufficioDto, Long requestId) throws InvalidValueException, MissingValueException {
	if (ufficioDto.getId() == null || ufficioDto.getId() < 0)
		throw new InvalidValueException("id", ufficioDto.getId());
	
	Optional<Ufficio> ufficiOptional = ufficioRepository.findById(ufficioDto.getId());
	
	if(ufficiOptional.isEmpty())
	  throw new MissingValueException("Ufficio", ufficioDto.getId());	
	
    if(ufficioDto.getIndirizzo() == null) {
      throw new InvalidValueException("indirizzo", ufficioDto.getIndirizzo());
    }
    if(ufficioDto.getNomeUfficio() == null) {
      throw new InvalidValueException("nomeUfficio", ufficioDto.getNomeUfficio());
    }
    
    ufficioDto.setCreateDate(ufficiOptional.get().getCreateDate());
    ufficioDto.setCreateUserId(ufficiOptional.get().getCreateUserId());
    ufficioDto.setEditDate(new Date());
    ufficioDto.setEditUserId(requestId);
    return ufficioConverter.toDto(ufficioRepository.save(ufficioConverter.toEntity(ufficioDto)));
  }

  @Override
  public boolean removeUfficioById(Long id) throws InvalidValueException, MissingValueException, NestedEntityException {
    if (id == null || id < 0) {
      throw new InvalidValueException("id", id);
    }
    
    Optional<Ufficio> ufficio = ufficioRepository.findById(id);
    
    if(ufficio.isEmpty()) {
      throw new MissingValueException("Ufficio", id);
    }
    
    if (!(ufficio.get().getStanze().isEmpty() )) {
    	throw new NestedEntityException("Ufficio", id);
    }
    ufficioRepository.deleteById(id);
    return !ufficioRepository.existsById(id);

  }

  @Override
  public List < UfficioDto > getUffici() {
    List < UfficioDto > uffici = new ArrayList < > ();
    for (Ufficio ufficio: ufficioRepository.findAll()) {
      uffici.add(ufficioConverter.toDto(ufficio));
    }
    return uffici;
  }

  @Override
  public boolean removeUfficioall() throws InvalidValueException, MissingValueException {
	  ufficioRepository.deleteAll();
	  return ufficioRepository.count() == 0;
}
}