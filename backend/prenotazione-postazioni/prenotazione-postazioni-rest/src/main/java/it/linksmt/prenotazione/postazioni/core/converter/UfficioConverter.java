package it.linksmt.prenotazione.postazioni.core.converter;

import org.mapstruct.Mapper;

import it.linksmt.prenotazione.postazioni.core.dto.UfficioDto;
import it.linksmt.prenotazione.postazioni.core.model.Ufficio;

@Mapper(componentModel = "spring", uses = {StanzaConverter.class})
public interface UfficioConverter {

	UfficioDto toDto(Ufficio ufficio);
}
