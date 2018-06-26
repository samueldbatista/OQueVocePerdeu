package br.ufrn.imd.web.mbean;

import br.ufrn.imd.dominio.Objeto;
import br.ufrn.imd.dominio.TipoDocumento;
import br.ufrn.imd.sbean.PesquisarSB;
import br.ufrn.imd.sbean.PesquisarSBInterface;
import br.ufrn.imd.util.OpcaoSelect;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class PesquisaMB implements Serializable {

    private String identificador = "";
    private List<Objeto> objetos = new ArrayList<>();

    @EJB
    PesquisarSBInterface pesquisarSB;

    public String pesquisar() {
        objetos = pesquisarSB.pesquisar(identificador);
        return "/index.xhtml#section2";
    }

    public void pesquisaPublica() {
        objetos = pesquisarSB.pesquisar(identificador);
    }

    public List<Objeto> getObjetos() { return objetos; }

    public void setObjetos(List<Objeto> objetos) { this.objetos = objetos; }

    public List<OpcaoSelect> selectsTipo(){
        return TipoDocumento.retornarOpcaoSelect();
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
}
