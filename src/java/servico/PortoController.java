/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import dao.Conexao;
import dao.PortoDAO;
import dao.IDataAccessObject;
import dominio.Porto;
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
@Path("portos")
public class PortoController {
    
    private IDataAccessObject portoDAO;
    
    public PortoController() throws Exception {
        portoDAO = new PortoDAO();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Porto> getAll() {
        List<Porto> portos = null;
        try {
            portos = portoDAO.getAll();
        } catch (Exception e) {
            
        }
        return portos;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void create(Porto porto) throws Exception {
        try {
            portoDAO.create(porto);
        } catch (Exception e) {
            throw e;
        }
    }
    
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") int id) throws Exception {
        try {
            portoDAO.remove(id);
        } catch (Exception e) {
            throw e;
        }
    }
}


