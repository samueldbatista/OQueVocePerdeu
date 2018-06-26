package br.ufrn.imd.sbean;

import br.ufrn.imd.dao.BoletimOcorrenciaDao;
import br.ufrn.imd.dao.ObjetoDao;
import br.ufrn.imd.dominio.BoletimOcorrencia;
import br.ufrn.imd.dominio.InformacaoPessoal;
import br.ufrn.imd.dominio.Objeto;
import br.ufrn.imd.dominio.TipoBusca;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Local
@Stateless
public class ObjetoSB implements ObjetoSBInterface {

    @Inject
    private ObjetoDao objetoDao;

    @Inject
    private BoletimOcorrenciaDao boletimOcorrenciaDao;

    @Override
    public Objeto salvar(Objeto objeto) {
        Objeto obj = objetoDao.salvar(objeto);
        return obj;
    }

    @Override
    public Objeto editar(Long id) {
        Objeto obj = objetoDao.buscarPorId(id);
        return obj;
    }

    @Override
    public List<Objeto> listar() {
        return objetoDao.todos();
    }

    @Override
    public void remover(Long id) {
        Objeto objeto = objetoDao.buscarPorId(id);
        objetoDao.remover(objeto);
    }

    @Override
    public List<Objeto> pesquisarPorTipo(TipoBusca tipoBusca, InformacaoPessoal informacaoPessoal, String identificador) {
        List<Objeto> objetos = new ArrayList<>();
        if(tipoBusca.equals(TipoBusca.INFORMACAO_OBJETO)) {
            objetos = objetoDao.buscar(identificador);
        } else {
            List<BoletimOcorrencia> bos = new ArrayList<>();
            if(informacaoPessoal.equals(InformacaoPessoal.RG)){
                bos = boletimOcorrenciaDao.buscarPorPessoaFisicaRg(identificador);
                incrementarObjetos(bos,objetos);
            }
            else if(informacaoPessoal.equals(InformacaoPessoal.CNPJ)){
                bos = boletimOcorrenciaDao.buscarPorPessoaJuridicaCnpj(identificador);
                incrementarObjetos(bos,objetos);
            }
            else if(informacaoPessoal.equals(InformacaoPessoal.CPF)){
                bos = boletimOcorrenciaDao.buscarPorPessoaFisicaCpf(identificador);
                incrementarObjetos(bos,objetos);
            }
            else if(informacaoPessoal.equals(InformacaoPessoal.NUMERO_BO)){
                bos = boletimOcorrenciaDao.buscarPorNBo(identificador);
                incrementarObjetos(bos,objetos);
            }
        }
        return objetos;
    }

    private void incrementarObjetos(List<BoletimOcorrencia> bos, List<Objeto> objetos){
        if(bos != null) {
            if(!bos.isEmpty()) {
                for (BoletimOcorrencia bo : bos) {
                    objetos.addAll(bo.getObjetos());
                }
            }
        }
    }
}
