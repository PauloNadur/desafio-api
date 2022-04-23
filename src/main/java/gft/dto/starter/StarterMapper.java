package gft.dto.starter;

import gft.entities.Starter;

public class StarterMapper {

	public static Starter fromDTOToEntity(RegistroStarterDTO dto) {
		return new Starter(null, dto.getNome(), dto.getCpf(), dto.getQuatroLetras(), 
				dto.getEmail(), dto.getCategoria());
	}

	public static ConsultaStarterDTO fromEntityToDTO(Starter starter) {
		return new ConsultaStarterDTO(starter.getId(), starter.getNome(), starter.getCpf(), 
				starter.getQuatroLetras(), starter.getEmail(), starter.getCategoria());
	}
	
}
