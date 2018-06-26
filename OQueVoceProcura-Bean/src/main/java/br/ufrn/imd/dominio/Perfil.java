package br.ufrn.imd.dominio;

import br.ufrn.imd.util.OpcaoSelect;
import br.ufrn.imd.util.SelectOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public enum Perfil implements SelectOptions{

    ADMINISTRADOR(1,"Administrador"), CONSULTA(2,"Consulta"), CLIENTE(3, "Cliente");

    private int id;
    private String chave;

    Perfil(int id, String chave) {
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
        for (Perfil perfil: Perfil.values()) {
            options.put(perfil.getId(),perfil.getChave());
        }
        return options;
    }

    public static List<OpcaoSelect> retornarOpcaoSelect(){
        Perfil perfis[] = Perfil.values();
        List<OpcaoSelect> opcoes = new ArrayList<>();
        for(Perfil p : perfis) {
            OpcaoSelect opcaoSelect = new OpcaoSelect();
            opcaoSelect.setId(p.getId());
            opcaoSelect.setChave(p.getChave());
            opcaoSelect.setValor(p.getValor());
            opcoes.add(opcaoSelect);
        }
        return opcoes;
    }

}
