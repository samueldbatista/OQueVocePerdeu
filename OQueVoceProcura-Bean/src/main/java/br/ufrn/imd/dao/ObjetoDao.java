package br.ufrn.imd.dao;

import br.ufrn.imd.dominio.Objeto;

import java.util.List;

public interface ObjetoDao extends EntidadeDao<Objeto>{

    public List buscar(String identificador);
}
