package br.ufrn.imd.dao;

import br.ufrn.imd.dominio.Usuario;

import java.util.Optional;

public interface UsuarioDao extends EntidadeDao<Usuario> {

    Optional<Usuario> buscarPorLogin(String login);
}
