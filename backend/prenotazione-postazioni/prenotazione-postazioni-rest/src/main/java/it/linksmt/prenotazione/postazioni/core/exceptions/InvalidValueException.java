package it.linksmt.prenotazione.postazioni.core.exceptions;

public class InvalidValueException extends Exception {

	private static final long serialVersionUID = 1L;
	private final String valueName;
	private final Object value;
	private final String tipologiaErrore = "Valore inserito non valido";

	public InvalidValueException(String valueName, Object value) {
		this.value = value;
		this.valueName = valueName;
	}

	@Override
	public String getMessage() {
		return "Attenzione: il campo " + this.valueName + " contiene il valore non valido "
				+ (value == null ? "NULL" : value.toString());
	}

	public String getTipologiaErrore() {
		return tipologiaErrore;
	}
}
