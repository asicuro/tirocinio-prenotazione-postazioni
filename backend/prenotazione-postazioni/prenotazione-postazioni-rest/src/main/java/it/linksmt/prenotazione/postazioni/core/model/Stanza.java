package it.linksmt.prenotazione.postazioni.core.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "stanza")
public class Stanza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "create_user_id")
	private Long createUserId;
	
	@Column(name = "create_date")
	private Date createDate;
	
	@Column(name = "edit_user_id")
	private long editUserId;
	
	@Column(name = "edit_date")
	private Date editDate;
	
	@Column(name = "name")
	private String nome;
	
	@Column(name = "width")
	private Float width;
	
	@Column(name = "height")
	private Float height;
	
	@Column(name = "x")
	private Float x;
	
	@Column(name = "y")
	private Float y;
	
	@ManyToOne
	@JoinColumn(name = "ufficio_id")
	private Ufficio ufficio;
	
	@OneToMany(mappedBy = "stanza")
	private List<Postazione> postazioni;

}
