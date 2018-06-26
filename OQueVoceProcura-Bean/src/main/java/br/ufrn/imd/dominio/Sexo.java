package br.ufrn.imd.dominio;

public enum Sexo {
    MASCULINO(1, "Masculino"),FEMININO(2,"Feminino");

    private int id;
    private String chave;

    Sexo(int id,String chave) {
        this.id = id;
        this.chave = chave;
    }
}
