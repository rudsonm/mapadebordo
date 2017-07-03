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
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author rudson
 */
public class ViagemDAO implements IDataAccessObject<Viagem> {

    @Override
    public void create(Viagem viagem) throws Exception {
        Conexao conexao = new Conexao();
        String query = "INSERT INTO viagem (data_saida, data_chegada, porto_origem, porto_destino, embarcacao) VALUES (?,?,?,?,?) RETURNING id";
        PreparedStatement statement = conexao.getConexao().prepareStatement(query);
        statement.setDate(1, (Date) viagem.getDataSaida());
        statement.setDate(2, (Date) viagem.getDataChegada());
        statement.setInt(3, viagem.getOrigem().getId());
        statement.setInt(4, viagem.getDestino().getId());
        statement.setInt(5, viagem.getEmbarcacao().getId());
        ResultSet result = statement.executeQuery();
        result.next();
        viagem.setId(result.getInt("id"));
        LanceDAO lanceDAO = new LanceDAO(conexao);
        for (Lance lance : viagem.getLances()) {
            lance.setViagem(viagem);            
            lanceDAO.create(lance);
        }
        conexao.close();
    }

    @Override
    public void remove(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Viagem> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Viagem getOne(int id) throws Exception {
        Conexao conexao = new Conexao();
        Statement statement = conexao.getConexao().createStatement();
        String sql = "select * from viagem where id = "+id;
        ResultSet result = statement.executeQuery(sql);
        result.next();
        Viagem viagem = new Viagem();
        viagem.setId(result.getInt("id"));
        viagem.setDataChegada(result.getDate("data_saida"));
        viagem.setDataSaida(result.getDate("data_chegada"));
        
        PortoDAO portoDAO = new PortoDAO(conexao);
        Porto porto = portoDAO.getOne(result.getInt("porto_origem_id"));
        viagem.setOrigem(porto);
        
        porto = portoDAO.getOne(result.getInt("porto_destino_id"));
        viagem.setOrigem(porto);
        
        EmbarcacaoDAO embarcacaoDAO = new EmbarcacaoDAO(conexao);
        Embarcacao embarcacao = embarcacaoDAO.getOne(result.getInt("embarcadao_id"));
        viagem.setEmbarcacao(embarcacao);
        
        LanceDAO lanceDAO = new LanceDAO(conexao);
        return viagem;
    }
}
