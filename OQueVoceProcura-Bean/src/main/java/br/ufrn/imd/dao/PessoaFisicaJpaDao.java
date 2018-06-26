package br.ufrn.imd.dao;

import br.ufrn.imd.dominio.PessoaFisica;

import java.util.Optional;

public class PessoaFisicaJpaDao extends EntidadeJpaDao<PessoaFisica> implements PessoaFisicaDao {

    public PessoaFisicaJpaDao() {
        this.tClass = PessoaFisica.class;
    }

    @Override
    public PessoaFisica buscarPorCpf(String cpf) {
        return (PessoaFisica) manager.createQuery("SELECT t FROM PessoaFisica t WHERE t.cpf = :cpf" +
                "").setParameter("cpf",cpf).getSingleResult();
    }

    @Override
    public PessoaFisica buscarPorRg(String rg) {
        return (PessoaFisica) manager.createQuery("SELECT t FROM PessoaFisica t WHERE t.rg = :rg" +
                "").setParameter("rg",rg).getSingleResult();
    }
}
