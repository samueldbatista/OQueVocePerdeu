package br.ufrn.imd.sbean;

import br.ufrn.imd.dao.ObjetoDao;
import br.ufrn.imd.dominio.Objeto;
import br.ufrn.imd.dominio.TipoDocumento;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Local
@Stateless
public class PesquisarSB implements PesquisarSBInterface{

    @Inject
    private ObjetoDao objetoDao;

    public List pesquisar(String identificador){
        List<Objeto> objetoEncontrado = objetoDao.buscar(identificador);

        return objetoEncontrado;
    }
}
