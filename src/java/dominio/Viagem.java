/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;
import java.util.*;

/**
 *
 * @author julio
 */
public class Viagem {
 
    private int id;
    private Date data_saida;
    private Date data_chegada;
    private int porto_origem;
    private int porto_chegada;
    private int embarcacao;
    private ArrayList<Lance> lance;

    public Viagem(int id, Date data_saida, Date data_chegada, int porto_origem, int porto_chegada, int embarcacao, ArrayList<Lance> lance) {
        this.id = id;
        this.data_saida = data_saida;
        this.data_chegada = data_chegada;
        this.porto_origem = porto_origem;
        this.porto_chegada = porto_chegada;
        this.embarcacao = embarcacao;
        this.lance = lance;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData_saida() {
        return data_saida;
    }

    public void setData_saida(Date data_saida) {
        this.data_saida = data_saida;
    }

    public Date getData_chegada() {
        return data_chegada;
    }

    public void setData_chegada(Date data_chegada) {
        this.data_chegada = data_chegada;
    }

    public int getPorto_origem() {
        return porto_origem;
    }

    public void setPorto_origem(int porto_origem) {
        this.porto_origem = porto_origem;
    }

    public int getPorto_chegada() {
        return porto_chegada;
    }

    public void setPorto_chegada(int porto_chegada) {
        this.porto_chegada = porto_chegada;
    }

    public int getEmbarcacao() {
        return embarcacao;
    }

    public void setEmbarcacao(int embarcacao) {
        this.embarcacao = embarcacao;
    }

    public ArrayList<Lance> getLance() {
        return lance;
    }

    public void setLance(ArrayList<Lance> lance) {
        this.lance = lance;
    }
       
}
