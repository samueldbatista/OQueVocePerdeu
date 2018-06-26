package br.ufrn.imd.sbean;

import br.ufrn.imd.dominio.Delegacia;

import java.util.List;

public interface DelegaciaSBInterface {

    Delegacia salvar(Delegacia delegacia);
    List<Delegacia> listar();
    void remover(Long id);
    Delegacia editar(Long id);
}
