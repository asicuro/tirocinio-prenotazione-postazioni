package it.linksmt.prenotazione.postazioni.core.exceptions;

import it.linksmt.prenotazione.postazioni.core.exceptions.interfaces.CustomException;

public class MissingValueException extends CustomException {

	private static final long serialVersionUID = 1L;
	private final String entityName;
	private final Long id;
	private static final String TIPOLOGIA_ERRORE = "Entita' non trovata";

	public MissingValueException(String entityName, Long id) {
		this.entityName = entityName;
		this.id = id;
	}

	@Override
	public String getMessage() {
		return "Attenzione: l'entita' " + this.entityName + " con id = " + this.id + " non e' presente";
	}

	@Override
	public String getTipologiaErrore() {
		return TIPOLOGIA_ERRORE;
	}
}
