package riccardogulin.u4d12.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import riccardogulin.u4d12.entities.User;
import riccardogulin.u4d12.services.UsersService;

import java.util.List;


/* ******************************* USERS CRUD *********************************

1. GET http://localhost:3001/api/users
2. POST http://localhost:3001/api/users (+request.body), risponde 201 CREATED (nel payload l'utente creato)
3. GET http://localhost:3001/api/users/{userId}
4. PUT http://localhost:3001/api/users/{userId} (+request.body) , risponde con l'utente modificato nel payload
5. DELETE http://localhost:3001/api/users/{userId}, risponde 204 NO CONTENT

*/

@RestController // Specializzazione di @Component che conterrà un elenco di ENDPOINT (funzionalità contraddistinta da METODO HTTP + URL)
@RequestMapping("/api/users")
public class UsersController {

	private final UsersService usersService;

	public UsersController(UsersService usersService) {
		this.usersService = usersService;
	}

	// 1. GET http://localhost:3001/api/users?name=John
	@GetMapping
	public List<User> getUsers(@RequestParam(required = false) String name) { // il nome 'name' deve corrispondere al parametro nell'URL
		return this.usersService.findAll();
	}

	// 2. POST http://localhost:3001/api/users (+request.body), risponde 201 CREATED (nel payload l'utente creato)
	@ResponseStatus(HttpStatus.CREATED) // 201
	@PostMapping
	public User createUser(@RequestBody User payload) {
		return this.usersService.create(payload);
	}

	// 3. GET http://localhost:3001/api/users/{userId}
	@GetMapping("/{userId}")
	public User getUserById(@PathVariable long userId) { // il parametro userId deve corrispondere al parametro nell'URL
		return this.usersService.findById(userId);
	}

	// 4. PUT http://localhost:3001/api/users/{userId} (+request.body), risponde con l'utente modificato nel payload
	@PutMapping("/{userId}")
	public User getUserByIdAndUpdate(@PathVariable long userId,
	                                 @RequestBody User payload) {
		return this.usersService.findByIdAndUpdate(userId, payload);
	}

	// 5. DELETE http://localhost:3001/api/users/{userId}, risponde 204 NO CONTENT
	@DeleteMapping("/{userId}")
	@ResponseStatus(HttpStatus.NO_CONTENT) // 204
	public void getUserByIdAndDelete(@PathVariable long userId) {
		this.usersService.findByIdAndDelete(userId);
	}

}
