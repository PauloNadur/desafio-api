package gft.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import gft.entities.Categoria;
import gft.exception.EntityNotFoundException;
import gft.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	private final CategoriaRepository categoriaRepository;

	public CategoriaService(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}

	public Categoria salvarCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	public List<Categoria> salvarTodasAsCategorias(List<Categoria> categoria) {
		return categoriaRepository.saveAll(categoria);
	}

	public Page<Categoria> listarTodasAsCategorias(Pageable pageable) {
		return categoriaRepository.findAll(pageable);
	}
	
	// TODO create obterCategoria para a PopularService
	public Categoria obterCategoria(Long id) throws Exception {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		if (categoria.isEmpty()) {
			throw new Exception("Categoria não encontrada.");
		}
		return categoria.get();
	}

	public Categoria buscarCategoria(Long id) {
		Optional<Categoria> optional = categoriaRepository.findById(id);
		return optional.orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada."));
	}

	public Categoria atualizarCategoria(Categoria categoria, Long id) {
		Categoria categoriaOriginal = this.buscarCategoria(id);
		categoria.setId(categoriaOriginal.getId());
		return categoriaRepository.save(categoria);
	}

	public void excluirCategoria(Long id) {
		Categoria categoriaOriginal = this.buscarCategoria(id);
		categoriaRepository.delete(categoriaOriginal);
	}

}
