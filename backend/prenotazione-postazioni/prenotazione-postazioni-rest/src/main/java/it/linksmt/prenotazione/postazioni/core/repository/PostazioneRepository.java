package it.linksmt.prenotazione.postazioni.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.linksmt.prenotazione.postazioni.core.model.Postazione;

@Repository
public interface PostazioneRepository extends CrudRepository<Postazione, Long>, JpaSpecificationExecutor<Postazione> {

	@Query("SELECT p FROM Postazione p WHERE p.stanza.id =?1")
	public List<Postazione> getPostazioniByStanzaId(Long id);
}
