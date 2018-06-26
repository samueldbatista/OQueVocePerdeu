package br.ufrn.imd.dominio;

import javax.persistence.*;
import java.util.List;

@Entity
public class BoletimOcorrencia extends Entidade {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long numeroBo;

    @OneToMany
    private List<Objeto> objetos;

    @ManyToOne
    private Pessoa vitima;


    @Enumerated(EnumType.STRING)
    private TipoOcorrencia tipoOcorrencia;


    public BoletimOcorrencia() {

    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {

    }

    public List<Objeto> getObjetos() {
        return objetos;
    }

    public void setObjetos(List<Objeto> objetos) {
        this.objetos = objetos;
    }

    public Pessoa getVitima() {
        return vitima;
    }

    public void setVitima(Pessoa vitima) {
        this.vitima = vitima;
    }

    public TipoOcorrencia getTipoOcorrencia() {
        return tipoOcorrencia;
    }

    public void setTipoOcorrencia(TipoOcorrencia tipoOcorrencia) {
        this.tipoOcorrencia = tipoOcorrencia;
    }

    public Long getNumeroBo() {
        return numeroBo;
    }

    public void setNumeroBo(Long numeroBo) {
        this.numeroBo = numeroBo;
    }
}
