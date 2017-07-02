/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.List;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author julio
 */
public class Lance {
    private int id;
    private Viagem viagem;
    private DateTime dataInicio;
    private DateTime dataTermino;
    private float comprimentoRede;
    private float alturaRede;
    private float tamanhoMalha;
    private float profundidade;
    private int latitude;
    private int longitude;
    private List<Captura> capturas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Viagem getViagem() {
        return viagem;
    }

    public void setViagem(Viagem viagem) {
        this.viagem = viagem;
    }

    public DateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(DateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public DateTime getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(DateTime dataTermino) {
        this.dataTermino = dataTermino;
    }

    public float getComprimentoRede() {
        return comprimentoRede;
    }

    public void setComprimentoRede(float comprimentoRede) {
        this.comprimentoRede = comprimentoRede;
    }

    public float getAlturaRede() {
        return alturaRede;
    }

    public void setAlturaRede(float alturaRede) {
        this.alturaRede = alturaRede;
    }

    public float getTamanhoMalha() {
        return tamanhoMalha;
    }

    public void setTamanhoMalha(float tamanhoMalha) {
        this.tamanhoMalha = tamanhoMalha;
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

    public List<Captura> getCapturas() {
        return capturas;
    }

    public void setCapturas(List<Captura> capturas) {
        this.capturas = capturas;
    }
    
    
}
