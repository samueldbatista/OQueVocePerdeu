package br.ufrn.imd.sbean;

import br.ufrn.imd.dominio.InformacaoPessoal;
import br.ufrn.imd.dominio.Objeto;
import br.ufrn.imd.dominio.TipoBusca;

import java.util.List;

public interface ObjetoSBInterface {

    Objeto salvar(Objeto objeto);
    List<Objeto> listar();
    void remover(Long id);
    Objeto editar(Long id);
    List<Objeto> pesquisarPorTipo(TipoBusca tipoBusca, InformacaoPessoal informacaoPessoal, String identificador);
}
