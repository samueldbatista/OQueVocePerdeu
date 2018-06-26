package br.ufrn.imd.dominio;

import br.ufrn.imd.util.OpcaoSelect;
import br.ufrn.imd.util.SelectOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public enum TipoObjeto implements SelectOptions{

    DOCUMENTO(1,"Documento"),
    ELETRONICO(2,"Eletronico"),
    VEICULO(3,"Veiculo");

    private int id;
    private String chave;

    TipoObjeto(int id, String chave) {
        this.id = id;
        this.chave = chave;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChave() {
        return chave;
    }

    @Override
    public String getValor() {
        return this.toString();
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public static HashMap<Integer, String> todos() {
        HashMap<Integer, String> options =  new HashMap<>();
        for (TipoObjeto tipoObjeto: TipoObjeto.values()) {
            options.put(tipoObjeto.getId(),tipoObjeto.getChave());
        }
        return options;
    }

    public static List<OpcaoSelect> retornarOpcaoSelect(){
        TipoObjeto tipoObjetos[] = TipoObjeto.values();
        List<OpcaoSelect> opcoes = new ArrayList<>();
        for(TipoObjeto so : tipoObjetos) {
            OpcaoSelect opcaoSelect = new OpcaoSelect();
            opcaoSelect.setId(so.getId());
            opcaoSelect.setChave(so.getChave());
            opcaoSelect.setValor(so.getValor());
            opcoes.add(opcaoSelect);
        }
        return opcoes;
    }

}
