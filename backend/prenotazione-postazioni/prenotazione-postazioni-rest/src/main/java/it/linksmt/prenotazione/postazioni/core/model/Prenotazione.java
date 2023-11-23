package it.linksmt.prenotazione.postazioni.core.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "prenotazione")
public class Prenotazione {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "create_user_id")
	private Long createUserId;

	@Column(name = "create_date")

	private Date createDate;

	@Column(name = "edit_user_id")
	private Long editUserId;

	@Column(name = "edit_date")
	private Date editDate;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private Utente utente;

	@ManyToOne
	@JoinColumn(name = "postazione_id")
	private Postazione postazione;

	@Column(name = "data_prenotazione")
	@Temporal(TemporalType.DATE)
	private Date dataPrenotazione;

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

	public java.util.Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}

	public Long getEditUserId() {
		return editUserId;
	}

	public void setEditUserId(Long editUserId) {
		this.editUserId = editUserId;
	}

	public java.util.Date getEditDate() {
		return editDate;
	}

	public void setEditDate(java.util.Date editDate) {
		this.editDate = editDate;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Postazione getPostazione() {
		return postazione;
	}

	public void setPostazione(Postazione postazione) {
		this.postazione = postazione;
	}

	public Date getDataPrenotazione() {
		return dataPrenotazione;
	}

	public void setDataPrenotazione(Date dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}

}
