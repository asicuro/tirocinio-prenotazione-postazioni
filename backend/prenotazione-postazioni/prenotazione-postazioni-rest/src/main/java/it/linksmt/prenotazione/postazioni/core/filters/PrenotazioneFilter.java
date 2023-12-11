package it.linksmt.prenotazione.postazioni.core.filters;

import java.util.Date;

public class PrenotazioneFilter {

	private Long utenteId;
	private Long createUserId;
	private Long postazioneId;
	private Long stanzaId;
	private Long ufficioId;
	private Date inizioPeriodo;
	private Date finePeriodo;
	private Integer isScaduta;

	public Long getUfficioId() {
		return ufficioId;
	}

	public Integer isScaduta() {
		return isScaduta;
	}

	public Long getCreateUserId() {
		return createUserId;
	}

	public Long getUtenteId() {
		return utenteId;
	}

	public Long getPostazioneId() {
		return postazioneId;
	}

	public Long getStanzaId() {
		return stanzaId;
	}

	public Date getInizioPeriodo() {
		return inizioPeriodo;
	}

	public Date getFinePeriodo() {
		return finePeriodo;
	}
}
