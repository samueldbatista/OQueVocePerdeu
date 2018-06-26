package br.ufrn.imd.sbean;

import br.ufrn.imd.dao.UsuarioDao;
import br.ufrn.imd.dominio.Usuario;
import br.ufrn.imd.util.Criptografia;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Local
@Stateless
public class UsuarioSB implements UsuarioSBInterface {

    @Inject
    private UsuarioDao usuarioDao;

    @Override
    public Usuario salvar(Usuario usuario) {
        usuario.setSenha(criptografarSenha(usuario.getSenha()));
        Usuario user = usuarioDao.salvar(usuario);
        return user;
    }

    @Override
    public Usuario editar(Long id) {
        Usuario usuario = usuarioDao.buscarPorId(id);
        return usuario;
    }

    @Override
    public List<Usuario> listar() {
        return usuarioDao.todos();
    }

    @Override
    public void remover(Long id) {
        Usuario usuario = usuarioDao.buscarPorId(id);
        usuarioDao.remover(usuario);
    }

    private String criptografarSenha(String senha) {
        return Criptografia.criptografar(senha);
    }

}
