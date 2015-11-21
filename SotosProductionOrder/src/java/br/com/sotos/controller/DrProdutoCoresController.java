package br.com.sotos.controller;

import br.com.sotos.DAO.DrProdutoCoresDAO;
import br.com.sotos.model.DrProdutoCores;
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
@Path("DrProdutoCoresController")
public class DrProdutoCoresController {

    private final DrProdutoCoresDAO dao = new DrProdutoCoresDAO(DrProdutoCores.class);
    private final Gson gson = new Gson();

    @GET
    @Path("insert")
    @Produces(MediaType.APPLICATION_JSON)
    public String insert(@QueryParam("json") String json) {
        DrProdutoCores drProdutoCores = gson.fromJson(json, DrProdutoCores.class);
        dao.insert(drProdutoCores);

        return gson.toJson(drProdutoCores, DrProdutoCores.class);
    }

    @GET
    @Path("delete")
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@QueryParam("json") String json) {
        DrProdutoCores drProdutoCores = gson.fromJson(json, DrProdutoCores.class);
        dao.delete(drProdutoCores);

        return gson.toJson(drProdutoCores, DrProdutoCores.class);
    }

    @GET
    @Path("update")
    @Produces(MediaType.APPLICATION_JSON)
    public String update(@QueryParam("json") String json) {
        DrProdutoCores drProdutoCores = gson.fromJson(json, DrProdutoCores.class);
        dao.update(drProdutoCores);

        return gson.toJson(drProdutoCores, DrProdutoCores.class);
    }

    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    public String findById(@QueryParam("id") int id) {
        DrProdutoCores drProdutoCores = dao.findById(id);

        return gson.toJson(drProdutoCores, DrProdutoCores.class);
    }

    @GET
    @Path("findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public String findByAll() {
        List<DrProdutoCores> lstDrProdutoCores = dao.findAll();

        return gson.toJson(lstDrProdutoCores);
    }
    
    @GET
    @Path("findByProCodigo")
    @Produces(MediaType.APPLICATION_JSON)
    public String findByProCodigo(@QueryParam("pro_codigo") int pro_codigo) {
        List<DrProdutoCores> lstDrProdutoCores = dao.findByProCodigo(pro_codigo);
        return gson.toJson(lstDrProdutoCores);
    }
}
