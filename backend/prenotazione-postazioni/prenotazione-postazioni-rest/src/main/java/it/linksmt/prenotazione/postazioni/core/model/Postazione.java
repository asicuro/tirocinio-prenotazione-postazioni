package it.linksmt.prenotazione.postazioni.core.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	    
	    @Column
	    private Float width;
	    
	    @Column
	    private Float height;
	    
	    @Column
	    private Float x;
	    
	    @Column
	    private Float y;    	
}
