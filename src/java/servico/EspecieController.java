/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import dao.Conexao;
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
    
    private static List<Especie> especies = new ArrayList<>();
    
    public EspecieController() {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Especie> getAll() throws Exception {
        Conexao conexao = new Conexao();
        return especies;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Especie create(Especie especie) {
        especie.setId(especies.size()+1);
        especies.add(especie);
        return especie;
    }
    
    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void remove(@PathParam("id") int id) {
        for (Especie especie : especies) {
            if(especie.getId() == id) {
                especies.remove(especie);
            }
        }
    }
}


