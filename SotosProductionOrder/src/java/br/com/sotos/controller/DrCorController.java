package br.com.sotos.controller;

import br.com.sotos.DAO.DrCorDAO;
import br.com.sotos.model.DrCor;
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
@Path("DrCorController")
public class DrCorController {

    private final DrCorDAO dao = new DrCorDAO(DrCor.class);
    private final Gson gson = new Gson();

    @GET
    @Path("insert")
    @Produces(MediaType.APPLICATION_JSON)
    public String insert(@QueryParam("json") String json) {
        DrCor drCor = gson.fromJson(json, DrCor.class);
        dao.insert(drCor);

        return gson.toJson(drCor, DrCor.class);
    }

    @GET
    @Path("delete")
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@QueryParam("json") String json) {
        DrCor drCor = gson.fromJson(json, DrCor.class);
        dao.delete(drCor);

        return gson.toJson(drCor, DrCor.class);
    }

    @GET
    @Path("update")
    @Produces(MediaType.APPLICATION_JSON)
    public String update(@QueryParam("json") String json) {
        DrCor drCor = gson.fromJson(json, DrCor.class);
        dao.update(drCor);

        return gson.toJson(drCor, DrCor.class);
    }

    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    public String findById(@QueryParam("id") int id) {
        DrCor drCor = dao.findById(id);

        return gson.toJson(drCor, DrCor.class);
    }

    @GET
    @Path("findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public String findByAll() {
        List<DrCor> lstDrCor = dao.findAll();

        return gson.toJson(lstDrCor);
    }
}
