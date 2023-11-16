package it.linksmt.prenotazione.postazioni.core.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import it.linksmt.prenotazione.postazioni.core.model.Utente;

@EnableJpaRepositories
public interface UtenteRepository extends CrudRepository<Utente, Long>, JpaSpecificationExecutor<Utente>{
}
