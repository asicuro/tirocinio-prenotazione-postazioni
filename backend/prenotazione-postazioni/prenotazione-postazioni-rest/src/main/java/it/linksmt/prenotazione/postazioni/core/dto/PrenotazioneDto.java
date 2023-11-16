package it.linksmt.prenotazione.postazioni.core.dto;

import java.util.Date;

public class PrenotazioneDto {
	
	private Long id;
	
	private Long createUserId;
	
	private Date createDate;
	
	private Long editUserId;
	
	private UtenteDto utente;
	
	private PostazioneDto postazione;

	private Date editDate;
	
	private Date dataCreazione;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Long getEditUserId() {
		return editUserId;
	}

	public void setEditUserId(Long editUserId) {
		this.editUserId = editUserId;
	}

	public UtenteDto getUtente() {
		return utente;
	}

	public void setUtente(UtenteDto utente) {
		this.utente = utente;
	}

	public PostazioneDto getPostazione() {
		return postazione;
	}

	public void setPostazione(PostazioneDto postazione) {
		this.postazione = postazione;
	}

	public Date getEditDate() {
		return editDate;
	}

	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}

	public Date getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

}
