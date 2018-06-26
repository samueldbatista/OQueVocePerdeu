package br.ufrn.imd.dominio;

import br.ufrn.imd.util.OpcaoSelect;
import br.ufrn.imd.util.SelectOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public enum TipoBusca implements SelectOptions {

    INFORMACAO_PESSOAL(1,"Informações pessoais"), INFORMACAO_OBJETO(2,"Informações do objeto");

    private int id;
    private String chave;

    TipoBusca(int id, String chave) {
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
        for (TipoBusca tipoBusca: TipoBusca.values()) {
            options.put(tipoBusca.getId(),tipoBusca.getChave());
        }
        return options;
    }

    public static List<OpcaoSelect> retornarOpcaoSelect(){
        TipoBusca tipo[] = TipoBusca.values();
        List<OpcaoSelect> opcoes = new ArrayList<>();
        for(TipoBusca p : tipo) {
            OpcaoSelect opcaoSelect = new OpcaoSelect();
            opcaoSelect.setId(p.getId());
            opcaoSelect.setChave(p.getChave());
            opcaoSelect.setValor(p.getValor());
            opcoes.add(opcaoSelect);
        }
        return opcoes;
    }

}
