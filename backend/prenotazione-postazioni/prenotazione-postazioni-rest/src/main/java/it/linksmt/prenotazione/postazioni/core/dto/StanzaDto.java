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

	public StanzaDto setId(Long id) {
		this.id = id;
		return this;
	}

	public StanzaDto setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
		return this;
	}

	public StanzaDto setCreateDate(Date createDate) {
		this.createDate = createDate;
		return this;
	}

	public StanzaDto setEditUserId(Long editUserId) {
		this.editUserId = editUserId;
		return this;
	}

	public StanzaDto setEditDate(Date editDate) {
		this.editDate = editDate;
		return this;
	}

	public StanzaDto setNome(String nome) {
		this.nome = nome;
		return this;
	}

	public StanzaDto setWidth(Float width) {
		this.width = width;
		return this;
	}

	public StanzaDto setHeight(Float height) {
		this.height = height;
		return this;
	}

	public StanzaDto setX(Float x) {
		this.x = x;
		return this;
	}

	public StanzaDto setY(Float y) {
		this.y = y;
		return this;
	}

	public StanzaDto setUfficioId(Long ufficioId) {
		this.ufficioId = ufficioId;
		return this;
	}

	public StanzaDto setPostazioni(List<PostazioneDto> postazioni) {
		this.postazioni = postazioni;
		return this;
	}

}
