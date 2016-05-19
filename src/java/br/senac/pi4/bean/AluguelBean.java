/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi4.bean;

import br.senac.pi4.DAO.Aluguel;
import java.math.BigDecimal;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author bruno.lopes
 */
@ManagedBean
@SessionScoped
public class AluguelBean {
    
    private Aluguel aluguel;
    
    public AluguelBean() {
        aluguel = new Aluguel();
    }

    public Aluguel getAluguel() {
        return aluguel;
    }

    public void setAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
    }
    
    public String escolherGrupo(){
       return "escolherGrupo";
    }
    
    public String carroSelecionado(String grupo)
    {
       this.aluguel.setGrupo(grupo);
       return "escolherGrupo.xhtml?faces-redirect=true";       
    }
    
    public String protecao(){
        return "protecao";
    }
    
    public String localData(){
        return "localData";
    }
    
    public String resumo(){
        return "resumo";
    }
    
    public String atulizaCarrinho(){
        this.aluguel.setValorAssElev(new BigDecimal(aluguel.getAssElev() * 15));
        this.aluguel.setValorBbConf(new BigDecimal(aluguel.getBbConf() * 15));
        this.aluguel.setValorCadBB(new BigDecimal(aluguel.getCadBB() * 15));
        return "protecao";
    }
    
}
