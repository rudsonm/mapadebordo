/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dominio.Captura;
import dominio.Lance;
import dominio.Viagem;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

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

    @Override
    public Lance getOne(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Collection<Lance> getByViagem(int viagem) throws Exception {
        
        Statement statement = conexao.getConexao().createStatement();
        String sql = "select * from lance where viagem_id = "+viagem;
        ResultSet result = statement.executeQuery(sql);
        
        Collection<Lance> lances = new ArrayList<>();
        
        while ( result.next() ){
        Lance lance = new Lance();
        lance.setId(result.getInt("id"));
        // timestamp to datetime data_inicio
        // timestamp to datetime data_termino
        lance.setComprimentoRede(result.getFloat("comprimento_rede"));
        lance.setAlturaRede(result.getFloat("altura_rede"));
        lance.setTamanhoMalha(result.getFloat("tamanho_malha"));
        lance.setProfundidade(result.getFloat("profundidade"));
        lance.setLatitude(result.getFloat("latitude"));
        lance.setLongitude(result.getFloat("longitude"));
        lances.add(lance);
        }
        
        return lances;
        
    }
}
