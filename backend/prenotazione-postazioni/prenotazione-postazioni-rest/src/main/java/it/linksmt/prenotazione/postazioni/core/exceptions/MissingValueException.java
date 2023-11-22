package it.linksmt.prenotazione.postazioni.core.exceptions;

public class MissingValueException extends Exception {

	private static final long serialVersionUID = 1L;
	private final String entityName;
	private final Long id;
	private final static String tipologiaErrore = "Entita' non trovata";

	public MissingValueException(String entityName, Long id) {
		this.entityName = entityName;
		this.id = id;
	}

	@Override
	public String getMessage() {
		return "Attenzione: l'entita' " + this.entityName + " con id = " + this.id + " non e' presente";
	}

	public String getTipologiaErrore() {
		return tipologiaErrore;
	}
}
