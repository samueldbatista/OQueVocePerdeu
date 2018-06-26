package br.ufrn.imd.dominio;

import br.ufrn.imd.util.OpcaoSelect;
import br.ufrn.imd.util.SelectOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public enum StatusObjeto implements SelectOptions {

    ENCONTRADO(1,"Encontrado"), PERDIDO(2,"Perdido"), DEVOLVIDO(3,"Devolvido");

    private int id;
    private String chave;

    StatusObjeto(int id, String chave) {
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
        for (StatusObjeto statusObjeto: StatusObjeto.values()) {
            options.put(statusObjeto.getId(),statusObjeto.getChave());
        }
        return options;
    }

    public static List<OpcaoSelect> retornarOpcaoSelect(){
        StatusObjeto statusObjetos[] = StatusObjeto.values();
        List<OpcaoSelect> opcoes = new ArrayList<>();
        for(StatusObjeto so : statusObjetos) {
            OpcaoSelect opcaoSelect = new OpcaoSelect();
            opcaoSelect.setId(so.getId());
            opcaoSelect.setChave(so.getChave());
            opcaoSelect.setValor(so.getValor());
            opcoes.add(opcaoSelect);
        }
        return opcoes;
    }
}
