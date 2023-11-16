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
	    
	    
}
