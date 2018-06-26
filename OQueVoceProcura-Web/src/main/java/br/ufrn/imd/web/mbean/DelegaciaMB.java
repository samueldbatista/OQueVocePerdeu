package br.ufrn.imd.web.mbean;

import br.ufrn.imd.dao.DelegaciaDao;
import br.ufrn.imd.dominio.Delegacia;
import br.ufrn.imd.sbean.DelegaciaSBInterface;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@RequestScoped
@Named
public class DelegaciaMB implements Serializable {

    @Inject
    private DelegaciaDao delegaciaDao;

    private Delegacia delegacia = new Delegacia();

    @EJB
    private DelegaciaSBInterface delegaciaSB;


    public String salvar() {
        delegaciaSB.salvar(this.delegacia);
        delegacia = new Delegacia();

        return "/delegacia/lista?faces-redirect=true";
    }

    public List<Delegacia> listar() {
        return delegaciaSB.listar();
    }

    public String editar(Long id) {
        this.delegacia = this.delegaciaSB.editar(id);

        return "/delegacia/form.xhtml";
    }

    public void remover(Long id) {
        delegaciaSB.remover(id);
        delegacia = new Delegacia();
    }

    public Delegacia getDelegacia() {
        return delegacia;
    }

    public void setDelegacia(Delegacia delegacia) {
        this.delegacia = delegacia;
    }

}
