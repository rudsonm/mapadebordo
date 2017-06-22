/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author julio
 */
public class Conexao {
    private final String url = "jdbc:postgresql://localhost:5432/";
    private final String dataBase = "postgres";
    private final String usuario = "postgres";
    private final String senha = "123456";
    private Connection conexao = null;
    
    public Conexao() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
    }
    
    public void abrir() throws SQLException {
        if(conexao == null)
            conexao = DriverManager.getConnection(url+dataBase, usuario, senha); 
    }
    
    public void fechar() throws SQLException {
        conexao.close();
    }
    
    public Connection getConexao() throws SQLException {
        if(conexao.equals(null))
            abrir();
        return conexao;
    }
}
