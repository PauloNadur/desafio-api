package gft.dto.usuario;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import gft.entities.Perfil;
import gft.entities.Usuario;

public class UsuarioMapper {

	public static Usuario fromDTOToEntity(RegistroUsuarioDTO dto) {

		Perfil perfil = new Perfil();
		perfil.setId(dto.getPerfilId());

		return new Usuario(null, dto.getEmail(), new BCryptPasswordEncoder().encode(dto.getSenha()), perfil);
	}

	public static ConsultaUsuarioDTO fromEntityToDTO(Usuario usuario) {

		return new ConsultaUsuarioDTO(usuario.getEmail(), usuario.getPerfil().getNome());
	}

}
