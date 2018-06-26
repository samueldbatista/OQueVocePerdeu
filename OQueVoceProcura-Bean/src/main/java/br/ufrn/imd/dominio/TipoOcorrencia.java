package br.ufrn.imd.dominio;

public enum TipoOcorrencia {
    ROUBO(1,"Objeto roubado"),FURTO(2,"Objeto furtado"),PERDA(3,"Objeto perdido");

    private int id;
    private String chave;

    TipoOcorrencia(int id,String chave) {
        this.id = id;
        this.chave = chave;
    }
}
