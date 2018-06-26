package br.ufrn.imd.dominio;

import br.ufrn.imd.util.OpcaoSelect;
import br.ufrn.imd.util.SelectOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public enum InformacaoPessoal implements SelectOptions{

    RG(1,"RG"), CPF(2,"CPF"), CNPJ(3, "CNPJ"),NUMERO_BO(4,"Nº BO");

    private int id;
    private String chave;

    InformacaoPessoal(int id, String chave) {
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
        for (InformacaoPessoal info: InformacaoPessoal.values()) {
            options.put(info.getId(),info.getChave());
        }
        return options;
    }

    public static List<OpcaoSelect> retornarOpcaoSelect(){
        InformacaoPessoal infos[] = InformacaoPessoal.values();
        List<OpcaoSelect> opcoes = new ArrayList<>();
        for(InformacaoPessoal p : infos) {
            OpcaoSelect opcaoSelect = new OpcaoSelect();
            opcaoSelect.setId(p.getId());
            opcaoSelect.setChave(p.getChave());
            opcaoSelect.setValor(p.getValor());
            opcoes.add(opcaoSelect);
        }
        return opcoes;
    }

}
