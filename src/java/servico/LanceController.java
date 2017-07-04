/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import dao.CapturaDAO;
import dao.LanceDAO;
import dominio.Captura;
import dominio.Lance;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author rudson
 */
@Path("lances")
public class LanceController {
    @GET
    @Path("{id}/capturas")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Captura> getCapturas(@PathParam("id") int id) throws Exception {
        CapturaDAO capturaDAO = new CapturaDAO();
        return capturaDAO.getByLance(id);
    }
}
