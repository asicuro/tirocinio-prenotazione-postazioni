package it.linksmt.prenotazione.postazioni.core.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import it.linksmt.prenotazione.postazioni.core.model.Utente;

@Repository
public interface UtenteRepository
		extends CrudRepository<Utente, Long>, JpaSpecificationExecutor<Utente> {
}
