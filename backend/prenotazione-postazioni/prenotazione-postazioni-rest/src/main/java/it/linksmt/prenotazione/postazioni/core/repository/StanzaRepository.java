package it.linksmt.prenotazione.postazioni.core.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import antlr.collections.List;
import it.linksmt.prenotazione.postazioni.core.model.Stanza;

@EnableJpaRepositories
public interface StanzaRepository extends CrudRepository<Stanza, Long>, JpaSpecificationExecutor<Stanza>{
	

} 
