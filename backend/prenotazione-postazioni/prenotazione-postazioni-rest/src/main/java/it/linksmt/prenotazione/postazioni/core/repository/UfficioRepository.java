package it.linksmt.prenotazione.postazioni.core.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.linksmt.prenotazione.postazioni.core.model.Ufficio;

@Repository
public interface UfficioRepository extends CrudRepository<Ufficio, Long>, JpaSpecificationExecutor<Ufficio>{

	
}
