package gft.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gft.dto.auth.AutenticacaoDTO;
import gft.dto.auth.TokenDTO;
import gft.services.AutenticacaoService;

@RestController
@RequestMapping("/api/v1/auth")
public class AutenticacaoController {

	@Autowired
	AutenticacaoService autenticacaoService;

	@PostMapping
	public ResponseEntity<TokenDTO> autenticar(@RequestBody AutenticacaoDTO authForm) {

		try {
			return ResponseEntity.ok(autenticacaoService.autenticar(authForm));
		} catch (AuthenticationException ae) {
			ae.printStackTrace();
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}

	}

}