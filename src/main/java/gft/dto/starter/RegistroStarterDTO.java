package gft.dto.starter;

import gft.entities.Categoria;

public class RegistroStarterDTO {

	private String nome;
	private String cpf;
	private String quatroLetras;
	private String email;
	private Categoria categoria;

	public RegistroStarterDTO() {
	}

	public RegistroStarterDTO(String nome, String cpf, String quatroLetras, String email, Categoria categoria) {
		this.nome = nome;
		this.cpf = cpf;
		this.quatroLetras = quatroLetras;
		this.email = email;
		this.categoria = categoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getQuatroLetras() {
		return quatroLetras;
	}

	public void setQuatroLetras(String quatroLetras) {
		this.quatroLetras = quatroLetras;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
