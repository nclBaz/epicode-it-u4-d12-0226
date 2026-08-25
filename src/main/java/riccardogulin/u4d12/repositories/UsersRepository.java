package riccardogulin.u4d12.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import riccardogulin.u4d12.entities.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
}
