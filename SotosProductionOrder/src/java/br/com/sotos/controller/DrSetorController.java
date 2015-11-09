package br.com.sotos.controller;

import br.com.sotos.DAO.DrSetorDAO;
import br.com.sotos.model.DrSetor;
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
@Path("DrSetorController")
public class DrSetorController {

    private final DrSetorDAO dao = new DrSetorDAO(DrSetor.class);
    private final Gson gson = new Gson();

    @GET
    @Path("insert")
    @Produces(MediaType.APPLICATION_JSON)
    public String insert(@QueryParam("json") String json) {
        DrSetor drSetor = gson.fromJson(json, DrSetor.class);
        dao.insert(drSetor);

        return gson.toJson(drSetor, DrSetor.class);
    }

    @GET
    @Path("delete")
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@QueryParam("json") String json) {
        DrSetor drSetor = gson.fromJson(json, DrSetor.class);
        dao.delete(drSetor);

        return gson.toJson(drSetor, DrSetor.class);
    }

    @GET
    @Path("update")
    @Produces(MediaType.APPLICATION_JSON)
    public String update(@QueryParam("json") String json) {
        DrSetor drSetor = gson.fromJson(json, DrSetor.class);
        dao.update(drSetor);

        return gson.toJson(drSetor, DrSetor.class);
    }

    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    public String findById(@QueryParam("id") int id) {
        DrSetor drSetor = dao.findById(id);

        return gson.toJson(drSetor, DrSetor.class);
    }

    @GET
    @Path("findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public String findByAll() {
        List<DrSetor> lstDrSetor = dao.findAll();

        return gson.toJson(lstDrSetor);
    }
}
