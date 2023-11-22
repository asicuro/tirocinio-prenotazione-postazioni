package it.linksmt.prenotazione.postazioni.rest.output;

import java.util.Date;

public class ErrorResponse {
	private String message;
	private String error;
	private Date timestamp;
	private Integer status;
	
	public ErrorResponse(String message, String error, Date timestamp, Integer status) {
		super();
        this.message = message;
        this.error = error;
        this.timestamp = timestamp;
        this.status = status;
	}
	
	public String getMessage() {
        return message;
    }
	
	public void setMessage(String message) {
        this.message = message;
    }
	
    public String getError() {
        return error;
    }
    
    public void setError(String error) {
        this.error = error;
    }
    
    public Date getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    
    public Integer getStatus() {
        return status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    
    

}
