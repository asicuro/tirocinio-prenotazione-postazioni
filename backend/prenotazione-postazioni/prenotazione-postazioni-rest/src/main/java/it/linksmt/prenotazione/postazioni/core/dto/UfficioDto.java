package it.linksmt.prenotazione.postazioni.core.dto;

import java.util.Date;
import java.util.List;


public class UfficioDto{ 
 
	private Long id;
    
    private Long createUserId;
    
    private Date createDate;
    
    private Long editUserId;
    
    private Date editDate;
    
    private String indirizzo;
    
    private String nomeUfficio;
    
    private List<StanzaDto> stanze;

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
	
	

	public List<StanzaDto> getStanze() {
		return stanze;
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

	public void setStanze(List<StanzaDto> stanze) {
		this.stanze = stanze;
	}
	
    
	
    
}
