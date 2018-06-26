package br.ufrn.imd.dominio;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Usuario extends PessoaFisica {

	private String matricula;

	@ManyToOne
	private Delegacia delegacia;

	@Enumerated(EnumType.STRING)
	private Perfil perfil;

	@NotNull
	private String login;

	private String senha;

	public Usuario() {
		this.delegacia = new Delegacia();
	}

	public Delegacia getDelegacia() {
		return delegacia;
	}
	public void setDelegacia(Delegacia delegacia) {
		this.delegacia = delegacia;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogin() { return login; }

	public void setLogin(String login) { this.login = login; }
}
