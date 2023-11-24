package it.linksmt.prenotazione.postazioni.core.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.linksmt.prenotazione.postazioni.core.model.Postazione;
import it.linksmt.prenotazione.postazioni.core.model.Prenotazione;
import it.linksmt.prenotazione.postazioni.core.model.Utente;

@Repository
public interface PrenotazioneRepository
		extends CrudRepository<Prenotazione, Long>, JpaSpecificationExecutor<Prenotazione> {

	List<Prenotazione> findByDataPrenotazioneGreaterThan(Date dataPrenotazione);

	List<Prenotazione> findByUtenteAndDataPrenotazioneGreaterThan(Utente u, Date dataPrenotazione);

	public List<Prenotazione> findByPostazione(Postazione p);

	public List<Prenotazione> findByUtente(Utente u);
}
