package br.ufrn.imd.dao;

import br.ufrn.imd.dominio.Delegacia;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;

@Transactional
@RequestScoped
public class DelegaciaJpaDao extends EntidadeJpaDao<Delegacia> implements DelegaciaDao {

    public DelegaciaJpaDao() {
        this.tClass = Delegacia.class;
    }
}
