package riccardogulin.u4d12.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;

import java.time.LocalDate;

public record NewUserDTO(
		String name,
		String surname,
		@Email(message = "L'indirizzo inserito non è un email valida")
		String email,
		@Min(value = 4, message = "La password deve essere di almeno 4 caratteri")

		String password,
		LocalDate dateOfBirth) {
}
