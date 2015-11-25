package br.com.sotos.DAO;

import br.com.sotos.model.DrCor;
import br.com.sotos.model.DrEtapaProducao;
import br.com.sotos.model.DrEtapasProduto;
import br.com.sotos.model.DrOrdemProducao;
import br.com.sotos.model.DrOrdemProdutos;
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

    public List<DrOrdemProducao> findByOrdSituacao(String ord_situacao) {
        Session session = super.getSession();
        List<DrOrdemProducao> list = session.createQuery("from DrOrdemProducao where ord_situacao = '" + ord_situacao + "' order by ord_datacadastro").list();
        session.close();
        return list;
    }
    
    public void insertOrders(List<JsonObject> objects, DrOrdemProducao drOrdemProducao) throws Exception {
        Session session = super.getSession();
        Transaction t = session.beginTransaction();
        try {
            DrProdutoFinalDAO prfDAO = new DrProdutoFinalDAO(DrProdutoFinal.class);
            DrCorDAO corDAO = new DrCorDAO(DrCor.class);
            DrTamanhoDAO tamDAO = new DrTamanhoDAO(DrTamanho.class);
            DrEtapasProdutoDAO etpDAO = new DrEtapasProdutoDAO(DrEtapasProduto.class);

            drOrdemProducao.setOrd_datacadastro(new Date());
            session.save(drOrdemProducao);

            for (JsonObject object : objects) {
                if (object.get("qtde") != null) {
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

                    session.save(drOrdemProdutos);
                }
            }

            List<DrEtapasProduto> drEtapasProdutoLst = etpDAO.findByProCodigo(drOrdemProducao.getDrProduto().getPro_codigo());
            boolean status = true;
            for (int i = 0; i < drEtapasProdutoLst.size(); i++) {
                DrEtapaProducao drEtapaProducao = new DrEtapaProducao();

                drEtapaProducao.setDrEtapasProduto(drEtapasProdutoLst.get(i));
                drEtapaProducao.setDrOrdemProducao(drOrdemProducao);
                drEtapaProducao.setEpp_status(status);
                if (i == 0) {
                    drEtapaProducao.setEpp_datainicio(new Date());
                }
                if ("F".equals(drOrdemProducao.getOrd_situacao())) {
                    drEtapaProducao.setEpp_datainicio(new Date());
                    drEtapaProducao.setEpp_datafim(new Date());
                    drEtapaProducao.setEpp_status(true);
                }
                session.save(drEtapaProducao);
                status = false;
            }

            t.commit();
            session.close();
        } catch (Exception ex) {
            t.rollback();
            session.close();
            throw new Exception(ex.getMessage(), ex.getCause());
        }
    }

}
