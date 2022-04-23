package gft.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gft.dto.categoria.CategoriaMapper;
import gft.dto.categoria.ConsultaCategoriaDTO;
import gft.dto.categoria.RegistroCategoriaDTO;
import gft.entities.Categoria;
import gft.services.CategoriaService;

@RestController
@RequestMapping("/api/v1/categoria")
public class CategoriaController {

	private final CategoriaService categoriaService;

	public CategoriaController(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}

	@GetMapping
	public ResponseEntity<Page<ConsultaCategoriaDTO>> buscarTodasAsCategorias(@PageableDefault Pageable pageable) {

		return ResponseEntity.ok(categoriaService.listarTodasAsCategorias(pageable).map(CategoriaMapper::fromEntityToDTO));
	}

	@PostMapping
	public ResponseEntity<ConsultaCategoriaDTO> salvarCategoria(@RequestBody RegistroCategoriaDTO dto) {

		Categoria categoria = categoriaService.salvarCategoria(CategoriaMapper.fromDTOToEntity(dto));
		return ResponseEntity.ok(CategoriaMapper.fromEntityToDTO(categoria));
	}

	@GetMapping("{id}")
	public ResponseEntity<ConsultaCategoriaDTO> buscarCategoria(@PathVariable Long id) {

		Categoria categoria = categoriaService.buscarCategoria(id);
		return ResponseEntity.ok(CategoriaMapper.fromEntityToDTO(categoria));
	}

	@PutMapping("{id}")
	public ResponseEntity<ConsultaCategoriaDTO> alterarCategoria(@RequestBody RegistroCategoriaDTO dto,
			@PathVariable Long id) {

		try {
			Categoria categoria = categoriaService.atualizarCategoria(CategoriaMapper.fromDTOToEntity(dto), id);
			return ResponseEntity.ok(CategoriaMapper.fromEntityToDTO(categoria));
		} catch (RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("{id}")
	public ResponseEntity<ConsultaCategoriaDTO> excluirCategoria(@PathVariable Long id) {

		try {
			categoriaService.excluirCategoria(id);
			return ResponseEntity.ok().build();
		} catch (RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
	}
}
