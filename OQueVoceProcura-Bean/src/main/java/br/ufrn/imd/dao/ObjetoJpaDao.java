package br.ufrn.imd.dao;

import br.ufrn.imd.dominio.Objeto;

import javax.enterprise.context.RequestScoped;
import javax.management.Query;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@RequestScoped
public class ObjetoJpaDao extends EntidadeJpaDao<Objeto> implements ObjetoDao{

    public ObjetoJpaDao(){
        this.tClass = Objeto.class;
    }

    @Override
    public List<Objeto> buscar(String identificador) {
        return manager.createQuery("SELECT t FROM Objeto t WHERE t.identificador = :identificador" +
                "").setParameter("identificador",identificador).getResultList();
    }

}
