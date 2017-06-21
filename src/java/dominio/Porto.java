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

public class Porto {
    
    private int id;
    private String nome;
    private String administracao;
    private float anofundacao;

public Porto(int id, String nome, String administracao, float anofundacao) {
        this.id = id;
        this.nome = nome;
        this.administracao = administracao;
        this.anofundacao = anofundacao;
    }

     public Porto() {
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

    public String getAdministracao() {
        return administracao;
    }

    public void setAdministracao(String administracao) {
        this.administracao = administracao;
    }

    public float getAnofundacao() {
        return anofundacao;
    }

    public void setAnofundacao(float anofundacao) {
        this.anofundacao = anofundacao;
    }

    

}
