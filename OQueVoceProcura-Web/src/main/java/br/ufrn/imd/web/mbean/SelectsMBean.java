package br.ufrn.imd.web.mbean;

import br.ufrn.imd.dominio.CondicaoObjeto;
import br.ufrn.imd.dominio.StatusObjeto;
import br.ufrn.imd.dominio.TipoObjeto;
import br.ufrn.imd.util.OpcaoSelect;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class SelectsMBean {

    public List<OpcaoSelect> selectStatus(){
        return StatusObjeto.retornarOpcaoSelect();
    }

    public List<OpcaoSelect> selectTipoObjeto(){
        return TipoObjeto.retornarOpcaoSelect();
    }

    public List<OpcaoSelect> selectCondicaoObjeto(){
        return CondicaoObjeto.retornarOpcaoSelect();
    }
}
