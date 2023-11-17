package it.linksmt.prenotazione.postazioni.core.converter;

import org.mapstruct.Mapper;

import it.linksmt.prenotazione.postazioni.core.dto.PostazioneDto;
import it.linksmt.prenotazione.postazioni.core.model.Postazione;


@Mapper(componentModel = "spring", uses = {StanzaConverter.class})
public interface PostazioneConverter {
	
	PostazioneDto toDto(Postazione p);
}
