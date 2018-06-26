package br.ufrn.imd.dao;

import br.ufrn.imd.dominio.Endereco;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;

@Transactional
@RequestScoped
public class EnderecoJpaDao extends EntidadeJpaDao<Endereco> implements EnderecoDao {

    public EnderecoJpaDao() { this.tClass = Endereco.class; }
}
