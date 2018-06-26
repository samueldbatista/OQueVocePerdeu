package br.ufrn.imd.web.mbean;

import br.ufrn.imd.dao.DelegaciaDao;
import br.ufrn.imd.dao.UsuarioDao;
import br.ufrn.imd.dominio.Delegacia;
import br.ufrn.imd.dominio.Perfil;
import br.ufrn.imd.dominio.Usuario;
import br.ufrn.imd.sbean.UsuarioSBInterface;
import br.ufrn.imd.util.OpcaoSelect;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SessionScoped
@Named
public class UsuarioMB implements Serializable {
    @Inject
    private HttpServletRequest httpServletRequest;

    @Inject
    private UsuarioDao usuarioDao;

    @Inject
    private DelegaciaDao delegaciaDao;

    private Perfil perfil = Perfil.ADMINISTRADOR;

    @EJB
    private UsuarioSBInterface usuarioSB;

    private Usuario usuario = new Usuario();

    private List<Delegacia> delegacias = new ArrayList<>();

    public String salvar() {
        usuarioSB.salvar(this.usuario);
        usuario = new Usuario();
        return "/usuarios/lista.xhtml?faces-redirect=true";
    }

    public List<Usuario> listar() {
        return usuarioSB.listar();
    }

    public String editar(Long id) {
        this.usuario = this.usuarioSB.editar(id);
        return "/usuarios/form.xhtml?faces-redirect=true";
    }

    public String remover(Long id) {
        this.usuarioSB.remover(id);
        return "/usuarios/lista.xhtml?faces-redirect=true";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<OpcaoSelect> selectPerfis(){
        return Perfil.retornarOpcaoSelect();
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public List<Delegacia> getDelegacias() {
        delegacias = delegaciaDao.todos();
        return delegacias;
    }

    public void setDelegacias(List<Delegacia> delegacias) {
        this.delegacias = delegacias;
    }


}