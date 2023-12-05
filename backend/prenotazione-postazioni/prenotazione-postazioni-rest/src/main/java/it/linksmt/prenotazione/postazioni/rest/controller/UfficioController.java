package it.linksmt.prenotazione.postazioni.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.linksmt.prenotazione.postazioni.core.dto.UfficioDto;
import it.linksmt.prenotazione.postazioni.core.exceptions.InvalidValueException;
import it.linksmt.prenotazione.postazioni.core.exceptions.MissingValueException;
import it.linksmt.prenotazione.postazioni.core.exceptions.NestedEntityException;
import it.linksmt.prenotazione.postazioni.core.filters.UfficioFilter;
import it.linksmt.prenotazione.postazioni.core.service.api.UfficioService;
import it.linksmt.prenotazione.postazioni.rest.constants.PrenotazionePostzioniConst;

@RestController
@RequestMapping(PrenotazionePostzioniConst.UFFICIO_PATH)
public class UfficioController {

	@Autowired
	private UfficioService ufficioService;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UfficioDto> getUfficio(@PathVariable("id") Long id) throws InvalidValueException, MissingValueException {
		return ResponseEntity.ok(ufficioService.findUfficioById(id));
	}

	@PostMapping(path= "/save/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('admin')")
	public ResponseEntity<UfficioDto> saveUfficio(@RequestBody UfficioDto ufficioDto,@PathVariable("id") Long id) throws InvalidValueException {
		return ResponseEntity.ok(ufficioService.saveUfficio(ufficioDto, id));
	}

	@DeleteMapping(value = "/{id}")
	@PreAuthorize("hasRole('admin')")
	public boolean removeUfficio(@PathVariable("id") Long id) throws InvalidValueException, MissingValueException, NestedEntityException {
		return ufficioService.removeUfficioById(id);
	}

	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UfficioDto>> getUffici() {
		return ResponseEntity.ok(ufficioService.getUffici());

	}

	@PutMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('admin')")
	public ResponseEntity<UfficioDto> updateUfficio(@RequestBody UfficioDto ufficioDto,@PathVariable("id") Long id) throws InvalidValueException, MissingValueException {
		return ResponseEntity.ok(ufficioService.updateUfficio(ufficioDto, id));
	}
	
	@DeleteMapping(value = "/all")
	@PreAuthorize("hasRole('admin')")
	public boolean removeAll() throws InvalidValueException, MissingValueException {
        return ufficioService.removeUfficioall();
    }
	@GetMapping(value = "/filter")
	@PreAuthorize("hasRole('admin')")
	public ResponseEntity<List<UfficioDto>> filtraUffici(@RequestBody UfficioFilter ufficioFilter) throws InvalidValueException, MissingValueException{
		return ResponseEntity.ok(ufficioService.filter(ufficioFilter));
	}
	
}
