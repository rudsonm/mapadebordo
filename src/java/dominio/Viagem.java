/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;
import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author julio
 */
public class Viagem implements Serializable {
 
    private int id;
    private Date dataSaida;
    private Date dataChegada;
    private Porto origem;
    private Porto destino;
    private Embarcacao embarcacao;
    private List<Lance> lances;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Date getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(Date dataChegada) {
        this.dataChegada = dataChegada;
    }

    public Porto getOrigem() {
        return origem;
    }

    public void setOrigem(Porto origem) {
        this.origem = origem;
    }

    public Porto getDestino() {
        return destino;
    }

    public void setDestino(Porto destino) {
        this.destino = destino;
    }

    public Embarcacao getEmbarcacao() {
        return embarcacao;
    }

    public void setEmbarcacao(Embarcacao embarcacao) {
        this.embarcacao = embarcacao;
    }

    public Collection<Lance> getLances() {
        return lances;
    }

    public void setLances(List<Lance> lances) {
        this.lances = lances;
    }
    
    
}
