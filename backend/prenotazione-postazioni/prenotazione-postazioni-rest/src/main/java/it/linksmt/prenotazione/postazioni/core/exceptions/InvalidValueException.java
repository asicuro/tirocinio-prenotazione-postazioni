package it.linksmt.prenotazione.postazioni.core.exceptions;

import it.linksmt.prenotazione.postazioni.core.exceptions.interfaces.CustomException;

public class InvalidValueException extends CustomException {

	private static final long serialVersionUID = 1L;
	private final String valueName;
	private final Object value;
	private static final String TIPOLOGIA_ERRORE = "Valore inserito non valido";

	public InvalidValueException(String valueName, Object value) {
		this.value = value;
		this.valueName = valueName;
	}

	@Override
	public String getMessage() {
		return "Attenzione: il campo " + this.valueName + " contiene il valore non valido " + (value == null ? "NULL" : value.toString());
	}

	@Override
	public String getTipologiaErrore() {
		return TIPOLOGIA_ERRORE;
	}
}
