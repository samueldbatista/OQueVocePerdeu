package br.ufrn.imd.util;

import br.ufrn.imd.dominio.Perfil;

import java.util.ArrayList;
import java.util.List;

public class OpcaoSelect {

    private int id;
    private String chave;
    private String valor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
