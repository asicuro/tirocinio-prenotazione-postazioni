package it.linksmt.prenotazione.postazioni.core.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import it.linksmt.prenotazione.postazioni.core.dto.StanzaDto;
import it.linksmt.prenotazione.postazioni.core.model.Stanza;

@Mapper(componentModel = "spring" , uses = {PostazioneConverter.class})
public interface StanzaConverter {

	@Mapping(target = "ufficio_id", source = "Ufficio.id")
	StanzaDto toDto(Stanza stanza);
}
