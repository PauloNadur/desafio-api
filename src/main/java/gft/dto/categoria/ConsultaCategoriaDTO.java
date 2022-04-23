package gft.dto.categoria;

public class ConsultaCategoriaDTO {
	
		private Long id;

		private String nomeCategoria;

		private String tecnologia;

		public ConsultaCategoriaDTO() {
		}

		public ConsultaCategoriaDTO(Long id, String nomeCategoria, String tecnologia) {
			this.id = id;
			this.nomeCategoria = nomeCategoria;
			this.tecnologia = tecnologia;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
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
