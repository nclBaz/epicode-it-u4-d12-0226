package riccardogulin.u4d12.services;

import org.springframework.stereotype.Service;
import riccardogulin.u4d12.entities.User;
import riccardogulin.u4d12.exceptions.NotFoundException;
import riccardogulin.u4d12.repositories.UsersRepository;

import java.util.List;

@Service
public class UsersService {
	private final UsersRepository usersRepository;

	public UsersService(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	public List<User> findAll() {
		return this.usersRepository.findAll();
	}

	public User create(User payload) {
		// 1. Validazione, controlli vari
		// 2. Save dello user
		return this.usersRepository.save(payload);
	}

	public User findById(long userId) {
		// Lanciare un'eccezione in caso di not found non è un problema perché Spring gestisce globalmente
		// le eccezioni e non crasha mai
		return this.usersRepository.findById(userId).orElseThrow(() -> new NotFoundException(userId));
	}

	public User findByIdAndUpdate(long userId, User payload) {
		User userFromDB = this.findById(userId);

		// TODO: Fare validazione

		userFromDB.setName(payload.getName());
		userFromDB.setSurname(payload.getSurname());
		userFromDB.setEmail(payload.getEmail());
		userFromDB.setPassword(payload.getPassword());
		userFromDB.setDateOfBirth(payload.getDateOfBirth());

		return this.usersRepository.save(userFromDB);

	}

	public void findByIdAndDelete(long userId) {
		User userFromDB = this.findById(userId);
		this.usersRepository.delete(userFromDB);
	}
}
