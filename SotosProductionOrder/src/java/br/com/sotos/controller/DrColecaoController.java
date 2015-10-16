package br.com.sotos.controller;

import br.com.sotos.DAO.DrColecaoDAO;
import br.com.sotos.model.DrColecao;
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
@Path("DrColecaoController")
public class DrColecaoController {

    private final DrColecaoDAO dao = new DrColecaoDAO(DrColecao.class);
    private final Gson gson = new Gson();

    @GET
    @Path("insert")
    @Produces(MediaType.APPLICATION_JSON)
    public String insert(@QueryParam("json") String json) {
        DrColecao drColecao = gson.fromJson(json, DrColecao.class);
        dao.insert(drColecao);

        return gson.toJson(drColecao, DrColecao.class);
    }

    @GET
    @Path("delete")
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@QueryParam("json") String json) {
        DrColecao drColecao = gson.fromJson(json, DrColecao.class);
        dao.delete(drColecao);

        return gson.toJson(drColecao, DrColecao.class);
    }

    @GET
    @Path("update")
    @Produces(MediaType.APPLICATION_JSON)
    public String update(@QueryParam("json") String json) {
        DrColecao drColecao = gson.fromJson(json, DrColecao.class);
        dao.update(drColecao);

        return gson.toJson(drColecao, DrColecao.class);
    }

    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    public String findById(@QueryParam("id") int id) {
        DrColecao drColecao = dao.findById(id);

        return gson.toJson(drColecao, DrColecao.class);
    }

    @GET
    @Path("findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public String findByAll() {
        List<DrColecao> lstDrColecao = dao.findAll();

        return gson.toJson(lstDrColecao);
    }
}
