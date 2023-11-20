package it.linksmt.prenotazione.postazioni.core.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import it.linksmt.prenotazione.postazioni.core.dto.StanzaDto;
import it.linksmt.prenotazione.postazioni.core.model.Stanza;

@Mapper(componentModel = "spring")
public interface StanzaConverter {

//	@Mapping(target = "ufficioId", source = "ufficio.id")
	StanzaDto toDto(Stanza stanza);
	
//	@Mapping(target = "ufficio.id", source = "ufficioId")
	Stanza toEntity(StanzaDto stanzaDto);
}
