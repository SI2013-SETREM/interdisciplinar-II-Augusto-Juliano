package br.com.sotos.DAO;

import br.com.sotos.model.DrProdutoCores;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Augusto
 */
public class DrProdutoCoresDAO extends DAO<DrProdutoCores> {

    public DrProdutoCoresDAO(Class<DrProdutoCores> typeClass) {
        super(typeClass);
    }

    public List<DrProdutoCores> findByProCodigo(int pro_codigo) {
        Session session = super.getSession();
        List<DrProdutoCores> list = session.createQuery("from DrProdutoCores inner join fetch DrProdutoCores.DrProduto where DrProdutoCores.DrProduto.pro_codigo = " + pro_codigo + " order by DrProdutoCores.prc_ordem").list();
        session.close();
        return list;
    }

}
