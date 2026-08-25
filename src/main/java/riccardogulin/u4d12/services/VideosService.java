package riccardogulin.u4d12.services;

import org.springframework.stereotype.Service;
import riccardogulin.u4d12.entities.User;
import riccardogulin.u4d12.entities.Video;
import riccardogulin.u4d12.exceptions.NotFoundException;
import riccardogulin.u4d12.payloads.NewVideoDTO;
import riccardogulin.u4d12.payloads.UpdateVideoDTO;
import riccardogulin.u4d12.repositories.VideosRepository;

import java.util.List;

@Service
public class VideosService {
	private final VideosRepository videosRepository;
	private final UsersService usersService;

	public VideosService(VideosRepository videosRepository, UsersService usersService) {
		this.videosRepository = videosRepository;
		this.usersService = usersService;
	}

	public Video create(NewVideoDTO payload) {

		/*
		Nel payload c'è {
			    "titolo": "Video",
	            "durata": 29,
	            "creatorId": 1
            }
		*/

		// 0. TODO: Validazione
		// 1. Cerco l'utente/creator nel DB tramite ID
		User fromDB = this.usersService.findById(payload.creatorId());
		// 2. Creo l'oggetto Video passandogli l'utente trovato
		Video newVideo = new Video(payload.titolo(), payload.durata(), fromDB);
		// 3. Save
		return this.videosRepository.save(newVideo);
	}

	public List<Video> getAll() {
		return this.videosRepository.findAll();
	}

	public Video getById(long videoId) {
		return this.videosRepository.findById(videoId).orElseThrow(() -> new NotFoundException(videoId));
	}

	public Video getByIdAndUpdate(long videoId, UpdateVideoDTO payload) {
		Video fromDB = this.getById(videoId);
		fromDB.setTitolo(payload.titolo());
		fromDB.setDurata(payload.durata());
		fromDB.setPubblicato(payload.pubblicato());

		return this.videosRepository.save(fromDB);
	}

	public void getByIdAndDelete(long videoId) {
		Video fromDB = this.getById(videoId);
		this.videosRepository.delete(fromDB);
	}
}
