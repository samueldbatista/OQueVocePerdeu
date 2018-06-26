package br.ufrn.imd.web.mbean;

import br.ufrn.imd.dominio.Usuario;
import br.ufrn.imd.dominio.UsuarioLogado;
import br.ufrn.imd.sbean.LoginSBInterface;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import javax.ws.rs.POST;
import java.io.Serializable;

@SessionScoped
@Named
public class LoginMB implements Serializable {

    @EJB
    LoginSBInterface loginSB;

    private UsuarioLogado usuarioLogado;

    Usuario usuario = new Usuario();

    public String logar() {
        usuario = loginSB.validarUsuario(usuario);

        System.out.println("Usuario" + usuario);
        if(usuario != null){
            return "/index?faces-redirect=true";
        } else{
            logout();
            return "";
        }

    }

    public Usuario getUsuario() { return usuario; }

    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().remove("#{loginMB}");
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.invalidate();

        return "/index.xhtml?faces-redirect=true";
    }

}
