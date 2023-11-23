package it.linksmt.prenotazione.postazioni.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.linksmt.prenotazione.postazioni.core.model.Stanza;

@Repository
public interface StanzaRepository extends CrudRepository<Stanza, Long>, JpaSpecificationExecutor<Stanza> {

	@Query("SELECT s FROM Stanza s WHERE s.ufficio.id =?1")
	public List<Stanza> getStanzeByUfficioId(Long ufficioId);
}
