package it.linksmt.prenotazione.postazioni.core.exceptions;

public class MissingValueException extends Exception {

	private static final long serialVersionUID = 1L;
	private String entityName;
	private Long id;

	public MissingValueException(String entityName, Long id) {
		this.entityName = entityName;
		this.id = id;
	}

	@Override
	public String getMessage() {
		return "Attenzione: l'entita' " + this.entityName + " con id = " + this.id + " non e' presente";
	}
}
