package riccardogulin.u4d12.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@NoArgsConstructor
@ToString
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(AccessLevel.NONE)
	private long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String surname;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	@JsonIgnore // <-- la PW non deve far MAI parte di un JSON
	private String password;
	@Column(nullable = false, name = "date_of_birth")
	private LocalDate dateOfBirth;
	@Enumerated(EnumType.STRING)
	@Setter(AccessLevel.NONE)
	private Role role;

	public User(String name, String surname, String email, String password, LocalDate dateOfBirth) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.role = Role.USER;
	}


}
