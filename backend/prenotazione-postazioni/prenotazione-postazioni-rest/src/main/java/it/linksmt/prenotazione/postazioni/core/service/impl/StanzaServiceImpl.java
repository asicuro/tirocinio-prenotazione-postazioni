package it.linksmt.prenotazione.postazioni.core.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.linksmt.prenotazione.postazioni.core.converter.StanzaConverter;
import it.linksmt.prenotazione.postazioni.core.dto.StanzaDto;
import it.linksmt.prenotazione.postazioni.core.exceptions.InvalidValueException;
import it.linksmt.prenotazione.postazioni.core.exceptions.MissingValueException;
import it.linksmt.prenotazione.postazioni.core.model.Stanza;
import it.linksmt.prenotazione.postazioni.core.repository.StanzaRepository;
import it.linksmt.prenotazione.postazioni.core.service.api.StanzaService;

@Service
public class StanzaServiceImpl implements StanzaService {

	private static final String NOME_ENTITA = "Stanza";

	@Autowired
	private StanzaRepository stanzaRepository;

	@Autowired
	private StanzaConverter stanzaConverter;

	@Override
	public StanzaDto findStanzaById(Long id) throws InvalidValueException, MissingValueException {

		if (id == null || id < 0)
			throw new InvalidValueException("id", id);

		Optional<Stanza> stanzaDto = stanzaRepository.findById(id);

		if (stanzaDto.isEmpty())
			throw new MissingValueException(NOME_ENTITA, id);

		return stanzaConverter.toDto(stanzaDto.get());
	}

	@Override
	public StanzaDto saveStanza(StanzaDto stanza, Long createUserId) throws InvalidValueException {

		if (stanza.getNome() == null)
			throw new InvalidValueException("nome", stanza.getNome());

		if (stanza.getWidth() == null)
			throw new InvalidValueException("width", stanza.getWidth());

		if (stanza.getHeight() == null)
			throw new InvalidValueException("height", stanza.getHeight());

		if (stanza.getX() == null)
			throw new InvalidValueException("x", stanza.getX());

		if (stanza.getY() == null)
			throw new InvalidValueException("y", stanza.getY());

		if (stanza.getUfficioId() == null)
			throw new InvalidValueException("ufficioId", stanza.getUfficioId());

		stanza.setCreateDate(new Date());
		stanza.setCreateUserId(createUserId);

		return stanzaConverter.toDto(stanzaRepository.save(stanzaConverter.toEntity(stanza)));
	}

	@Override
	public List<StanzaDto> getStanze() {

		List<StanzaDto> stanze = new ArrayList<>();

		for (Stanza stanza : stanzaRepository.findAll()) {
			stanze.add(stanzaConverter.toDto(stanza));
		}
		return stanze;
	}

	@Override
	public boolean removeStanza(Long id) throws InvalidValueException, MissingValueException {

		if (id == null || id < 0)
			throw new InvalidValueException("id", id);

		if (!stanzaRepository.existsById(id))
			throw new MissingValueException(NOME_ENTITA, id);

		stanzaRepository.deleteById(id);
		return !stanzaRepository.existsById(id);
	}

	@Override
	public StanzaDto updateStanza(StanzaDto stanzaDto, Long editUserId)
			throws InvalidValueException, MissingValueException {

		if (stanzaDto.getId() == null || stanzaDto.getId() < 0)
			throw new InvalidValueException("id", stanzaDto.getId());

		Optional<Stanza> stanza = stanzaRepository.findById(stanzaDto.getId());

		if (stanza.isEmpty())
			throw new MissingValueException(NOME_ENTITA, stanzaDto.getId());

		if (stanzaDto.getNome() == null)
			throw new InvalidValueException("nome", stanzaDto.getNome());

		if (stanzaDto.getWidth() == null)
			throw new InvalidValueException("width", stanzaDto.getWidth());

		if (stanzaDto.getHeight() == null)
			throw new InvalidValueException("height", stanzaDto.getHeight());

		if (stanzaDto.getX() == null)
			throw new InvalidValueException("x", stanzaDto.getX());

		if (stanzaDto.getY() == null)
			throw new InvalidValueException("y", stanzaDto.getY());

		if (stanzaDto.getUfficioId() == null)
			throw new InvalidValueException("ufficioId", stanzaDto.getUfficioId());

		stanzaDto.setCreateDate(stanza.get().getCreateDate());
		stanzaDto.setCreateUserId(stanza.get().getCreateUserId());
		stanzaDto.setEditDate(new Date());
		stanzaDto.setEditUserId(editUserId);

		return stanzaConverter.toDto(stanzaRepository.save(stanzaConverter.toEntity(stanzaDto)));

	}

	@Override
	public boolean removeAll() {

		stanzaRepository.deleteAll();
		return stanzaRepository.count() == 0;
	}

}
