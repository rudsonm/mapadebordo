/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author julio
 */
public class Embarcacao {
    
    private int id;
    private String nome;
    private double comprimento;

    public Embarcacao(int id, String nome, double comprimento) {
        this.id = id;
        this.nome = nome;
        this.comprimento = comprimento;
    }
    
    public Embarcacao() {
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

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }
    
    
    
}
