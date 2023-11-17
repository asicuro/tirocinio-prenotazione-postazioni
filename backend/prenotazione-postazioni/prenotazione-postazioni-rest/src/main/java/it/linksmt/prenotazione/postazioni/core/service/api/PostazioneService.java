package it.linksmt.prenotazione.postazioni.core.service.api;

import org.springframework.stereotype.Service;

import it.linksmt.prenotazione.postazioni.core.dto.PostazioneDto;

@Service
public interface PostazioneService {

	public PostazioneDto findPostazioneById(Long id);
	public void savePostazione(PostazioneDto postazioneDto);
	
		
}
