package it.linksmt.prenotazione.postazioni.core.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import it.linksmt.prenotazione.postazioni.core.model.Stanza;

public class UfficioDto{ 
 
	private Long id;
    
    private Long createUserId;
    
    private Date createDate;
    
    private Long editUserId;
    
    private Date editDate;
    
    private String indirizzo;
    
    private String nomeUfficio;
    
    private Long stanzaId;

	public Long getId() {
		return id;
	}

	public Long getCreateUserId() {
		return createUserId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public Long getEditUserId() {
		return editUserId;
	}

	public Date getEditDate() {
		return editDate;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public String getNomeUfficio() {
		return nomeUfficio;
	}

	public Long getStanzaId() {
		return stanzaId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setEditUserId(Long editUserId) {
		this.editUserId = editUserId;
	}

	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public void setNomeUfficio(String nomeUfficio) {
		this.nomeUfficio = nomeUfficio;
	}

	public void setStanzaId(Long stanzaId) {
		this.stanzaId = stanzaId;
	}
    
	
    
}
