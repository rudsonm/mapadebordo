/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dominio.Porto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rudson
 */
public class PortoDAO implements IDataAccessObject<Porto> {
    
    private Conexao conexao;
    
    public PortoDAO() {
        
    }
    
    public PortoDAO(Conexao conexao) {
        this.conexao = conexao;
    }
    
    
    @Override
    public void create(Porto porto) throws Exception {
        String query = "INSERT INTO porto (nome, administracao, ano_fundacao) VALUES (?,CAST(? AS tipo_administracao),?)";
        Conexao conexao = new Conexao();
        PreparedStatement preparedStatement = conexao.getConexao().prepareStatement(query);
        preparedStatement.setString(1, porto.getNome());
        preparedStatement.setString(2, porto.getAdministracao());
        preparedStatement.setInt(3, porto.getAnoFundacao());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        conexao.close();
    }

    @Override
    public void remove(int id) throws Exception {
        String query = "DELETE FROM porto WHERE id = ?";
        Conexao conexao = new Conexao();
        PreparedStatement preparedStatement = conexao.getConexao().prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        conexao.close();
    }

    @Override
    public List<Porto> getAll() throws Exception {
        Conexao conexao = new Conexao();
        List<Porto> portos = new ArrayList<>();
        String query = "SELECT * FROM porto";
        ResultSet result = conexao.getStatement().executeQuery(query);
        while(result.next()) {
            Porto porto = new Porto();
            porto.setId(result.getInt("id"));
            porto.setNome(result.getString("nome"));
            porto.setAdministracao(result.getString("administracao"));
            porto.setAnoFundacao(result.getInt("ano_fundacao"));
            portos.add(porto);
        }
        conexao.close();
        return portos;
    }

    @Override
    public Porto getOne(int id) throws Exception {
        Statement statement = conexao.getConexao().createStatement();
        String sql = "select * from porto where id = "+id;
        ResultSet result = statement.executeQuery(sql);
        
        Porto porto = new Porto();
        result.next();
        
        porto.setId(result.getInt("id"));
        porto.setNome(result.getString("nome"));
        porto.setAdministracao(result.getString("administracao"));
        porto.setAnoFundacao(result.getInt("ano_fundacao"));
        statement.close();
        
        return porto;
    }
    
}
