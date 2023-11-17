package it.linksmt.prenotazione.postazioni.core.converter;

import org.mapstruct.Mapper;

import it.linksmt.prenotazione.postazioni.core.dto.UtenteDto;
import it.linksmt.prenotazione.postazioni.core.model.Utente;

@Mapper(componentModel = "spring")
public interface UtenteConverter {

	UtenteDto toDto(Utente utente);
}
