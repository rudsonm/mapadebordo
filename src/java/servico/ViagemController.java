/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import dao.IDataAccessObject;
import dao.ViagemDAO;
import dominio.Viagem;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author 5966868
 */
@Path("viagens")
public class ViagemController {
    
    private IDataAccessObject<Viagem> viagemDAO;
    
    public ViagemController() {
        viagemDAO = new ViagemDAO();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void create(Viagem viagem) throws Exception {
        try {
            viagemDAO.create(viagem);
        } catch (Exception e) {
            throw e;
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Viagem> getAll() throws Exception {
        List<Viagem> viagens = null;
        try {
            viagens = viagemDAO.getAll();
        } catch (Exception e) {
            throw e;
        }
        return viagens;
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Viagem getOne(@PathParam("id") int id) throws Exception {
        return viagemDAO.getOne(id);
    }
}
