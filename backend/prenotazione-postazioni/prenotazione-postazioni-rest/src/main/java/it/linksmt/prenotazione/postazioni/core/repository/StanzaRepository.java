package it.linksmt.prenotazione.postazioni.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.linksmt.prenotazione.postazioni.core.model.Stanza;
import it.linksmt.prenotazione.postazioni.core.model.Ufficio;

@Repository
public interface StanzaRepository extends CrudRepository<Stanza, Long>, JpaSpecificationExecutor<Stanza> {

	public List<Stanza> findByUfficio(Ufficio u);
}
