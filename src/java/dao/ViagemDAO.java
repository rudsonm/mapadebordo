/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dominio.Embarcacao;
import dominio.Lance;
import dominio.Porto;
import dominio.Viagem;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author rudson
 */
public class ViagemDAO implements IDataAccessObject<Viagem> {

    @Override
    public void create(Viagem viagem) throws Exception {
        Conexao conexao = new Conexao();
        Statement statement = conexao.getConexao().createStatement();
        statement.execute("BEGIN");
        String query = "INSERT INTO viagem (data_saida, data_chegada, porto_origem_id, porto_destino_id, embarcacao_id) VALUES (?,?,?,?,?) RETURNING id";
        PreparedStatement preparedStatement = conexao.getConexao().prepareStatement(query);
        preparedStatement.setDate(1, (Date) viagem.getDataSaida());
        preparedStatement.setDate(2, (Date) viagem.getDataChegada());
        preparedStatement.setInt(3, viagem.getOrigem().getId());
        preparedStatement.setInt(4, viagem.getDestino().getId());
        preparedStatement.setInt(5, viagem.getEmbarcacao().getId());
        try {
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            viagem.setId(result.getInt("id"));
            LanceDAO lanceDAO = new LanceDAO(conexao);
            for (Lance lance : viagem.getLances()) {
                lance.setViagem(viagem);            
                lanceDAO.create(lance);
            }
            statement.execute("COMMIT");
        } catch (SQLException e) {
            statement.execute("ROLLBACK");
        }        
        statement.close();
        preparedStatement.close();
        conexao.close();
    }

    @Override
    public void remove(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Viagem> getAll() throws Exception {
        Conexao conexao = new Conexao();
        Statement statement = conexao.getConexao().createStatement();
        String sql = "select * from viagem";
        ResultSet result = statement.executeQuery(sql);
        
        List<Viagem> viagens = new ArrayList<>();
        while ( result.next() ){
            Viagem viagem = new Viagem();
            viagem.setId(result.getInt("id"));
            viagem.setDataChegada(result.getDate("data_saida"));
            viagem.setDataSaida(result.getDate("data_chegada"));

            PortoDAO portoDAO = new PortoDAO(conexao);
            Porto porto = portoDAO.getOne(result.getInt("porto_origem_id"));
            viagem.setOrigem(porto);

            porto = portoDAO.getOne(result.getInt("porto_destino_id"));
            viagem.setDestino(porto);

            EmbarcacaoDAO embarcacaoDAO = new EmbarcacaoDAO(conexao);
            Embarcacao embarcacao = embarcacaoDAO.getOne(result.getInt("embarcadao_id"));
            viagem.setEmbarcacao(embarcacao);

            viagens.add(viagem);
        }
        statement.close();
        conexao.close();
        return viagens;
        
    }

    @Override
    public Viagem getOne(int id) throws Exception {
        Conexao conexao = new Conexao();
        Statement statement = conexao.getConexao().createStatement();
        String sql = "select * from viagem where id = "+id;
        ResultSet result = statement.executeQuery(sql);
        
        Viagem viagem = new Viagem();
        
        result.next();
         
        viagem.setId(result.getInt("id"));
        viagem.setDataChegada(result.getDate("data_saida"));
        viagem.setDataSaida(result.getDate("data_chegada"));
        
        PortoDAO portoDAO = new PortoDAO(conexao);
        Porto porto = portoDAO.getOne(result.getInt("porto_origem_id"));
        viagem.setOrigem(porto);
        
        porto = portoDAO.getOne(result.getInt("porto_destino_id"));
        viagem.setDestino(porto);
        
        EmbarcacaoDAO embarcacaoDAO = new EmbarcacaoDAO(conexao);
        Embarcacao embarcacao = embarcacaoDAO.getOne(result.getInt("embarcadao_id"));
        viagem.setEmbarcacao(embarcacao);
        
        LanceDAO lanceDAO = new LanceDAO(conexao);
        List<Lance> lances = lanceDAO.getByViagem(viagem.getId());
        viagem.setLances(lances);
        
        System.out.println(viagem.getLances().size());
        
        statement.close();
        conexao.close();
        
        return viagem;
        
    }
}
