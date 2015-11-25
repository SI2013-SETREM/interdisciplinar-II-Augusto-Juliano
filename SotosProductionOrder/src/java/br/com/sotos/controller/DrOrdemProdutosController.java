package br.com.sotos.controller;

import br.com.sotos.DAO.DrOrdemProdutosDAO;
import br.com.sotos.model.DrOrdemProdutos;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Modifier;
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
@Path("DrOrdemProdutosController")
public class DrOrdemProdutosController {

    private final DrOrdemProdutosDAO dao = new DrOrdemProdutosDAO(DrOrdemProdutos.class);
    private final Gson gson = new GsonBuilder().excludeFieldsWithModifiers(Modifier.TRANSIENT).create();

    @GET
    @Path("insert")
    @Produces(MediaType.APPLICATION_JSON)
    public String insert(@QueryParam("json") String json) {
        DrOrdemProdutos drOrdemProdutos = gson.fromJson(json, DrOrdemProdutos.class);
        dao.insert(drOrdemProdutos);

        return gson.toJson(drOrdemProdutos, DrOrdemProdutos.class);
    }

    @GET
    @Path("delete")
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@QueryParam("json") String json) {
        DrOrdemProdutos drOrdemProdutos = gson.fromJson(json, DrOrdemProdutos.class);
        dao.delete(drOrdemProdutos);

        return gson.toJson(drOrdemProdutos, DrOrdemProdutos.class);
    }

    @GET
    @Path("update")
    @Produces(MediaType.APPLICATION_JSON)
    public String update(@QueryParam("json") String json) {
        DrOrdemProdutos drOrdemProdutos = gson.fromJson(json, DrOrdemProdutos.class);
        dao.update(drOrdemProdutos);

        return gson.toJson(drOrdemProdutos, DrOrdemProdutos.class);
    }

    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    public String findById(@QueryParam("id") int id) {
        DrOrdemProdutos drOrdemProdutos = dao.findById(id);

        return gson.toJson(drOrdemProdutos, DrOrdemProdutos.class);
    }

    @GET
    @Path("findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public String findByAll() {
        List<DrOrdemProdutos> lstDrOrdemProdutos = dao.findAll();

        return gson.toJson(lstDrOrdemProdutos);
    }

    @GET
    @Path("findByOrdCodigo")
    @Produces(MediaType.APPLICATION_JSON)
    public String findByOrdCodigo(@QueryParam("ord_codigo") int ord_codigo) {
        List<DrOrdemProdutos> lstDrOrdemProdutos = dao.findByOrdCodigo(ord_codigo);

        return gson.toJson(lstDrOrdemProdutos);
    }
}
