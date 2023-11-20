package it.linksmt.prenotazione.postazioni.core.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.linksmt.prenotazione.postazioni.core.converter.PostazioneConverter;
import it.linksmt.prenotazione.postazioni.core.dto.PostazioneDto;
import it.linksmt.prenotazione.postazioni.core.model.Postazione;
import it.linksmt.prenotazione.postazioni.core.repository.PostazioneRepository;
import it.linksmt.prenotazione.postazioni.core.service.api.PostazioneService;

@Service
public class PostazioneServiceImpl implements PostazioneService {

	@Autowired
	PostazioneRepository postazioneRepository;

	@Autowired
	PostazioneConverter postazioneConverter;

	public PostazioneDto findPostazioneById(Long id) {

		if (id == null || id < 0) {
			return null;
		}

		Optional<Postazione> postazioneOptional = postazioneRepository.findById(id);
		if (postazioneOptional.isEmpty()) {
			return null;
		}
		return postazioneConverter.toDto(postazioneOptional.get());
	}

	@Override
	public void savePostazione(PostazioneDto postazioneDto) {

		if (postazioneRepository.existsById(postazioneDto.getId())) {
			return;
		}
		postazioneRepository.save(postazioneConverter.toEntity(postazioneDto));

	}

	@Override
	public List<PostazioneDto> getPostazioni() {
		List<PostazioneDto> postazioni = new ArrayList<>();

		for (Postazione postazione : postazioneRepository.findAll()) {
			postazioni.add(postazioneConverter.toDto(postazione));
		}

		return postazioni;
	}

	@Override
	public void removePostazione(Long id) {
		if (id == null || id < 0) {
			return;
		}
		postazioneRepository.deleteById(id);
	}

}
