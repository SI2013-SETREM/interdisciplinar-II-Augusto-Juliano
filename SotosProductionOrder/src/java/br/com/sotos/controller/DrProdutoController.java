package br.com.sotos.controller;

import br.com.sotos.DAO.DrProdutoDAO;
import br.com.sotos.model.DrProduto;
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
@Path("DrProdutoController")
public class DrProdutoController {

    private final DrProdutoDAO dao = new DrProdutoDAO(DrProduto.class);
    private final Gson gson = new Gson();

    @GET
    @Path("insert")
    @Produces(MediaType.APPLICATION_JSON)
    public String insert(@QueryParam("json") String json) {
        DrProduto drProduto = gson.fromJson(json, DrProduto.class);
        dao.insert(drProduto);

        return gson.toJson(drProduto, DrProduto.class);
    }

    @GET
    @Path("delete")
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@QueryParam("json") String json) {
        DrProduto drProduto = gson.fromJson(json, DrProduto.class);
        dao.delete(drProduto);

        return gson.toJson(drProduto, DrProduto.class);
    }

    @GET
    @Path("update")
    @Produces(MediaType.APPLICATION_JSON)
    public String update(@QueryParam("json") String json) {
        DrProduto drProduto = gson.fromJson(json, DrProduto.class);
        dao.update(drProduto);

        return gson.toJson(drProduto, DrProduto.class);
    }

    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    public String findById(@QueryParam("id") int id) {
        DrProduto drProduto = dao.findById(id);

        return gson.toJson(drProduto, DrProduto.class);
    }

    @GET
    @Path("findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public String findByAll() {
        List<DrProduto> lstDrProduto = dao.findAll();

        return gson.toJson(lstDrProduto);
    }
}
