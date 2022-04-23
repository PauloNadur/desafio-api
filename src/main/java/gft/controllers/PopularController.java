package gft.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gft.entities.Starter;
import gft.services.PopularService;

@Controller
@RequestMapping("/api/v1/popular")
public class PopularController {

	@Autowired
	private PopularService popularService;

	@PostMapping
	public ResponseEntity<List<Starter>> popularBanco() throws Exception {
		
			List<Starter> listStarters = popularService.popularBanco();
			return ResponseEntity.ok(listStarters);
	}
	
}
