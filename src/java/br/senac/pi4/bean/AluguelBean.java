/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.pi4.bean;

import br.senac.pi4.DAO.Aluguel;
import br.senac.pi4.util.Mensagem;
import java.math.BigDecimal;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

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

    public String escolherGrupo() {
        return "escolherGrupo";
    }

    public String carroSelecionado(String grupo) {
        this.aluguel.setGrupo(grupo);
        return "escolherGrupo.xhtml?faces-redirect=true";
    }

    public String protecao() {
        if (aluguel.getGrupo() == null) {
            // Mensagem de sucesso para usuário
            Flash flash = FacesContext.getCurrentInstance()
                    .getExternalContext().getFlash();
            flash.put("mensagem", new Mensagem("erro", "error"));
            return "escolherGrupo";
        }
        return "protecao";
    }

    public String localData() {
        return "localData";
    }

    public String resumo(int op) {
        double assElev = aluguel.getAssElev() * 15;
        double bbConf = aluguel.getBbConf() * 15;
        double cadBb = aluguel.getCadBB() * 15;
        double gps = aluguel.getQtdGps() * 15;
        this.aluguel.setValorAssElev(new BigDecimal(assElev));
        this.aluguel.setValorBbConf(new BigDecimal(bbConf));
        this.aluguel.setValorCadBB(new BigDecimal(cadBb));
        this.aluguel.setValorGps(new BigDecimal(gps));
        this.aluguel.setValorTotal(new BigDecimal(assElev + bbConf + cadBb + 100 + gps));
        System.err.println(aluguel.getValorTotal());
        if (op == 0) {
            return "protecao.xhtml?faces-redirect=true";
        } else {
            return "resumo";
        }
    }

    public String atulizaCarrinho() {
        this.aluguel.setValorAssElev(new BigDecimal(aluguel.getAssElev() * 15));
        this.aluguel.setValorBbConf(new BigDecimal(aluguel.getBbConf() * 15));
        this.aluguel.setValorCadBB(new BigDecimal(aluguel.getCadBB() * 15));
        return "protecao.xhtml?faces-redirect=true";
    }

    public String novaReserva() {
        aluguel = new Aluguel();
        return "localData";
    }

}
