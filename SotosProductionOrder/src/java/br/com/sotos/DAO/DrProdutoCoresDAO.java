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
        List<DrProdutoCores> list = session.createQuery("from DrProdutoCores where DrProdutoCores.pro_codigo = " + pro_codigo + " order by DrProdutoCores.DrCor.cor_des").list();
        session.close();
        return list;
    }

}
