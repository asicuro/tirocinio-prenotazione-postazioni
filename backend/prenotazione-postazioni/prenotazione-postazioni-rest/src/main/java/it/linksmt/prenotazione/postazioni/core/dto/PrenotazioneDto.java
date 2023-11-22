package it.linksmt.prenotazione.postazioni.core.dto;

import java.util.Date;

public class PrenotazioneDto {

	private Long id;

	private Long createUserId;

	private Date createDate;

	private Long editUserId;

	private Long utenteId;

	private Long postazioneId;

	private Date editDate;

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

	public Long getUtenteId() {
		return utenteId;
	}

	public void setUtenteId(Long utenteId) {
		this.utenteId = utenteId;
	}

	public Long getPostazioneId() {
		return postazioneId;
	}

	public void setPostazioneId(Long postazioneId) {
		this.postazioneId = postazioneId;
	}

	public Date getEditDate() {
		return editDate;
	}

	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}

}
