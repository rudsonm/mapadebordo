/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dominio.Especie;
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
public class EspecieDAO implements IDataAccessObject<Especie> {
    
    private Conexao conexao;
    
    public EspecieDAO() {
        
    }
    
    public EspecieDAO(Conexao conexao) {
        this.conexao = conexao;
    }
    
    @Override
    public void create(Especie especie) throws Exception {
        String query = "INSERT INTO especie (nome, profundidade_minima, profundidade_maxima) VALUES (?,?,?)";
        Conexao conexao = new Conexao();
        PreparedStatement preparedStatement = conexao.getConexao().prepareStatement(query);
        preparedStatement.setString(1, especie.getNome());
        preparedStatement.setFloat(2, especie.getProfundidadeMinima());
        preparedStatement.setFloat(3, especie.getProfundidadeMaxima());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        conexao.close();
    }

    @Override
    public void remove(int id) throws Exception {
        String query = "DELETE FROM especie WHERE id = ?";
        Conexao conexao = new Conexao();
        PreparedStatement preparedStatement = conexao.getConexao().prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        conexao.close();
    }

    @Override
    public List<Especie> getAll() throws Exception {
        Conexao conexao = new Conexao();
        List<Especie> especies = new ArrayList<>();
        String query = "SELECT * FROM especie";
        ResultSet result = conexao.getStatement().executeQuery(query);
        while(result.next()) {
            Especie especie = new Especie();
            especie.setId(result.getInt("id"));
            especie.setNome(result.getString("nome"));
            especie.setProfundidadeMinima(result.getFloat("profundidade_minima"));
            especie.setProfundidadeMaxima(result.getFloat("profundidade_maxima"));
            especies.add(especie);
        }
        conexao.close();
        return especies;
    }

    @Override
    public Especie getOne(int id) throws Exception {
        Statement statement = conexao.getConexao().createStatement();
        String sql = "select * from especie where id = "+id;
        ResultSet result = statement.executeQuery(sql);
        
        Especie especie = new Especie();
        result.next();
        
        especie.setId(result.getInt("id"));
        especie.setProfundidadeMaxima(result.getFloat("profundidade_maxima"));
        especie.setProfundidadeMinima(result.getFloat("profundidade_minima"));
        statement.close();
        
        return especie;
    }
    
}
