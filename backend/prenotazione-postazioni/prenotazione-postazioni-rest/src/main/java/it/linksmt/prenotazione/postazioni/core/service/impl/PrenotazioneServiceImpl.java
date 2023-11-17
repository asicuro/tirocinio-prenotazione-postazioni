package it.linksmt.prenotazione.postazioni.core.service.impl;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import it.linksmt.prenotazione.postazioni.core.converter.PrenotazioneConverter;
import it.linksmt.prenotazione.postazioni.core.dto.PrenotazioneDto;
import it.linksmt.prenotazione.postazioni.core.model.Prenotazione;
import it.linksmt.prenotazione.postazioni.core.repository.PrenotazioneRepository;
import it.linksmt.prenotazione.postazioni.core.service.api.PrenotazioneService;

public class PrenotazioneServiceImpl implements PrenotazioneService{
	
	@Autowired
	PrenotazioneRepository prenotazioneRepository;
	
	@Autowired 
	PrenotazioneConverter prenotazioneConverter;
	
	
	public PrenotazioneDto findPrenotazioneById(Long id) {
		
		if (id == null || id < 0) {
			return null;
		}
		
		Optional<Prenotazione> prenotazioneOptional = prenotazioneRepository.findById(id);
			if (prenotazioneOptional.isEmpty()) {
				return null; 
			}
			return prenotazioneConverter.toDto(prenotazioneOptional.get());
	}
	

	@Override
	public void savePrenotazione(PrenotazioneDto prenotazioneDto) {	
		
		if(prenotazioneRepository.existsById(prenotazioneDto.getId())){
			return;
		}
		
		prenotazioneRepository.save(prenotazioneConverter.toEntity(prenotazioneDto));
	}
}
