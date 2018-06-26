package br.ufrn.imd.sbean;

import br.ufrn.imd.dominio.Usuario;

import java.util.List;

public interface UsuarioSBInterface {

    Usuario salvar(Usuario usuario);
    List<Usuario> listar();
    void remover(Long id);
    Usuario editar(Long id);

}
