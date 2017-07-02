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
public class Lance {
    private int id;
    private int viagem;
    private Date data_inicio;
    private Date data_fim;
    private float comprimento_rede;
    private float altura_rede;
    private float tamanho_malha;
    private float profundidade;
    private int latitude;
    private int longitude;
    private ArrayList<Captura> captura;

    public Lance(int id, int viagem, Date data_inicio, Date data_fim, float comprimento_rede, float altura_rede, float tamanho_malha, float profundidade, int latitude, int longitude, ArrayList<Captura> captura) {
        this.id = id;
        this.viagem = viagem;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.comprimento_rede = comprimento_rede;
        this.altura_rede = altura_rede;
        this.tamanho_malha = tamanho_malha;
        this.profundidade = profundidade;
        this.latitude = latitude;
        this.longitude = longitude;
        this.captura = captura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getViagem() {
        return viagem;
    }

    public void setViagem(int viagem) {
        this.viagem = viagem;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_fim() {
        return data_fim;
    }

    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }

    public float getComprimento_rede() {
        return comprimento_rede;
    }

    public void setComprimento_rede(float comprimento_rede) {
        this.comprimento_rede = comprimento_rede;
    }

    public float getAltura_rede() {
        return altura_rede;
    }

    public void setAltura_rede(float altura_rede) {
        this.altura_rede = altura_rede;
    }

    public float getTamanho_malha() {
        return tamanho_malha;
    }

    public void setTamanho_malha(float tamanho_malha) {
        this.tamanho_malha = tamanho_malha;
    }

    public float getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(float profundidade) {
        this.profundidade = profundidade;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public ArrayList<Captura> getCaptura() {
        return captura;
    }

    public void setCaptura(ArrayList<Captura> captura) {
        this.captura = captura;
    } 
       
}
