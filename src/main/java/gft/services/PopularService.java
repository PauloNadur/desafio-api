package gft.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gft.entities.Categoria;
import gft.entities.Starter;

@Service
public class PopularService {

	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private StarterService starterService;

	private boolean bancoPopulado;

	public List<Starter> popularBanco() throws Exception {

		List<Categoria> listaCategorias = new ArrayList<>();
		List<Starter> listaStarters = new ArrayList<>();

		if (bancoPopulado == true) {
			throw new Exception();
		}

		listaCategorias.add(new Categoria(null, "TURMA #1", "JAVA"));
		listaCategorias.add(new Categoria(null, "TURMA #2", "PYTHON"));
		listaCategorias.add(new Categoria(null, "TURMA #3", "PHP"));
		listaCategorias.add(new Categoria(null, "TURMA #4", ".NET"));
		categoriaService.salvarTodasAsCategorias(listaCategorias);

		listaStarters.add(new Starter(null, "Paulo Nadur", "433.534.708-16", "PERR", "perr@gft.com",
				categoriaService.obterCategoria(1l)));
		listaStarters.add(new Starter(null, "Alberto Cido", "937.462.628-44", "ABCD", "abcd@gft.com",
				categoriaService.obterCategoria(2l)));
		listaStarters.add(new Starter(null, "Efraim Ghunter", "151.842.888-64", "EFGH", "efgh@gft.com",
				categoriaService.obterCategoria(3l)));
		listaStarters.add(new Starter(null, "Ijander Klopp", "907.130.468-05", "IJKL", "ijkl@gft.com",
				categoriaService.obterCategoria(4l)));
		starterService.salvarTodosOsStarters(listaStarters);

		bancoPopulado = true;

		return listaStarters;
	}

}
