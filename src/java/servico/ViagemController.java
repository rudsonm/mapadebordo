/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import dao.IDataAccessObject;
import dao.ViagemDAO;
import dominio.Viagem;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author 5966868
 */
@Path("viagens")
public class ViagemController {
    
    private IDataAccessObject viagemDAO;
    
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
}
