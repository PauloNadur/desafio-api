package gft.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import gft.entities.Starter;
import gft.exception.EntityNotFoundException;
import gft.repositories.StarterRepository;

@Service
public class StarterService {

	private final StarterRepository starterRepository;

	public StarterService(StarterRepository starterRepository) {
		this.starterRepository = starterRepository;
	}

	public Starter salvarStarter(Starter starter) {
		return starterRepository.save(starter);
	}
	
	public List<Starter> salvarTodosOsStarters(List<Starter> starter) {
		return starterRepository.saveAll(starter);
	}

	public Page<Starter> listarTodosOsStarters(Pageable pageable) {
		return starterRepository.findAll(pageable);
	}

	public Starter buscarStarter(Long id) {
		Optional<Starter> optional = starterRepository.findById(id);
		return optional.orElseThrow(() -> new EntityNotFoundException("Starter não encontrado."));
	}

	public Starter atualizarStarter(Starter starter, Long id) {
		Starter starterOriginal = this.buscarStarter(id);
		starter.setId(starterOriginal.getId());
		return starterRepository.save(starter);
	}

	public void excluirStarter(Long id) {
		Starter starterOriginal = this.buscarStarter(id);
		starterRepository.delete(starterOriginal);
	}

}
