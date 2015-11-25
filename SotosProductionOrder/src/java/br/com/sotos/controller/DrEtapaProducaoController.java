package br.com.sotos.controller;

import br.com.sotos.DAO.DrEtapaProducaoDAO;
import br.com.sotos.model.DrEtapaProducao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
@Path("DrEtapaProducaoController")
public class DrEtapaProducaoController {

    private final DrEtapaProducaoDAO dao = new DrEtapaProducaoDAO(DrEtapaProducao.class);
    private final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();

    @GET
    @Path("insert")
    @Produces(MediaType.APPLICATION_JSON)
    public String insert(@QueryParam("json") String json) {
        DrEtapaProducao drEtapaProducao = gson.fromJson(json, DrEtapaProducao.class);
        dao.insert(drEtapaProducao);

        return gson.toJson(drEtapaProducao, DrEtapaProducao.class);
    }

    @GET
    @Path("delete")
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@QueryParam("json") String json) {
        DrEtapaProducao drEtapaProducao = gson.fromJson(json, DrEtapaProducao.class);
        dao.delete(drEtapaProducao);

        return gson.toJson(drEtapaProducao, DrEtapaProducao.class);
    }

    @GET
    @Path("update")
    @Produces(MediaType.APPLICATION_JSON)
    public String update(@QueryParam("json") String json) {
        DrEtapaProducao drEtapaProducao = gson.fromJson(json, DrEtapaProducao.class);
        dao.update(drEtapaProducao);

        return gson.toJson(drEtapaProducao, DrEtapaProducao.class);
    }

    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    public String findById(@QueryParam("id") int id) {
        DrEtapaProducao drEtapaProducao = dao.findById(id);

        return gson.toJson(drEtapaProducao, DrEtapaProducao.class);
    }

    @GET
    @Path("findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public String findByAll() {
        List<DrEtapaProducao> lstDrEtapaProducao = dao.findAll();

        return gson.toJson(lstDrEtapaProducao);
    }

    @GET
    @Path("findByOrdCodigo")
    @Produces(MediaType.APPLICATION_JSON)
    public String findByOrdCodigo(@QueryParam("ord_codigo") int ord_codigo) {
        List<DrEtapaProducao> lstEtapaProducao = dao.findByOrdCodigo(ord_codigo);
        for (DrEtapaProducao item : lstEtapaProducao) {
            item.getDrOrdemProducao().setLstDrEtapaProducao(null);
            item.getDrOrdemProducao().setLstDrOrdemProdutos(null);
        }
        return gson.toJson(lstEtapaProducao);
    }
}
