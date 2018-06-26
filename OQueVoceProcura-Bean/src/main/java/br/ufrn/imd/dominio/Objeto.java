package br.ufrn.imd.dominio;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

@Entity
public class Objeto extends Entidade{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Objeto() {
		this.delegacia = new Delegacia();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String identificador;

	@Enumerated(EnumType.STRING)
	private StatusObjeto status;

	@Enumerated(EnumType.STRING)
	private CondicaoObjeto condicao;

	private LocalDateTime dataCadastro;
	private String descricao;

	@Enumerated(EnumType.STRING)
	private TipoObjeto tipo;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Foto> fotos;

	@ManyToOne
	private Delegacia delegacia;
	

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
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public StatusObjeto getStatus() {
		return status;
	}
	public void setStatus(StatusObjeto status) {
		this.status = status;
	}
	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Delegacia getDelegacia() {
		return delegacia;
	}
	public void setDelegacia(Delegacia delegacia) {
		this.delegacia = delegacia;
	}

	public TipoObjeto getTipo() {
		return tipo;
	}

	public void setTipo(TipoObjeto tipo) {
		this.tipo = tipo;
	}

	public List<Foto> getFotos() {
		return fotos;
	}

	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}

	public CondicaoObjeto getCondicao() {
		return condicao;
	}

	public void setCondicao(CondicaoObjeto condicao) {
		this.condicao = condicao;
	}
}
