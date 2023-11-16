package it.linksmt.prenotazione.postazioni.core.dto;

import java.util.Date;
import java.util.List;

public class StanzaDto {
	
	private Long id;
	
	private Long createUserId;
	
	private Date createDate;
	
	private Long editUserId;
	
	private Date editDate;
	
	private String nome;
	
	private Float width;
	
	private Float height;
	
	private Float x;
	
	private Float y;
		
	private Long ufficioId;
	
	private List<PostazioneDto> postazioni;
	
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
	public String getNome() {
		return nome;
	}
	public Float getWidth() {
		return width;
	}
	public Float getHeight() {
		return height;
	}
	public Float getX() {
		return x;
	}
	public Float getY() {
		return y;
	}
	public Long getUfficioId() {
		return ufficioId;
	}
	public List<PostazioneDto> getPostazioni() {
		return postazioni;
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
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setWidth(Float width) {
		this.width = width;
	}
	public void setHeight(Float height) {
		this.height = height;
	}
	public void setX(Float x) {
		this.x = x;
	}
	public void setY(Float y) {
		this.y = y;
	}
	public void setUfficioId(Long ufficioId) {
		this.ufficioId = ufficioId;
	}
	public void setPostazioni(List<PostazioneDto> postazioni) {
		this.postazioni = postazioni;
	}
		
}
