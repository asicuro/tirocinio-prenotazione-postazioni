package it.linksmt.prenotazione.postazioni.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.linksmt.prenotazione.postazioni.core.model.Postazione;
import it.linksmt.prenotazione.postazioni.core.model.Stanza;

@Repository
public interface PostazioneRepository extends CrudRepository<Postazione, Long>, JpaSpecificationExecutor<Postazione> {

	public List<Postazione> findByStanza(Stanza s);
}
