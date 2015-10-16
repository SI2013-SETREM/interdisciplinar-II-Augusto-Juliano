package br.com.sotos.controller;

import br.com.sotos.DAO.DrProdutoFinalDAO;
import br.com.sotos.model.DrProdutoFinal;
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
@Path("DrProdutoFinalController")
public class DrProdutoFinalController {

    private final DrProdutoFinalDAO dao = new DrProdutoFinalDAO(DrProdutoFinal.class);
    private final Gson gson = new Gson();

    @GET
    @Path("insert")
    @Produces(MediaType.APPLICATION_JSON)
    public String insert(@QueryParam("json") String json) {
        DrProdutoFinal drProdutoFinal = gson.fromJson(json, DrProdutoFinal.class);
        dao.insert(drProdutoFinal);

        return gson.toJson(drProdutoFinal, DrProdutoFinal.class);
    }

    @GET
    @Path("delete")
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@QueryParam("json") String json) {
        DrProdutoFinal drProdutoFinal = gson.fromJson(json, DrProdutoFinal.class);
        dao.delete(drProdutoFinal);

        return gson.toJson(drProdutoFinal, DrProdutoFinal.class);
    }

    @GET
    @Path("update")
    @Produces(MediaType.APPLICATION_JSON)
    public String update(@QueryParam("json") String json) {
        DrProdutoFinal drProdutoFinal = gson.fromJson(json, DrProdutoFinal.class);
        dao.update(drProdutoFinal);

        return gson.toJson(drProdutoFinal, DrProdutoFinal.class);
    }

    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    public String findById(@QueryParam("id") int id) {
        DrProdutoFinal drProdutoFinal = dao.findById(id);

        return gson.toJson(drProdutoFinal, DrProdutoFinal.class);
    }

    @GET
    @Path("findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public String findByAll() {
        List<DrProdutoFinal> lstDrProdutoFinal = dao.findAll();

        return gson.toJson(lstDrProdutoFinal);
    }
}
