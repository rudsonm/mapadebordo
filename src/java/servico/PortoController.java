/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

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
    
    private static List<Porto> portos = new ArrayList<>();
    
    public PortoController() {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Porto> getAll() {
        return portos;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Porto create(Porto porto) {
        porto.setId(portos.size()+1);
        portos.add(porto);
        return porto;
    }
    
    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void remove(@PathParam("id") int id) {
        for (Porto porto : portos) {
            if(porto.getId() == id) {
                portos.remove(porto);
            }
        }
    }
}


