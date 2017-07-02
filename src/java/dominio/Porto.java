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
    private int anoFundacao;

    public Porto(int id, String nome, String administracao, int anoFundacao) {
        this.id = id;
        this.nome = nome;
        this.administracao = administracao;
        this.anoFundacao = anoFundacao;
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

    public int getAnofundacao() {
        return anoFundacao;
    }

    public void setAnofundacao(int anoFundacao) {
        this.anoFundacao = anoFundacao;
    }

}
