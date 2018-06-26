package br.ufrn.imd.web.mbean;

import br.ufrn.imd.dominio.*;
import br.ufrn.imd.sbean.ObjetoSBInterface;
import br.ufrn.imd.util.OpcaoSelect;
import org.apache.commons.codec.binary.Base64;


import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SessionScoped
@Named
public class ObjetoMB implements Serializable {

    @EJB
    private ObjetoSBInterface objetoSB;


    private String identificador;
    private Part imagem;
    private List<Foto> fotos = new ArrayList<>();
    private Objeto objeto = new Objeto();
    private List<Objeto> objetos = new ArrayList<>();
    private TipoBusca tipoBusca = TipoBusca.INFORMACAO_OBJETO;
    private InformacaoPessoal info = InformacaoPessoal.RG;

    public void pesquisar() {
        this.objetos = this.objetoSB.pesquisarPorTipo(tipoBusca,info,identificador);
    }

    public void salvar() throws IOException{
        if(!fotos.isEmpty()) {
            objeto.setFotos(fotos);
        }
        objetoSB.salvar(this.objeto);
        objeto = new Objeto();
        fotos =  new ArrayList<>();
    }

    public List<Objeto> listar() { return objetoSB.listar(); }

    public void editar(Long id) { this.objetoSB.editar(id); }

    public void adicionarImagem() throws IOException{
        String formato = imagem.getContentType();
        String nome = imagem.getName();
        byte[] imageAsByte = new byte[(int) imagem.getSize()];
        imagem.getInputStream().read(imageAsByte);
        Foto ib4 = new Foto();
        String base64AsString = new String(Base64.encodeBase64String(imageAsByte));
        ib4.setB64(base64AsString);
        ib4.setFormato(formato);
        ib4.setNome(nome);
        fotos.add(ib4);
    }

    public void modificarSelect(){
        if(tipoBusca.equals(TipoBusca.INFORMACAO_OBJETO)) {

        } else {

        }
    }

    public Objeto getObjeto() {
        return objeto;
    }

    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
    }

    public List<OpcaoSelect> selectStatus(){
        return StatusObjeto.retornarOpcaoSelect();
    }

    public List<OpcaoSelect> selectTipoObjeto(){
        return TipoObjeto.retornarOpcaoSelect();
    }

    public List<OpcaoSelect> selectCondicaoObjeto(){
        return CondicaoObjeto.retornarOpcaoSelect();
    }

    public ObjetoSBInterface getObjetoSB() {
        return objetoSB;
    }

    public void setObjetoSB(ObjetoSBInterface objetoSB) {
        this.objetoSB = objetoSB;
    }

    public Part getImagem() {
        return imagem;
    }

    public void setImagem(Part imagem) {
        this.imagem = imagem;
    }

    public List<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(List<Foto> fotos) {
        this.fotos = fotos;
    }

    public List<Objeto> getObjetos() {
        return objetos;
    }

    public void setObjetos(List<Objeto> objetos) {
        this.objetos = objetos;
    }

    public List<OpcaoSelect> selectInformacoes() {
        return InformacaoPessoal.retornarOpcaoSelect();
    }

    public List<OpcaoSelect> selectTipoBusca(){
        return TipoBusca.retornarOpcaoSelect();
    }

    public TipoBusca getTipoBusca() {
        return tipoBusca;
    }

    public void setTipoBusca(TipoBusca tipoBusca) {
        this.tipoBusca = tipoBusca;
    }

    public InformacaoPessoal getInfo() {
        return info;
    }

    public void setInfo(InformacaoPessoal info) {
        this.info = info;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
}
