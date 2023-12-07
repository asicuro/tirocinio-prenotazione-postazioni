package it.linksmt.prenotazione.postazioni.core.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.linksmt.prenotazione.postazioni.core.converter.PostazioneConverter;
import it.linksmt.prenotazione.postazioni.core.dto.PostazioneDto;
import it.linksmt.prenotazione.postazioni.core.exceptions.InvalidValueException;
import it.linksmt.prenotazione.postazioni.core.exceptions.MissingValueException;
import it.linksmt.prenotazione.postazioni.core.filters.PostazioneFilter;
import it.linksmt.prenotazione.postazioni.core.model.Postazione;
import it.linksmt.prenotazione.postazioni.core.model.Prenotazione;
import it.linksmt.prenotazione.postazioni.core.model.Stanza;
import it.linksmt.prenotazione.postazioni.core.repository.PostazioneRepository;
import it.linksmt.prenotazione.postazioni.core.repository.StanzaRepository;
import it.linksmt.prenotazione.postazioni.core.service.api.PostazioneService;

@Service
public class PostazioneServiceImpl implements PostazioneService {

	@Autowired
	PostazioneRepository postazioneRepository;

	@Autowired
	PostazioneConverter postazioneConverter;

	@Autowired
	StanzaRepository stanzaRepository;

	@Autowired
	EntityManager entityManager;

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

	@Override
	public boolean removeAll() {
		postazioneRepository.deleteAll();
		return postazioneRepository.count() == 0;
	}

	@Override
	public List<PostazioneDto> getPostazioniByStanzaId(Long stanzaId)
			throws InvalidValueException, MissingValueException {

		if (stanzaId == null || stanzaId < 0) {
			throw new InvalidValueException("stanzaId", stanzaId);
		}

		List<PostazioneDto> postazioni = new ArrayList<>();

		Optional<Stanza> stanzaOptional = stanzaRepository.findById(stanzaId);

		if (stanzaOptional.isEmpty()) {
			throw new MissingValueException("Stanza", stanzaId);
		}

		for (Postazione postazione : postazioneRepository.findByStanza(stanzaOptional.get())) {

			postazioni.add(postazioneConverter.toDto(postazione));
		}

		return postazioni;
	}

	@Override
	public List<PostazioneDto> filter(PostazioneFilter filtro) throws MissingValueException {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Prenotazione> prenotazioneQuery = cb.createQuery(Prenotazione.class);
		CriteriaQuery<Postazione> postazioneQuery = cb.createQuery(Postazione.class);
		Root<Prenotazione> prenotazioneRoot = prenotazioneQuery.from(Prenotazione.class);
		Root<Postazione> postazioneRoot = postazioneQuery.from(Postazione.class);
		List<Predicate> postazionePredicates = new ArrayList<>();

		if (filtro.getCreateUserId() > 0 && filtro.getCreateUserId() != null) {
			Long postazioneId = filtro.getCreateUserId();
			Optional<Postazione> postazioneOptional = postazioneRepository.findById(postazioneId);

			if (postazioneOptional.isEmpty())
				throw new MissingValueException("Postazione", postazioneId);

			Predicate postazionePredicate = cb.equal(prenotazioneRoot.get("postazione"), postazioneOptional.get());
			postazionePredicates.add(postazionePredicate);
		}

		if (filtro.getCreateDate() != null) {
			Predicate findByCreateDate = cb.equal(postazioneRoot.get("createDate"), filtro.getCreateDate());
			postazionePredicates.add(findByCreateDate);
		}

		if (filtro.getWidth() < 0 && filtro.getLength() < 0) {

			Predicate dimensioniPredicate = cb.and(cb.equal(postazioneRoot.get("width"), filtro.getWidth()),
					cb.equal(postazioneRoot.get("length"), filtro.getLength()));
			postazionePredicates.add(dimensioniPredicate);
		}
		postazioneQuery.where(cb.and(postazionePredicates.toArray(new Predicate[0])));
		TypedQuery<Postazione> query = entityManager.createQuery(postazioneQuery);
		List<Postazione> postazioni = query.getResultList();

		return postazioni.stream().map(postazioneConverter::toDto).collect(Collectors.toList());

	}
}
