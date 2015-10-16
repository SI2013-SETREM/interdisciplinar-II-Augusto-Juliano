package br.com.sotos.controller;

import br.com.sotos.DAO.DrLogDAO;
import br.com.sotos.model.DrLog;
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
@Path("DrLogController")
public class DrLogController {

    private final DrLogDAO dao = new DrLogDAO(DrLog.class);
    private final Gson gson = new Gson();

    @GET
    @Path("insert")
    @Produces(MediaType.APPLICATION_JSON)
    public String insert(@QueryParam("json") String json) {
        DrLog drLog = gson.fromJson(json, DrLog.class);
        dao.insert(drLog);

        return gson.toJson(drLog, DrLog.class);
    }

    @GET
    @Path("delete")
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@QueryParam("json") String json) {
        DrLog drLog = gson.fromJson(json, DrLog.class);
        dao.delete(drLog);

        return gson.toJson(drLog, DrLog.class);
    }

    @GET
    @Path("update")
    @Produces(MediaType.APPLICATION_JSON)
    public String update(@QueryParam("json") String json) {
        DrLog drLog = gson.fromJson(json, DrLog.class);
        dao.update(drLog);

        return gson.toJson(drLog, DrLog.class);
    }

    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    public String findById(@QueryParam("id") int id) {
        DrLog drLog = dao.findById(id);

        return gson.toJson(drLog, DrLog.class);
    }

    @GET
    @Path("findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public String findByAll() {
        List<DrLog> lstDrLog = dao.findAll();

        return gson.toJson(lstDrLog);
    }
}
