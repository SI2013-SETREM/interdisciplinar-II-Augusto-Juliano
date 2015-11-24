package br.com.sotos.DAO;

import br.com.sotos.model.DrCor;
import br.com.sotos.model.DrOrdemProducao;
import br.com.sotos.model.DrOrdemProdutos;
import br.com.sotos.model.DrProduto;
import br.com.sotos.model.DrProdutoFinal;
import br.com.sotos.model.DrTamanho;
import com.google.gson.JsonObject;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Augusto
 */
public class DrOrdemProducaoDAO extends DAO<DrOrdemProducao> {

    public DrOrdemProducaoDAO(Class<DrOrdemProducao> typeClass) {
        super(typeClass);
    }

    public void insertOrders(List<JsonObject> objects, DrOrdemProducao drOrdemProducao) {
        Session session = super.getSession();
        Transaction t = session.beginTransaction();
        DrProdutoFinalDAO prfDAO = new DrProdutoFinalDAO(DrProdutoFinal.class);
        DrCorDAO corDAO = new DrCorDAO(DrCor.class);
        DrTamanhoDAO tamDAO = new DrTamanhoDAO(DrTamanho.class);

        session.save(drOrdemProducao);

        for (JsonObject object : objects) {
            DrOrdemProdutos drOrdemProdutos = new DrOrdemProdutos();
            drOrdemProdutos.setOpr_quantidade(object.get("qtde").getAsInt());
            drOrdemProdutos.setDrOrdemProducao(drOrdemProducao);

            DrProdutoFinal drProdutoFinal = prfDAO.findDrProdutoFinal(drOrdemProducao.getDrProduto().getPro_codigo(), object.get("tam_codigo").getAsInt(), object.get("cor_codigo").getAsInt());
            if (drProdutoFinal == null) {
                DrCor drCor = corDAO.findById(object.get("cor_codigo").getAsInt());
                DrTamanho drTamanho = tamDAO.findById(object.get("tam_codigo").getAsInt());

                drProdutoFinal = new DrProdutoFinal();
                drProdutoFinal.setPro_datacadastro(new Date());
                drProdutoFinal.setPro_descricao(drOrdemProducao.getDrProduto().getPro_descricao());
                drProdutoFinal.setPro_valorvenda(drOrdemProducao.getDrProduto().getPro_valorvenda());
                drProdutoFinal.setDrProduto(drOrdemProducao.getDrProduto());
                drProdutoFinal.setDrCor(drCor);
                drProdutoFinal.setDrTamanho(drTamanho);
                session.save(drProdutoFinal);

            }
            drOrdemProdutos.setDrProdutoFinal(drProdutoFinal);

            //TODO: Código cabuloso aqui...        
            //session.save(drOrdemProducao);
        }
        //t.commit();
        session.close();
    }

}
