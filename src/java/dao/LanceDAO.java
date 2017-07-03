/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dominio.Captura;
import dominio.Lance;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author rudson
 */
public class LanceDAO implements IDataAccessObject<Lance> {
    private Conexao conexao;
    
    public LanceDAO() throws Exception {
        conexao = new Conexao();
    }
    
    public LanceDAO(Conexao conexao) {
        this.conexao = conexao;
    }
    
    @Override
    public void create(Lance lance) throws Exception {
        String query = "INSERT INTO lance (viagem, data_inicio, data_termino, comprimento_rede, altura_rede, tamanho_malha, profundidade, latitude, longitude) VALUES (?,?,?,?,?,?,?,?,?) RETURNING id";
        PreparedStatement statement = conexao.getConexao().prepareStatement(query);
        statement.setInt(1, lance.getViagem().getId());
        statement.setTimestamp(2, Timestamp.valueOf(lance.getDataInicio().toString()));
        statement.setTimestamp(3, Timestamp.valueOf(lance.getDataTermino().toString()));
        statement.setFloat(4, lance.getComprimentoRede());
        statement.setFloat(5, lance.getAlturaRede());
        statement.setFloat(6, lance.getTamanhoMalha());
        statement.setFloat(7, lance.getProfundidade());
        statement.setFloat(8, lance.getLatitude());
        statement.setFloat(9, lance.getLongitude());
        ResultSet result = statement.executeQuery();
        result.next();
        lance.setId(result.getInt("id"));
        CapturaDAO capturaDAO = new CapturaDAO(conexao);
        for (Captura captura : lance.getCapturas()) {
            captura.setLance(lance);
            capturaDAO.create(captura);
        }
    }

    @Override
    public void remove(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Lance> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
