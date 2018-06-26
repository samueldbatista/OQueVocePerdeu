package br.ufrn.imd.dominio;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
public class UsuarioLogado implements Serializable {
    private Usuario usuario;

    public void loga(Usuario usuario){
        this.usuario = usuario;
    }

    public boolean isLogado() {
        return this.usuario != null;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void desloga(){
        this.usuario = null;
//        destruir();
    }

    public boolean isAdmin(){
        if(usuario != null) {
            if(usuario.getPerfil().equals(Perfil.ADMINISTRADOR)){
                return true;
            }
        }
        return false;
    }

    public boolean isTecnico(){
        if(usuario != null) {
            if(usuario.getPerfil().equals(Perfil.ADMINISTRADOR) || usuario.getPerfil().equals(Perfil.CONSULTA)){
                return true;
            }
        }
        return false;
    }

    public boolean isCliente(){
        if(usuario != null) {
            if(usuario.getPerfil().equals(Perfil.CLIENTE)){
                return true;
            }
        }
        return false;
    }
}
