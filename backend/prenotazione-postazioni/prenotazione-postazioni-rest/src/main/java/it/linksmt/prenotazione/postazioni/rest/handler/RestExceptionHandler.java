package it.linksmt.prenotazione.postazioni.rest.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import it.linksmt.prenotazione.postazioni.core.exceptions.InvalidValueException;
import it.linksmt.prenotazione.postazioni.core.exceptions.MissingValueException;
import it.linksmt.prenotazione.postazioni.core.exceptions.NestedEntityException;
import it.linksmt.prenotazione.postazioni.core.exceptions.interfaces.CustomException;
import it.linksmt.prenotazione.postazioni.rest.output.ErrorResponse;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(InvalidValueException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	protected ResponseEntity<ErrorResponse> invalidValue(InvalidValueException exception) {

		return valorizzaErrorResponse(HttpStatus.BAD_REQUEST, exception);
	}

	@ExceptionHandler(MissingValueException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	protected ResponseEntity<ErrorResponse> missingValue(MissingValueException exception) {

		return valorizzaErrorResponse(HttpStatus.NOT_FOUND, exception);
	}

	@ExceptionHandler(NestedEntityException.class)
	@ResponseStatus(HttpStatus.NOT_MODIFIED)
	protected ResponseEntity<ErrorResponse> nestedEntity(NestedEntityException exception) {

		return valorizzaErrorResponse(HttpStatus.NOT_MODIFIED, exception);
	}

	private ResponseEntity<ErrorResponse> valorizzaErrorResponse(HttpStatus status, CustomException exception) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setTimestamp(new Date()).setStatus(status.toString()).setMessage(exception.getMessage())
				.setError(exception.getTipologiaErrore());
		return new ResponseEntity<>(errorResponse, status);
	}

}
