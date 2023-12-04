package it.linksmt.prenotazione.postazioni.core.filters;

import java.sql.Date;

public class UfficioFilter {

    private String indirizzo;
    private String nomeUfficio;
    private Long prenotazioneId;
    private Long userId;
    private Long create_user_id;
    private Date create_date;
    
	public String getIndirizzo() {
		return indirizzo;
	}
	public String getNomeUfficio() {
		return nomeUfficio;
	}
	public Long getPrenotazioneId() {
		return prenotazioneId;
	}
	public Long getUserId() {
		return userId;
	}
	public Long getCreate_user_id() {
		return create_user_id;
	}
	public Date getCreate_date() {
		return create_date;
	}
	
    
	
	
}
