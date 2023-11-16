package it.linksmt.prenotazione.postazioni.core.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import it.linksmt.prenotazione.postazioni.core.model.Prenotazione;


@EnableJpaRepositories
public interface PrenotazioneRepository extends CrudRepository<Prenotazione, Long>, JpaSpecificationExecutor<Prenotazione>{
}
