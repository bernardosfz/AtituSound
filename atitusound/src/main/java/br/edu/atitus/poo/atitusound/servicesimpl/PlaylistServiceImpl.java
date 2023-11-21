package br.edu.atitus.poo.atitusound.servicesimpl;

import org.springframework.stereotype.Service;

import br.edu.atitus.poo.atitusound.entities.PlaylistEntity;
import br.edu.atitus.poo.atitusound.repositories.GenericRepository;
import br.edu.atitus.poo.atitusound.repositories.PlaylistRepository;
import br.edu.atitus.poo.atitusound.services.PlaylistService;

@Service
public class PlaylistServiceImpl implements PlaylistService{

	private final PlaylistRepository repository;
	
	
	public PlaylistServiceImpl(PlaylistRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public GenericRepository<PlaylistEntity> getRepository() {
		return repository;
	}

}
