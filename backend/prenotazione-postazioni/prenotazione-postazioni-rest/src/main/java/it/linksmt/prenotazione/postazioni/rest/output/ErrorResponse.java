package it.linksmt.prenotazione.postazioni.rest.output;

import java.util.Date;

public class ErrorResponse {
	private String error;
	private String message;
	private Date timestamp;
	private String status;

	public String getMessage() {
		return message;
	}

	public ErrorResponse setMessage(String message) {
		this.message = message;
		return this;
	}

	public String getError() {
		return error;
	}

	public ErrorResponse setError(String error) {
		this.error = error;
		return this;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public ErrorResponse setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public ErrorResponse setStatus(String status) {
		this.status = status;
		return this;
	}

}
