package riccardogulin.u4d12.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import riccardogulin.u4d12.entities.Video;
import riccardogulin.u4d12.payloads.NewVideoDTO;
import riccardogulin.u4d12.services.VideosService;

/*

1. POST http://localhost:3001/api/videos (+req.body), risponde 201 e il video creato
2. GET http://localhost:3001/api/videos
3. GET http://localhost:3001/api/videos/{videoId}
4. PUT http://localhost:3001/api/videos/{videoId} (+req.body)
5. DELETE http://localhost:3001/api/videos/{videoId}, risponde 204

*/

@RestController
public class VideosController {
	private final VideosService videosService;

	public VideosController(VideosService videosService) {
		this.videosService = videosService;
	}

	// 1. POST http://localhost:3001/api/videos (+req.body), risponde 201 e il video creato
	@PostMapping("/api/videos")
	@ResponseStatus(HttpStatus.CREATED) // 201
	public Video create(@RequestBody NewVideoDTO payload) {
		return this.videosService.create(payload);
	}
}
