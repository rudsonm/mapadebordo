/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dominio.Lance;
import dominio.Viagem;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author rudson
 */
public class ViagemDAO implements IDataAccessObject<Viagem> {

    @Override
    public void create(Viagem viagem) throws Exception {
        Conexao conexao = new Conexao();
        String query = "INSERT INTO viagem (data_saida, data_chegada, porto_origem_id, porto_destino_id, embarcacao_id) VALUES (?,?,?,?,?) RETURNING id";
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
    
}
