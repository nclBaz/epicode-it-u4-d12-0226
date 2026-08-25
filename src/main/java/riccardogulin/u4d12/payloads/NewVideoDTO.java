package riccardogulin.u4d12.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record NewVideoDTO(
		@NotBlank(message = "Il titolo non può essere vuoto nè composto da soli spazi")
		String titolo,
		@Positive(message = "La durata deve essere un numero positivo")
		int durata,
		@NotNull(message = "L'id del creatore deve essere obbligatorio")
		long creatorId) {
}
