package it.linksmt.prenotazione.postazioni.core.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import it.linksmt.prenotazione.postazioni.core.dto.StanzaDto;
import it.linksmt.prenotazione.postazioni.core.model.Stanza;

@Mapper(componentModel = "spring")
public interface StanzaConverter {

	StanzaDto toDto(Stanza stanza);
	
	Stanza toEntity(StanzaDto stanzaDto);
}
