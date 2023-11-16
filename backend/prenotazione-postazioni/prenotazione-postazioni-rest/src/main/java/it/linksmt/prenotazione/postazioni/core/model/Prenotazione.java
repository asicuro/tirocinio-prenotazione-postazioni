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
	
	@Column(name = "data_creazione")
	private Date dataCreazione;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
    private Utente utente; 

    @ManyToOne
    @JoinColumn(name = "postazione_id")
    private Postazione postazione; 

}
