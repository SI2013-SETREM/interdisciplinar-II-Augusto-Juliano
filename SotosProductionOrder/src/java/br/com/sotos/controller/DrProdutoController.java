package br.com.sotos.controller;

import br.com.sotos.DAO.DrProdutoDAO;
import br.com.sotos.DAO.DrProdutoFinalDAO;
import br.com.sotos.model.DrProduto;
import br.com.sotos.model.DrProdutoCores;
import br.com.sotos.model.DrProdutoFinal;
import br.com.sotos.model.DrProdutoTamanho;
import com.google.gson.Gson;
import java.util.Date;
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

    @GET
    @Path("createChildrens")
    @Produces(MediaType.APPLICATION_JSON)
    public String createChildrens() {
        DrProdutoFinalDAO daoPF = new DrProdutoFinalDAO(DrProdutoFinal.class);
        List<DrProduto> lstDrProduto = dao.findAll();
        for (DrProduto drProduto : lstDrProduto) {
            List<DrProdutoCores> lstDrCor = dao.getCores(drProduto);
            List<DrProdutoTamanho> lstDrTam = dao.getTamanhos(drProduto);
            if (lstDrCor.size() > 0 && lstDrTam.size() > 0) {
                for (DrProdutoCores cor : lstDrCor) {
                    for (DrProdutoTamanho tamanho : lstDrTam) {
                        DrProdutoFinal finalPro = new DrProdutoFinal();
                        finalPro.setDrCor(cor.getDrCor());
                        finalPro.setDrProduto(drProduto);
                        finalPro.setDrTamanho(tamanho.getDrTamanho());
                        String pro_codigoref = String.valueOf(drProduto.getPro_codigopro());
                        pro_codigoref += '-';
                        pro_codigoref += cor.getDrCor().getCor_codigocor();
                        pro_codigoref += '-';
                        pro_codigoref += tamanho.getDrTamanho().getTam_sigla();
                        finalPro.setPro_codigoref(pro_codigoref);
                        finalPro.setPro_descricao(drProduto.getPro_descricao() + ' ' + cor.getDrCor().getCor_descricao() + ' ' + tamanho.getDrTamanho().getTam_sigla());
                        finalPro.setPro_valorvenda(drProduto.getPro_valorvenda());
                        finalPro.setPro_datacadastro(new Date());
                        DrProdutoFinal drProdutoFinal = daoPF.findByProCodigoRef(finalPro.getPro_codigoref());
                        if (drProdutoFinal == null) {
                            daoPF.insert(finalPro);
                        }
                    }
                }
            }
        }
        return gson.toJson(lstDrProduto);
    }
}
