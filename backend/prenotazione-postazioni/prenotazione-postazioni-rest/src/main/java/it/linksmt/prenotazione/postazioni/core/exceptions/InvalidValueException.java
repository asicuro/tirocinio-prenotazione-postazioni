package it.linksmt.prenotazione.postazioni.core.exceptions;

public class InvalidValueException extends Exception{
	
	private String valueName;
	private Object value;
	
	public InvalidValueException(String valueName, Object value) {
		this.value = value;
		this.valueName = valueName;
	}
	
	@Override
	public String getMessage() {
		return "Attenzione: il campo " + this.valueName + " contiene il valore non valido " 
				+ ((value == null ? "NULL" : value.toString())) ;
	}
}
