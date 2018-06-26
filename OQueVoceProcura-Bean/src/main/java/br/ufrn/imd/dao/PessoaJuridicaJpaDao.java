package br.ufrn.imd.dao;

import br.ufrn.imd.dominio.PessoaJuridica;

public class PessoaJuridicaJpaDao extends EntidadeJpaDao<PessoaJuridica> implements PessoaJuridicaDao {

    public PessoaJuridicaJpaDao(){
        this.tClass = PessoaJuridica.class;
    }

    @Override
    public PessoaJuridica buscarPorCnpj(String cnpj) {
        return (PessoaJuridica) manager.createQuery("SELECT t FROM PessoaJuridica t WHERE t.cnpj = :cnpj" +
                "").setParameter("cnpj",cnpj).getSingleResult();
    }

}
