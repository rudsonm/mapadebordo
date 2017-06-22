/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author julio
 */
public class Conexao {
    private final String url = "jdbc:postgresql://localhost:5432/";
    private final String dataBase = "mapa_de_bordo";
    private final String usuario = "postgres";
    private final String senha = "123456";
    private Connection conexao = null;
    private Statement statement = null;
    
    public Conexao() throws Exception {
        Class.forName("org.postgresql.Driver");
        conexao = DriverManager.getConnection(url+dataBase, usuario, senha); 
        ModelBuilder mb = new ModelBuilder(conexao.createStatement());
        mb.especieBuilder();
        mb.embarcacaoBuilder();
        mb.fotografiaBuilder();
        mb.lanceBuilder();
        mb.portoBuilder();
        mb.viagemBuilder();
        mb.capturaBuilder();
        mb.altersBuilder();
        mb.closeStatement();
    }
    
    public void fechar() throws SQLException {
        conexao.close();
    }
    
    public Connection getConexao() throws SQLException {
        return conexao;
    }
    
    public Statement getStatement() throws SQLException {
        if(statement == null)
            statement = conexao.createStatement();
        return statement;
    }
    
    public void closeStatement() throws SQLException {
        if(statement != null) {
            statement.close();
            statement = null;
        }
    }
}
