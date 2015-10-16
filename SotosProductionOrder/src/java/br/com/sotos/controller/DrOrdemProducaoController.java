package br.com.sotos.controller;

import br.com.sotos.DAO.DrOrdemProducaoDAO;
import br.com.sotos.model.DrOrdemProducao;
import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Augusto
 */
@Path("DrOrdemProducaoController")
public class DrOrdemProducaoController {

    private final DrOrdemProducaoDAO dao = new DrOrdemProducaoDAO(DrOrdemProducao.class);
    private final Gson gson = new Gson();

    @GET
    @Path("insert")
    @Produces(MediaType.APPLICATION_JSON)
    public String insert(@QueryParam("json") String json) {
        DrOrdemProducao drOrdemProducao = gson.fromJson(json, DrOrdemProducao.class);
        dao.insert(drOrdemProducao);

        return gson.toJson(drOrdemProducao, DrOrdemProducao.class);
    }

    @GET
    @Path("delete")
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@QueryParam("json") String json) {
        DrOrdemProducao drOrdemProducao = gson.fromJson(json, DrOrdemProducao.class);
        dao.delete(drOrdemProducao);

        return gson.toJson(drOrdemProducao, DrOrdemProducao.class);
    }

    @GET
    @Path("update")
    @Produces(MediaType.APPLICATION_JSON)
    public String update(@QueryParam("json") String json) {
        DrOrdemProducao drOrdemProducao = gson.fromJson(json, DrOrdemProducao.class);
        dao.update(drOrdemProducao);

        return gson.toJson(drOrdemProducao, DrOrdemProducao.class);
    }

    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    public String findById(@QueryParam("id") int id) {
        DrOrdemProducao drOrdemProducao = dao.findById(id);

        return gson.toJson(drOrdemProducao, DrOrdemProducao.class);
    }

    @GET
    @Path("findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public String findByAll() {
        List<DrOrdemProducao> lstDrOrdemProducao = dao.findAll();

        return gson.toJson(lstDrOrdemProducao);
    }
}
