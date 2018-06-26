package br.ufrn.imd.dao;

import br.ufrn.imd.dominio.PessoaJuridica;

public interface PessoaJuridicaDao extends EntidadeDao<PessoaJuridica> {

    PessoaJuridica buscarPorCnpj(String cnpj);
}
