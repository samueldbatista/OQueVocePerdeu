package br.ufrn.imd.dao;

import br.ufrn.imd.dominio.BoletimOcorrencia;

import java.util.List;

public interface BoletimOcorrenciaDao extends EntidadeDao<BoletimOcorrencia>{
    List<BoletimOcorrencia> buscarPorPessoaFisicaRg(String rg);
    List<BoletimOcorrencia> buscarPorPessoaFisicaCpf(String cpf);
    List<BoletimOcorrencia> buscarPorPessoaJuridicaCnpj(String cnpj);
    List<BoletimOcorrencia> buscarPorNBo(String numeroBo);
}
