/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import dao.Conexao;
import dao.EspecieDAO;
import dao.IDataAccessObject;
import dominio.Especie;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

/**
 *
 * @author rudson
 */
@Path("especies")
public class EspecieController {
    
    private IDataAccessObject especieDAO;
    
    public EspecieController() throws Exception {
        especieDAO = new EspecieDAO();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Especie> getAll() {
        List<Especie> especies = null;
        try {
            especies = especieDAO.getAll();
        } catch (Exception e) {
            
        }
        return especies;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void create(Especie especie) throws Exception {
        try {
            especieDAO.create(especie);
        } catch (Exception e) {
            throw e;
        }
    }
    
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") int id) throws Exception {
        try {
            especieDAO.remove(id);
        } catch (Exception e) {
            throw e;
        }
    }
}


