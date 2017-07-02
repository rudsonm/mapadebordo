/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import dao.Conexao;
import dao.EmbarcacaoDAO;
import dao.IDataAccessObject;
import dominio.Embarcacao;
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
@Path("embarcacoes")
public class EmbarcacaoController {
    
    private IDataAccessObject embarcacaoDAO;
    
    public EmbarcacaoController() throws Exception {
        embarcacaoDAO = new EmbarcacaoDAO();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Embarcacao> getAll() throws Exception {
        List<Embarcacao> embarcacoes = null;
        try {
            embarcacoes = embarcacaoDAO.getAll();
        } catch (Exception e) {
            throw e;
        }
        return embarcacoes;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void create(Embarcacao embarcacao) throws Exception {
        try {
            embarcacaoDAO.create(embarcacao);
        } catch (Exception e) {
            throw e;
        }
    }
    
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") int id) throws Exception {
        try {
            embarcacaoDAO.remove(id);
        } catch (Exception e) {
            throw e;
        }
    }
}


