package it.linksmt.prenotazione.postazioni.core.converter;

import org.mapstruct.Mapper;


import it.linksmt.prenotazione.postazioni.core.dto.PrenotazioneDto;
import it.linksmt.prenotazione.postazioni.core.model.Prenotazione;

@Mapper(componentModel = "spring" , uses = {UtenteConverter.class, PostazioneConverter.class})
public interface PrenotazioneConverter {
	
	PrenotazioneDto toDto(Prenotazione p);
}
