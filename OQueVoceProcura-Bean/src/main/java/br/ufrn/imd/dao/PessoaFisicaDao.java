package br.ufrn.imd.dao;

import br.ufrn.imd.dominio.PessoaFisica;

import java.util.Optional;

public interface PessoaFisicaDao extends EntidadeDao<PessoaFisica> {

    PessoaFisica buscarPorCpf(String cpf);
    PessoaFisica buscarPorRg(String rg);
}
