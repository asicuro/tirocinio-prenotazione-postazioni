package it.linksmt.prenotazione.postazioni.core.exceptions;

import it.linksmt.prenotazione.postazioni.core.exceptions.interfaces.CustomException;

public class NestedEntityException extends CustomException {

	private static final long serialVersionUID = 1L;
	private final String entityName;
	private final Long id;
	private static final String TIPOLOGIA_ERRORE = "Entita' con relazioni";

	public NestedEntityException(String entityName, Long id) {
		this.entityName = entityName;
		this.id = id;
	}

	@Override
	public String getMessage() {
		return "Attenzione: l'entita' " + this.entityName + " con id = " + this.id + " ha relazioni attive con una o piu' entita'";
	}

	@Override
	public String getTipologiaErrore() {
		return TIPOLOGIA_ERRORE;
	}

}
