package it.linksmt.prenotazione.postazioni.core.service.api;

import java.util.List;

import it.linksmt.prenotazione.postazioni.core.dto.PostazioneDto;
import it.linksmt.prenotazione.postazioni.core.exceptions.InvalidValueException;
import it.linksmt.prenotazione.postazioni.core.exceptions.MissingValueException;

public interface PostazioneService {

	public PostazioneDto findPostazioneById(Long id) throws InvalidValueException, MissingValueException;

	public PostazioneDto savePostazione(PostazioneDto postazioneDto, Long id)
			throws InvalidValueException, MissingValueException;

	public List<PostazioneDto> getPostazioni();

	public boolean removePostazione(Long id) throws InvalidValueException, MissingValueException;

	public PostazioneDto updatePostazione(PostazioneDto postazioneDto, Long id)
			throws InvalidValueException, MissingValueException;

}
