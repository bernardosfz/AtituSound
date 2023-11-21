package br.edu.atitus.poo.atitusound.servicesimpl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.edu.atitus.poo.atitusound.entities.UserEntity;
import br.edu.atitus.poo.atitusound.repositories.GenericRepository;
import br.edu.atitus.poo.atitusound.repositories.UserRepository;
import br.edu.atitus.poo.atitusound.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository repository;
	private final PasswordEncoder passwordEncoder;

	public UserServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder) {
		super();
		this.repository = repository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public GenericRepository<UserEntity> getRepository() {

		return repository;
	}

	@Override
	public void validate(UserEntity entity) throws Exception {
		UserService.super.validate(entity);
		if (entity.getUsername() == null || entity.getUsername().isEmpty())
			throw new Exception("Campo Username inválido");
		if (entity.getUuid() == null) {
			if (repository.existsByUsername(entity.getUsername()))
				throw new Exception("Já existe um usuário com este username");
		} else {
			if (repository.existsByNameAndUuidNot(entity.getUsername(), entity.getUuid()))
				throw new Exception("Já existe um usuário com este username");
		}
		entity.setPassword(passwordEncoder.encode(entity.getPassword()));
	}
}