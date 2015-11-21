package br.com.sotos.controller;

import br.com.sotos.DAO.DrEtapasProdutoDAO;
import br.com.sotos.model.DrEtapasProduto;
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
@Path("DrEtapasProdutoController")
public class DrEtapasProdutoController {

    private final DrEtapasProdutoDAO dao = new DrEtapasProdutoDAO(DrEtapasProduto.class);
    private final Gson gson = new Gson();

    @GET
    @Path("insert")
    @Produces(MediaType.APPLICATION_JSON)
    public String insert(@QueryParam("json") String json) {
        DrEtapasProduto drEtapasProduto = gson.fromJson(json, DrEtapasProduto.class);
        dao.insert(drEtapasProduto);

        return gson.toJson(drEtapasProduto, DrEtapasProduto.class);
    }

    @GET
    @Path("delete")
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@QueryParam("json") String json) {
        DrEtapasProduto drEtapasProduto = gson.fromJson(json, DrEtapasProduto.class);
        dao.delete(drEtapasProduto);

        return gson.toJson(drEtapasProduto, DrEtapasProduto.class);
    }

    @GET
    @Path("update")
    @Produces(MediaType.APPLICATION_JSON)
    public String update(@QueryParam("json") String json) {
        DrEtapasProduto drEtapasProduto = gson.fromJson(json, DrEtapasProduto.class);
        dao.update(drEtapasProduto);

        return gson.toJson(drEtapasProduto, DrEtapasProduto.class);
    }

    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    public String findById(@QueryParam("id") int id) {
        DrEtapasProduto drEtapasProduto = dao.findById(id);

        return gson.toJson(drEtapasProduto, DrEtapasProduto.class);
    }

    @GET
    @Path("findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public String findByAll() {
        List<DrEtapasProduto> lstDrEtapasProduto = dao.findAll();

        return gson.toJson(lstDrEtapasProduto);
    }
    
    @GET
    @Path("findByProCodigo")
    @Produces(MediaType.APPLICATION_JSON)
    public String findByProCodigo(@QueryParam("pro_codigo") int pro_codigo) {
        List<DrEtapasProduto> lstDrEtapasProduto = dao.findByProCodigo(pro_codigo);
        return gson.toJson(lstDrEtapasProduto);
    }
}
