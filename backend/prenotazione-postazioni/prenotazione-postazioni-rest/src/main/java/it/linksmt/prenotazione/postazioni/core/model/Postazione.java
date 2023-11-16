package it.linksmt.prenotazione.postazioni.core.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Postazione {
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
	    
	    @Column(name = "width")
	    private Float width;
	    
	    @Column (name = "height")
	    private Float height;
	    
	    @Column (name = "x")
	    private Float x;
	    
	    @Column (name = "y")
	    private Float y;
	    
	    @ManyToOne
	    @JoinColumn(name = "stanza_id")
	    private Stanza stanza;

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

		public Stanza getStanza() {
			return stanza;
		}

		public void setStanza(Stanza stanza) {
			this.stanza = stanza;
		}
	    
	    
}
