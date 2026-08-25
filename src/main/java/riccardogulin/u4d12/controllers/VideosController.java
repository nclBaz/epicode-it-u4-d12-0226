package riccardogulin.u4d12.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import riccardogulin.u4d12.entities.Video;
import riccardogulin.u4d12.payloads.NewVideoDTO;
import riccardogulin.u4d12.payloads.UpdateVideoDTO;
import riccardogulin.u4d12.services.VideosService;

import java.util.List;

/*

1. POST http://localhost:3001/api/videos (+req.body), risponde 201 e il video creato
2. GET http://localhost:3001/api/videos
3. GET http://localhost:3001/api/videos/{videoId}
4. PUT http://localhost:3001/api/videos/{videoId} (+req.body)
5. DELETE http://localhost:3001/api/videos/{videoId}, risponde 204

*/

@RestController
@RequestMapping("/api/videos")
public class VideosController {
	private final VideosService videosService;

	public VideosController(VideosService videosService) {
		this.videosService = videosService;
	}

	// 1. POST http://localhost:3001/api/videos (+req.body), risponde 201 e il video creato
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED) // 201
	public Video create(@RequestBody NewVideoDTO payload) {
		return this.videosService.create(payload);
	}

	// 2. GET http://localhost:3001/api/videos
	@GetMapping
	public List<Video> getAll() {
		return this.videosService.getAll();
	}

	// 3. GET http://localhost:3001/api/videos/{videoId}
	@GetMapping("/{videoId}")
	public Video getById(@PathVariable long videoId) {
		return this.videosService.getById(videoId);
	}

	// 4. PUT http://localhost:3001/api/videos/{videoId} (+req.body)
	@PutMapping("/{videoId}")
	public Video getByIdAndUpdate(@PathVariable long videoId, @RequestBody UpdateVideoDTO payload) {
		return this.videosService.getByIdAndUpdate(videoId, payload);
	}

	// 5. DELETE http://localhost:3001/api/videos/{videoId}, risponde 204
	@DeleteMapping("/{videoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT) // 204
	public void getByIdAndDelete(@PathVariable long videoId) {
		this.videosService.getByIdAndDelete(videoId);
	}


}
