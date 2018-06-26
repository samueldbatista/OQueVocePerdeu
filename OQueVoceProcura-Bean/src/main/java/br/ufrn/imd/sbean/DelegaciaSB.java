package br.ufrn.imd.sbean;

import br.ufrn.imd.dao.DelegaciaDao;
import br.ufrn.imd.dao.EnderecoDao;
import br.ufrn.imd.dao.UsuarioDao;
import br.ufrn.imd.dominio.Delegacia;
import br.ufrn.imd.dominio.Endereco;
import br.ufrn.imd.dominio.Usuario;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Local
@Stateless
public class DelegaciaSB implements DelegaciaSBInterface {
    // teste
    @Inject
    private DelegaciaDao delegaciaDao;

    @Inject
    private EnderecoDao enderecoDao;

    @Override
    public Delegacia salvar(Delegacia delegacia) {
        Endereco endereco = delegacia.getEndereco();

        if (endereco != null) {
            enderecoDao.salvar(endereco);
        }
        Delegacia delegacia1 = delegaciaDao.salvar(delegacia);

        return delegacia1;
    }

    @Override
    public Delegacia editar(Long id) {
        Delegacia delegacia = delegaciaDao.buscarPorId(id);
        return delegacia;
    }

    @Override
    public List<Delegacia> listar() {
        return delegaciaDao.todos();
    }

    @Override
    public void remover(Long id) {
        Delegacia delegacia = delegaciaDao.buscarPorId(id);
        delegaciaDao.remover(delegacia);
    }
}
