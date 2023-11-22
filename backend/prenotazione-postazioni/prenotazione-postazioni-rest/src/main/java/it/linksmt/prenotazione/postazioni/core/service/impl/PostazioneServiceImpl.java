package it.linksmt.prenotazione.postazioni.core.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.linksmt.prenotazione.postazioni.core.converter.PostazioneConverter;
import it.linksmt.prenotazione.postazioni.core.dto.PostazioneDto;
import it.linksmt.prenotazione.postazioni.core.exceptions.InvalidValueException;
import it.linksmt.prenotazione.postazioni.core.exceptions.MissingValueException;
import it.linksmt.prenotazione.postazioni.core.model.Postazione;
import it.linksmt.prenotazione.postazioni.core.repository.PostazioneRepository;
import it.linksmt.prenotazione.postazioni.core.service.api.PostazioneService;

@Service
public class PostazioneServiceImpl implements PostazioneService {

	@Autowired
	PostazioneRepository postazioneRepository;

	@Autowired
	PostazioneConverter postazioneConverter;

	public PostazioneDto findPostazioneById(Long id) throws InvalidValueException, MissingValueException {

		if (id == null || id < 0) {
			throw new InvalidValueException("id", id);
		}

		Optional<Postazione> postazioneOptional = postazioneRepository.findById(id);

		if (postazioneOptional.isEmpty()) {

			throw new MissingValueException("Postazione", id);

		}
		return postazioneConverter.toDto(postazioneOptional.get());
	}

	@Override
	public PostazioneDto savePostazione(PostazioneDto postazioneDto, Long id) throws InvalidValueException {
		if (postazioneDto.getWidth() == null) {
			throw new InvalidValueException("width", postazioneDto.getWidth());
		}
		if (postazioneDto.getHeight() == null) {
			throw new InvalidValueException("height", postazioneDto.getHeight());
		}
		if (postazioneDto.getStanzaId() == null) {
			throw new InvalidValueException("stanzaId", postazioneDto.getStanzaId());
		}
		if (postazioneDto.getX() == null) {
			throw new InvalidValueException("x", postazioneDto.getX());
		}
		if (postazioneDto.getY() == null) {
			throw new InvalidValueException("y", postazioneDto.getY());
		}
		postazioneDto.setCreateDate(new Date());
		postazioneDto.setCreateUserId(id);
		Postazione posta = postazioneRepository.save(postazioneConverter.toEntity(postazioneDto));
		return postazioneConverter.toDto(posta);
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
	public boolean removePostazione(Long id) throws InvalidValueException, MissingValueException {
		if (id == null || id < 0) {
			throw new InvalidValueException("id", id);
		}
		if (!postazioneRepository.existsById(id)) {
			throw new MissingValueException("Postazione", id);
		}
		postazioneRepository.deleteById(id);
		return !postazioneRepository.existsById(id);
	}

	@Override
	public PostazioneDto updatePostazione(PostazioneDto postazioneDto, Long id)
			throws InvalidValueException, MissingValueException {

		Optional<Postazione> postaOptional = postazioneRepository.findById(postazioneDto.getId());

		if (postaOptional.isEmpty()) {
			throw new MissingValueException("Postazione", postazioneDto.getId());
		}

		if (postazioneDto.getWidth() == null) {
			throw new InvalidValueException("width", postazioneDto.getWidth());
		}
		if (postazioneDto.getHeight() == null) {
			throw new InvalidValueException("height", postazioneDto.getHeight());
		}
		if (postazioneDto.getStanzaId() == null) {
			throw new InvalidValueException("stanzaId", postazioneDto.getStanzaId());
		}
		if (postazioneDto.getX() == null) {
			throw new InvalidValueException("x", postazioneDto.getX());
		}
		if (postazioneDto.getY() == null) {
			throw new InvalidValueException("y", postazioneDto.getY());
		}

		postazioneDto.setCreateDate(postaOptional.get().getCreateDate());
		postazioneDto.setCreateUserId(postaOptional.get().getCreateUserId());
		postazioneDto.setEditDate(new Date());
		postazioneDto.setEditUserId(id);

		Postazione posta = postazioneRepository.save(postazioneConverter.toEntity(postazioneDto));
		return postazioneConverter.toDto(posta);
	}
}
