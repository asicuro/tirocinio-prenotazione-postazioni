package it.linksmt.prenotazione.postazioni.core.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.linksmt.prenotazione.postazioni.core.model.Prenotazione;


@Repository
public interface PrenotazioneRepository extends CrudRepository<Prenotazione, Long>, JpaSpecificationExecutor<Prenotazione>{
}
