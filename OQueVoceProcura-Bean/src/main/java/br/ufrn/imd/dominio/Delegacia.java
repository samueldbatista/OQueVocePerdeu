package br.ufrn.imd.dominio;

import javax.persistence.*;

@Entity
public class Delegacia extends Entidade{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String abreviatura;
	private String telefone;
	@OneToOne(cascade = CascadeType.PERSIST)
	private Endereco endereco;
	private boolean deletado;

	public Delegacia(){
		this.endereco = new Endereco();
		this.deletado = false;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAbreviatura() {
		return abreviatura;
	}
	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public boolean isDeletado() { return deletado; }
	public void setDeletado(boolean deletado) { this.deletado = deletado; }
}
