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

import gft.dto.starter.ConsultaStarterDTO;
import gft.dto.starter.RegistroStarterDTO;
import gft.dto.starter.StarterMapper;
import gft.entities.Starter;
import gft.services.StarterService;

@RestController
@RequestMapping("/api/v1/starter")
public class StarterController {

	private final StarterService starterService;

	public StarterController(StarterService starterService) {
		this.starterService = starterService;
	}

	@GetMapping
	public ResponseEntity<Page<ConsultaStarterDTO>> buscarTodosOsStarters(@PageableDefault Pageable pageable) {

		return ResponseEntity.ok(starterService.listarTodosOsStarters(pageable).map(StarterMapper::fromEntityToDTO));
	}

	@PostMapping
	public ResponseEntity<ConsultaStarterDTO> salvarStarter(@RequestBody RegistroStarterDTO dto) {

		Starter starter = starterService.salvarStarter(StarterMapper.fromDTOToEntity(dto));
		return ResponseEntity.ok(StarterMapper.fromEntityToDTO(starter));
	}

	@GetMapping("{id}")
	public ResponseEntity<ConsultaStarterDTO> buscarStarter(@PathVariable Long id) {

		Starter starter = starterService.buscarStarter(id);
		return ResponseEntity.ok(StarterMapper.fromEntityToDTO(starter));
	}

	@PutMapping("{id}")
	public ResponseEntity<ConsultaStarterDTO> alterarStarter(@RequestBody RegistroStarterDTO dto,
			@PathVariable Long id) {

		try {
			Starter starter = starterService.atualizarStarter(StarterMapper.fromDTOToEntity(dto), id);
			return ResponseEntity.ok(StarterMapper.fromEntityToDTO(starter));
		} catch (RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("{id}")
	public ResponseEntity<ConsultaStarterDTO> excluirStarter(@PathVariable Long id) {

		try {
			starterService.excluirStarter(id);
			return ResponseEntity.ok().build();
		} catch (RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
	}
}
