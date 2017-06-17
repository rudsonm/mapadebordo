/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author rudson
 */
public class Especie {
    private int id;
    private String nome;
    private float profundidadeMinima;
    private float profundidadeMaxima;

    public Especie(int id, String nome, float profundidadeMinima, float profundidadeMaxima) {
        this.id = id;
        this.nome = nome;
        this.profundidadeMinima = profundidadeMinima;
        this.profundidadeMaxima = profundidadeMaxima;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getProfundidadeMinima() {
        return profundidadeMinima;
    }

    public void setProfundidadeMinima(float profundidadeMinima) {
        this.profundidadeMinima = profundidadeMinima;
    }

    public float getProfundidadeMaxima() {
        return profundidadeMaxima;
    }

    public void setProfundidadeMaxima(float profundidadeMaxima) {
        this.profundidadeMaxima = profundidadeMaxima;
    }
    
}
