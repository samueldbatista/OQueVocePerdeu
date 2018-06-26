package br.ufrn.imd.dao;

import javax.enterprise.context.RequestScoped;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.ufrn.imd.dominio.Usuario;

import java.util.List;
import java.util.Optional;

@Transactional
@RequestScoped
public class UsuarioJpaDao extends EntidadeJpaDao<Usuario> implements UsuarioDao {

    public UsuarioJpaDao() {
        this.tClass = Usuario.class;
    }

    @Override
    public List<Usuario> todos() {
        return manager.createQuery("SELECT u FROM Usuario u").getResultList();
    }

    @Override
    public Optional<Usuario> buscarPorLogin(String login) {
        Query query = this.manager.createQuery("SELECT p from Usuario p where p.login = :login");
        query.setParameter("login",login);
        return query.setMaxResults(1).getResultList().stream().findFirst();
    }
}
