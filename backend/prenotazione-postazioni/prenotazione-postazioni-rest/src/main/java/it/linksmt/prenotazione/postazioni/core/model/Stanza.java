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

	public long getEditUserId() {
		return editUserId;
	}

	public void setEditUserId(long editUserId) {
		this.editUserId = editUserId;
	}

	public Date getEditDate() {
		return editDate;
	}

	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getWidth() {
		return width;
	}

	public void setWidth(Float width) {
		this.width = width;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

	public Float getX() {
		return x;
	}

	public void setX(Float x) {
		this.x = x;
	}

	public Float getY() {
		return y;
	}

	public void setY(Float y) {
		this.y = y;
	}

	public Ufficio getUfficio() {
		return ufficio;
	}

	public void setUfficio(Ufficio ufficio) {
		this.ufficio = ufficio;
	}

	public List<Postazione> getPostazioni() {
		return postazioni;
	}

	public void setPostazioni(List<Postazione> postazioni) {
		this.postazioni = postazioni;
	}
	
	

}
