package riccardogulin.u4d12.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import riccardogulin.u4d12.entities.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {

	// DERIVED QUERIES
	// Documentazione: https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
	Optional<User> findByEmail(String email);

	List<User> findBySurname(String surname);

}
