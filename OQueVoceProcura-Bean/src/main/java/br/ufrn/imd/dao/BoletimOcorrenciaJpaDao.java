package br.ufrn.imd.dao;

import br.ufrn.imd.dominio.BoletimOcorrencia;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@RequestScoped
public class BoletimOcorrenciaJpaDao extends EntidadeJpaDao<BoletimOcorrencia> implements BoletimOcorrenciaDao {

    public BoletimOcorrenciaJpaDao() {
        this.tClass = BoletimOcorrencia.class;
    }

    @Override
    public List<BoletimOcorrencia> buscarPorPessoaFisicaRg(String rg) {
        return manager.createQuery("SELECT t FROM BoletimOcorrencia t JOIN PessoaFisica p ON t.vitima.id = p.id WHERE p.rg = :rg" +
                "").setParameter("rg",rg).getResultList();
    }

    @Override
    public List<BoletimOcorrencia> buscarPorPessoaFisicaCpf(String cpf) {
        return manager.createQuery("SELECT t FROM BoletimOcorrencia t JOIN PessoaFisica p ON t.vitima.id = p.id WHERE p.cpf = :cpf" +
                "").setParameter("cpf",cpf).getResultList();
    }

    @Override
    public List<BoletimOcorrencia> buscarPorPessoaJuridicaCnpj(String cnpj) {
        return manager.createQuery("SELECT t FROM BoletimOcorrencia t JOIN PessoaJuridica p ON t.vitima.id = p.id WHERE p.cnpj = :cnpj" +
                "").setParameter("cnpj",cnpj).getResultList();
    }

    @Override
    public List<BoletimOcorrencia> buscarPorNBo(String numeroBo) {
        return manager.createQuery("SELECT t FROM BoletimOcorrencia t WHERE t.numeroBo = :numeroBo" +
                "").setParameter("numeroBo",numeroBo).getResultList();
    }
}
