package br.ufrn.imd.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import br.ufrn.imd.dominio.Entidade;

@Transactional
public abstract class EntidadeJpaDao<T extends Entidade> implements EntidadeDao<T> {
	
	@PersistenceContext(unitName = "EmployeePU")
    protected EntityManager manager;

//    @PersistenceContext(unitName = "PcrnPU")
//    protected EntityManager managerPcrn;

    protected Class<T> tClass;

   

    @Override
    public T buscarPorId(Long id) {
        return manager.find(tClass, id);
    }

    @Override
    public T salvar(T entidade) {
        if(entidade.getId() != null) {
            this.manager.merge(entidade);
        } else {
            this.manager.persist(entidade);
        }
        return entidade;
    }

    @Override
    public void remover(T entidade) {
        manager.remove(entidade);
    }

    @Override
    public List<T> todos() {
        return manager.createQuery("SELECT t FROM "+tClass.getSimpleName()+" t").getResultList();
    }
}
