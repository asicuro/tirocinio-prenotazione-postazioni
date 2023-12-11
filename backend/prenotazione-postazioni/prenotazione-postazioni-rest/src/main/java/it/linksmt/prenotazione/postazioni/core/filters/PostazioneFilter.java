package it.linksmt.prenotazione.postazioni.core.filters;

import java.util.Date;

public class PostazioneFilter {

	private Long createUserId;
	private Date createdate;
	private int width;
	private int length;
	private Long stanza;
	private Long ufficio;

	public Long getUfficio() {
		return ufficio;
	}

	public Long getCreateUserId() {
		return createUserId;
	}

	public Date getCreateDate() {
		return createdate;
	}

	public int getWidth() {
		return width;
	}

	public int getLength() {
		return length;
	}

	public Long getStanza() {
		return stanza;
	}

}
