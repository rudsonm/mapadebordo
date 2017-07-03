/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dominio.Captura;
import java.sql.PreparedStatement;
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
    
}