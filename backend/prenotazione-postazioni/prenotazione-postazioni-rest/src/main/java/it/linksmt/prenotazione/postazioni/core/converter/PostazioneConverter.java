package it.linksmt.prenotazione.postazioni.core.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import it.linksmt.prenotazione.postazioni.core.dto.PostazioneDto;
import it.linksmt.prenotazione.postazioni.core.model.Postazione;


@Mapper(componentModel = "spring", uses = {StanzaConverter.class})
public interface PostazioneConverter {
	
	@Mapping(target = "stanzaId", source = "stanza.id")
	PostazioneDto toDto(Postazione postazione);
	
	@Mapping(target = "stanza.id", source = "stanzaId")
	Postazione toEntity(PostazioneDto postazione);
}
