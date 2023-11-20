package it.linksmt.prenotazione.postazioni.core.dto;

import java.util.Date;

public class PostazioneDto {
	
	private Long id;
	
	private Long createUserId;
	    
	private Date createDate;
	    
	private Long editUserId;
	   
	private Date editDate;    
	    
	private Float width;
	    
	private Float height;
	    
	private Long stanzaId;

	private Float x;
	    
	private Float y;

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

	public Date getEditDate() {
			return editDate;
		}

	public void setEditDate(Date editDate) {
			this.editDate = editDate;
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

	public Long getStanzaId() {
			return stanzaId;
		}

	public void setStanzaId(Long stanzaId) {
			this.stanzaId = stanzaId;
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
	
}
