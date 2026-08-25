package riccardogulin.u4d12.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import riccardogulin.u4d12.entities.User;
import riccardogulin.u4d12.entities.Video;

import java.util.List;

@Repository
public interface VideosRepository extends JpaRepository<Video, Long> {

	// QUERIES JPQL
	@Query("SELECT v FROM Video v WHERE v.pubblicato = true AND v.creator.id = :creatorId")
	// SELECT * FROM videos WHERE pubblicato = true AND creator_id = :creatorId
	List<Video> filterByPubblicatoAndCreatorId(long creatorId);


	@Query("SELECT v FROM Video v WHERE v.pubblicato = true AND v.creator = :creator")
		// SELECT * FROM videos WHERE pubblicato = true AND creator_id = :creatorId
	List<Video> filterByPubblicatoAndCreator(User creator);
}
