package br.ufrn.imd.sbean;

import br.ufrn.imd.dao.UsuarioDao;
import br.ufrn.imd.dominio.Usuario;
import br.ufrn.imd.util.Criptografia;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Optional;

@Local
@Stateless
public class LoginSB implements LoginSBInterface {

    @Inject
    private UsuarioDao usuarioDao;

    @Override
    public Usuario validarUsuario(Usuario usuario) {
        if(usuario != null) {
            Optional<Usuario> usuarioBanco = usuarioDao.buscarPorLogin(usuario.getLogin());
            if(usuarioBanco.isPresent()) {
                if(compararSenha(usuario.getSenha(), usuarioBanco.get().getSenha())){
                    return usuarioBanco.get();
                }
            }
        }
        return null;
    }

    private boolean compararSenha(String senha, String senhaBanco) {
        if(Criptografia.criptografar(senha).equals(senhaBanco)) {
            return true;
        }
        return false;
    }
}
