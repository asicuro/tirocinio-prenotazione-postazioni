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

		private Float x;
	    
	    private Float y;

}
