package it.linksmt.prenotazione.postazioni.core.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import it.linksmt.prenotazione.postazioni.core.model.Ufficio;

@EnableJpaRepositories
public interface UfficioRepository extends CrudRepository<Ufficio, Long>, JpaSpecificationExecutor<Ufficio>{

	
}
