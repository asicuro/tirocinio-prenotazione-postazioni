package it.linksmt.prenotazione.postazioni.core.dto;

import java.util.Date;

public class PrenotazioneDto {
	
	private Long id;
	
	
	private Long createUserId;
	
	
	private Date createDate;
	
	
	private Long editUserId;
	
	
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


	public void setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}


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


	public Date getDataCreazione() {
		return dataCreazione;
	}


	private Date editDate;
	
	
	private Date dataCreazione;



}
