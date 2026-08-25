package riccardogulin.u4d12.payloads;

import java.time.LocalDate;

public record NewUserDTO(String name, String surname, String email, String password, LocalDate dateOfBirth) {
}
