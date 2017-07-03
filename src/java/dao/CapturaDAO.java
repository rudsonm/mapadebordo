/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dominio.Captura;
import dominio.Especie;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rudson
 */
public class CapturaDAO implements IDataAccessObject<Captura> {

    private Conexao conexao;
    
    public CapturaDAO() throws Exception {
        conexao = new Conexao();
    }
    
    public CapturaDAO(Conexao conexao) {
        this.conexao = conexao;
    }
    
    @Override
    public void create(Captura captura) throws Exception {
        String query = "INSERT INTO captura (lance, especie, kg) VALUES (?,?)";
        PreparedStatement statement = conexao.getConexao().prepareStatement(query);
        statement.setInt(1, captura.getLance().getId());
        statement.setInt(2, captura.getEspecie().getId());
        statement.setFloat(3, captura.getKg());
        statement.executeUpdate();
    }

    @Override
    public void remove(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Captura> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Captura getOne(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Captura> getByLance(int lance) throws Exception {
        
        Statement statement = conexao.getConexao().createStatement();
        String sql = "select * from captura where viagem_id = "+lance;
        ResultSet result = statement.executeQuery(sql);
        
        List<Captura> capturas = new ArrayList<>();
        
        while ( result.next() ){
        Captura captura = new Captura();
        captura.setId(result.getInt("id"));
        
        EspecieDAO especieDAO = new EspecieDAO(conexao);
        Especie especie = especieDAO.getOne(result.getInt("especie_id"));
        captura.setEspecie(especie);
        
        captura.setKg(result.getFloat("kg"));
        capturas.add(captura);
        }
        
        return capturas;
        
    }
    
}