package br.ufrn.imd.dao;

import java.util.Collection;
import java.util.List;

import br.ufrn.imd.dominio.Entidade;

public interface EntidadeDao<T extends Entidade> {

    T buscarPorId(Long id);
    T salvar(T entidade);
    void remover(T entidade);
    List<T> todos();
}