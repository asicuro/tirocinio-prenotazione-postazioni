package it.linksmt.prenotazione.postazioni.core.service.api;

import java.util.List;

import it.linksmt.prenotazione.postazioni.core.dto.PostazioneDto;

public interface PostazioneService {

	public PostazioneDto findPostazioneById(Long id);

	public void savePostazione(PostazioneDto postazioneDto);

	public List<PostazioneDto> getPostazioni();

	public void removePostazione(Long id);

}
