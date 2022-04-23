package gft.dto.categoria;

public class RegistroCategoriaDTO {

	private String nomeCategoria;
	private String tecnologia;

	public RegistroCategoriaDTO() {
	}

	public RegistroCategoriaDTO(String nomeCategoria, String tecnologia) {
		this.nomeCategoria = nomeCategoria;
		this.tecnologia = tecnologia;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public String getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}

}
