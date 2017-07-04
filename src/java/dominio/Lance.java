/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author julio
 */
@XmlRootElement
public class Lance implements Serializable {
    private int id;
    private Viagem viagem;
    private DateTime dataInicio;
    private DateTime dataTermino;
    private float comprimentoRede;
    private float alturaRede;
    private float tamanhoMalha;
    private float profundidade;
    private float latitude;
    private float longitude;
    private Collection<Captura> capturas;

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

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public Collection<Captura> getCapturas() {
        return capturas;
    }

    public void setCapturas(Collection<Captura> capturas) {
        this.capturas = capturas;
    }
    
    
}
