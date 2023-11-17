package it.linksmt.prenotazione.postazioni.core.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="ufficio")
public class Ufficio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "create_user_id")
    private Long createUserId;
    @Column(name = "create_date")
    private java.util.Date createDate;
    @Column(name = "edit_user_id")
    private Long editUserId;
    @Column(name = "edit_date")
    private java.util.Date editDate;
    @Column(name = "indirizzo")
    private String indirizzo;
    @Column(name = "nome_ufficio")
    private String nomeUfficio;
    @OneToMany(mappedBy = "ufficio")
    private List<Stanza> stanze;
    
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
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getNomeUfficio() {
		return nomeUfficio;
	}
	public void setNomeUfficio(String nomeUfficio) {
		this.nomeUfficio = nomeUfficio;
	}
	public List<Stanza> getStanze() {
		return stanze;
	}
	public void setStanze(List<Stanza> stanze) {
		this.stanze = stanze;
	}
    
    
}


