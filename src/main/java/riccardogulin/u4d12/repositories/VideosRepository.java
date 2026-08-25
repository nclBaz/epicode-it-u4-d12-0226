package riccardogulin.u4d12.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import riccardogulin.u4d12.entities.Video;

@Repository
public interface VideosRepository extends JpaRepository<Video, Long> {
}
