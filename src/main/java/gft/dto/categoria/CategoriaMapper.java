package gft.dto.categoria;

import gft.entities.Categoria;

public class CategoriaMapper {

	public static Categoria fromDTOToEntity(RegistroCategoriaDTO dto) {
		return new Categoria(null, dto.getNomeCategoria(), dto.getTecnologia());
	}

	public static ConsultaCategoriaDTO fromEntityToDTO(Categoria categoria) {
		return new ConsultaCategoriaDTO(categoria.getId(), categoria.getNomeCategoria(), categoria.getTecnologia());
	}
	
}
