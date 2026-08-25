package riccardogulin.u4d12.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "videos")
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Video {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(AccessLevel.NONE)
	private long id;

	private String titolo;
	private int durata;
	private boolean pubblicato;

	@ManyToOne
	@JoinColumn(name = "creator_id", nullable = false)
	@Setter(AccessLevel.NONE)
	private User creator;

	public Video(String titolo, int durata, User creator) {
		this.titolo = titolo;
		this.durata = durata;
		this.pubblicato = false;
		this.creator = creator;
	}
}
