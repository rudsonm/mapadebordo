/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dominio.Embarcacao;
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
public class EmbarcacaoDAO implements IDataAccessObject<Embarcacao> {
    
    @Override
    public void create(Embarcacao embarcacao) throws Exception {
        String query = "INSERT INTO embarcacao (nome, tamanho) VALUES (?,?)";
        Conexao conexao = new Conexao();
        PreparedStatement preparedStatement = conexao.getConexao().prepareStatement(query);
        preparedStatement.setString(1, embarcacao.getNome());
        preparedStatement.setDouble(2, embarcacao.getComprimento());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        conexao.close();
    }

    @Override
    public void remove(int id) throws Exception {
        String query = "DELETE FROM embarcacao WHERE id = ?";
        Conexao conexao = new Conexao();
        PreparedStatement preparedStatement = conexao.getConexao().prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        conexao.close();
    }

    @Override
    public List<Embarcacao> getAll() throws Exception {
        Conexao conexao = new Conexao();
        List<Embarcacao> especies = new ArrayList<>();
        String query = "SELECT * FROM embarcacao";
        ResultSet result = conexao.getStatement().executeQuery(query);
        while(result.next()) {
            Embarcacao embarcacao = new Embarcacao();
            embarcacao.setId(result.getInt("id"));
            embarcacao.setNome(result.getString("nome"));
            embarcacao.setComprimento(result.getDouble("tamanho"));
            especies.add(embarcacao);
        }
        conexao.close();
        return especies;
    }
    
}
