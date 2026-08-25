package riccardogulin.u4d12.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import riccardogulin.u4d12.payloads.ErrorsDTO;

import java.time.LocalDateTime;

@RestControllerAdvice // <-- Indica che questa classe sarà responsabile di catturare tutte le eccezioni dell'applicazione
public class ErrorHandlers {

	@ExceptionHandler(ValidationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST) // 400
	public ErrorsDTO handleValidationEx(ValidationException ex) {
		return new ErrorsDTO(ex.getMessage(), LocalDateTime.now());
	}

	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND) // 404
	public ErrorsDTO handleNotFoundEx(NotFoundException ex) {
		return new ErrorsDTO(ex.getMessage(), LocalDateTime.now());
	}

	@ExceptionHandler(Exception.class) // Cattura tutte le eccezioni (a parte quelle già catturate)
	// in quanto tutte figlie di Exception
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 500
	public ErrorsDTO handleGenericEx(Exception ex) {
		ex.printStackTrace(); // Senza questa riga perdo lo stack trace dell'eccezione quindi sarà più difficile debuggare il problema

		return new ErrorsDTO("Errore interno del server! Giuro che lo risolveremo presto!", LocalDateTime.now());
		// Meglio non mandare in risposta il messaggio dell'eccezione per non divulgare informazioni interne, mandiamo un messaggio
		// generico
	}

}
