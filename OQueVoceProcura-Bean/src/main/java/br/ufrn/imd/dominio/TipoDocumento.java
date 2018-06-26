package br.ufrn.imd.dominio;

import br.ufrn.imd.util.OpcaoSelect;
import br.ufrn.imd.util.SelectOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public enum TipoDocumento implements SelectOptions {

    CPF(1,"CPF"), RG(2,"RG"), CNH(3,"CNH"), CNPJ(5, "CNPJ");

    private int id;
    private String chave;

    TipoDocumento(int id, String chave) {
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
        for (TipoDocumento tipoDocumento: TipoDocumento.values()) {
            options.put(tipoDocumento.getId(),tipoDocumento.getChave());
        }
        return options;
    }

    public static List<OpcaoSelect> retornarOpcaoSelect(){
        TipoDocumento tipoDocumentos[] = TipoDocumento.values();
        List<OpcaoSelect> opcoes = new ArrayList<>();
        for(TipoDocumento td : tipoDocumentos) {
            OpcaoSelect opcaoSelect = new OpcaoSelect();
            opcaoSelect.setId(td.getId());
            opcaoSelect.setChave(td.getChave());
            opcaoSelect.setValor(td.getValor());
            opcoes.add(opcaoSelect);
        }
        return opcoes;
    }
}
