package br.com.sotos.controller;

import br.com.sotos.DAO.DrProdutoTamanhoDAO;
import br.com.sotos.model.DrProdutoTamanho;
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
@Path("DrProdutoTamanhoController")
public class DrProdutoTamanhoController {

    private final DrProdutoTamanhoDAO dao = new DrProdutoTamanhoDAO(DrProdutoTamanho.class);
    private final Gson gson = new Gson();

    @GET
    @Path("insert")
    @Produces(MediaType.APPLICATION_JSON)
    public String insert(@QueryParam("json") String json) {
        DrProdutoTamanho drProdutoTamanho = gson.fromJson(json, DrProdutoTamanho.class);
        dao.insert(drProdutoTamanho);

        return gson.toJson(drProdutoTamanho, DrProdutoTamanho.class);
    }

    @GET
    @Path("delete")
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@QueryParam("json") String json) {
        DrProdutoTamanho drProdutoTamanho = gson.fromJson(json, DrProdutoTamanho.class);
        dao.delete(drProdutoTamanho);

        return gson.toJson(drProdutoTamanho, DrProdutoTamanho.class);
    }

    @GET
    @Path("update")
    @Produces(MediaType.APPLICATION_JSON)
    public String update(@QueryParam("json") String json) {
        DrProdutoTamanho drProdutoTamanho = gson.fromJson(json, DrProdutoTamanho.class);
        dao.update(drProdutoTamanho);

        return gson.toJson(drProdutoTamanho, DrProdutoTamanho.class);
    }

    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    public String findById(@QueryParam("id") int id) {
        DrProdutoTamanho drProdutoTamanho = dao.findById(id);

        return gson.toJson(drProdutoTamanho, DrProdutoTamanho.class);
    }

    @GET
    @Path("findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public String findByAll() {
        List<DrProdutoTamanho> lstDrProdutoTamanho = dao.findAll();

        return gson.toJson(lstDrProdutoTamanho);
    }
}
