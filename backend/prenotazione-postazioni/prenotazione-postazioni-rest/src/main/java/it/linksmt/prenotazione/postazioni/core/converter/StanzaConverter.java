package it.linksmt.prenotazione.postazioni.core.converter;

import org.mapstruct.Mapper;

import it.linksmt.prenotazione.postazioni.core.dto.StanzaDto;
import it.linksmt.prenotazione.postazioni.core.model.Stanza;

@Mapper(componentModel = "spring" , uses = {PostazioneConverter.class})
public interface StanzaConverter {

	StanzaDto toDto(Stanza stanza);
}
