package it.linksmt.prenotazione.postazioni.core.filters;

import java.util.Date;

public class PostazioneFilter {

	private Long createUserId;
	private Date createdate;
	private int width;
	private int length;

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

}
