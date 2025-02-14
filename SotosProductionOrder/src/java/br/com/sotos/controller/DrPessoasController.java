package br.com.sotos.controller;

import br.com.sotos.DAO.DrPessoasDAO;
import br.com.sotos.model.DrPessoas;
import br.com.sotos.utils.Util;
import com.google.gson.Gson;
import java.security.NoSuchAlgorithmException;
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
@Path("DrPessoasController")
public class DrPessoasController {

    private final DrPessoasDAO dao = new DrPessoasDAO(DrPessoas.class);
    private final Gson gson = new Gson();

    @GET
    @Path("insert")
    @Produces(MediaType.APPLICATION_JSON)
    public String insert(@QueryParam("json") String json) throws NoSuchAlgorithmException {
        DrPessoas drPessoas = gson.fromJson(json, DrPessoas.class);
        String new_password = drPessoas.getPes_password() + "$otaoDaMa$$a2015";
        Util utl = new Util();
        drPessoas.setPes_password(utl.convertPasswordToMD5(new_password));
        dao.insert(drPessoas);

        return gson.toJson(drPessoas, DrPessoas.class);
    }

    @GET
    @Path("delete")
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@QueryParam("json") String json) {
        DrPessoas drPessoas = gson.fromJson(json, DrPessoas.class);
        dao.delete(drPessoas);

        return gson.toJson(drPessoas, DrPessoas.class);
    }

    @GET
    @Path("update")
    @Produces(MediaType.APPLICATION_JSON)
    public String update(@QueryParam("json") String json) throws NoSuchAlgorithmException {
        DrPessoas drPessoas = gson.fromJson(json, DrPessoas.class);
        String new_password = drPessoas.getPes_password() + "$otaoDaMa$$a2015";
        Util utl = new Util();
        drPessoas.setPes_password(utl.convertPasswordToMD5(new_password));
        dao.update(drPessoas);

        return gson.toJson(drPessoas, DrPessoas.class);
    }

    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    public String findById(@QueryParam("id") int id) {
        DrPessoas drPessoas = dao.findById(id);

        return gson.toJson(drPessoas, DrPessoas.class);
    }

    @GET
    @Path("findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public String findByAll() {
        List<DrPessoas> lstDrPessoas = dao.findAll();

        return gson.toJson(lstDrPessoas);
    }
}
