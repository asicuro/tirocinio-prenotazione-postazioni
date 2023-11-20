package it.linksmt.prenotazione.postazioni.core.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import it.linksmt.prenotazione.postazioni.core.dto.PrenotazioneDto;
import it.linksmt.prenotazione.postazioni.core.model.Prenotazione;

@Mapper(componentModel = "spring")
public interface PrenotazioneConverter {
	
	@Mapping(target ="utenteId", source = "utente.id")
	@Mapping(target = "postazioneId", source = "postazione.id")
	PrenotazioneDto toDto(Prenotazione prenotazione);
	
	@Mapping(target ="utente.id", source = "utenteId")
	@Mapping(target = "postazione.id", source = "postazioneId")
	Prenotazione toEntity(PrenotazioneDto prenotazione);
}
