package br.com.sotos.controller;

import br.com.sotos.DAO.DrTamanhoDAO;
import br.com.sotos.model.DrTamanho;
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
@Path("DrTamanhoController")
public class DrTamanhoController {

    private final DrTamanhoDAO dao = new DrTamanhoDAO(DrTamanho.class);
    private final Gson gson = new Gson();

    @GET
    @Path("insert")
    @Produces(MediaType.APPLICATION_JSON)
    public String insert(@QueryParam("json") String json) {
        DrTamanho drTamanho = gson.fromJson(json, DrTamanho.class);
        dao.insert(drTamanho);

        return gson.toJson(drTamanho, DrTamanho.class);
    }

    @GET
    @Path("delete")
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@QueryParam("json") String json) {
        DrTamanho drTamanho = gson.fromJson(json, DrTamanho.class);
        dao.delete(drTamanho);

        return gson.toJson(drTamanho, DrTamanho.class);
    }

    @GET
    @Path("update")
    @Produces(MediaType.APPLICATION_JSON)
    public String update(@QueryParam("json") String json) {
        DrTamanho drTamanho = gson.fromJson(json, DrTamanho.class);
        dao.update(drTamanho);

        return gson.toJson(drTamanho, DrTamanho.class);
    }

    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    public String findById(@QueryParam("id") int id) {
        DrTamanho drTamanho = dao.findById(id);

        return gson.toJson(drTamanho, DrTamanho.class);
    }

    @GET
    @Path("findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public String findByAll() {
        List<DrTamanho> lstDrTamanho = dao.findAll();

        return gson.toJson(lstDrTamanho);
    }
    
    @GET
    @Path("findByProCodigo")
    @Produces(MediaType.APPLICATION_JSON)
    public String findByProCodigo(@QueryParam("pro_codigo") int pro_codigo) {
        List<DrTamanho> drTamanhoLst = dao.findByProCodigo(pro_codigo);

        return gson.toJson(drTamanhoLst);
    }
}
