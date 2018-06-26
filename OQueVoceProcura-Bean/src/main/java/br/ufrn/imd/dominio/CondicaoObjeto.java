package br.ufrn.imd.dominio;

import br.ufrn.imd.util.OpcaoSelect;
import br.ufrn.imd.util.SelectOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public enum CondicaoObjeto implements SelectOptions {

    OK(1,"Ok"), ARRANHADO(2,"Arranhado"), QUEBRADO(3,"Quebrado");

    private int id;
    private String chave;

    CondicaoObjeto(int id, String chave) {
        this.id = id;
        this.chave = chave;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
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
        for (CondicaoObjeto condicaoObjeto: CondicaoObjeto.values()) {
            options.put(condicaoObjeto.getId(),condicaoObjeto.getChave());
        }
        return options;
    }

    public static List<OpcaoSelect> retornarOpcaoSelect(){
        CondicaoObjeto condicaoObjetos[] = CondicaoObjeto.values();
        List<OpcaoSelect> opcoes = new ArrayList<>();
        for(CondicaoObjeto so : condicaoObjetos) {
            OpcaoSelect opcaoSelect = new OpcaoSelect();
            opcaoSelect.setId(so.getId());
            opcaoSelect.setChave(so.getChave());
            opcaoSelect.setValor(so.getValor());
            opcoes.add(opcaoSelect);
        }
        return opcoes;
    }
}
