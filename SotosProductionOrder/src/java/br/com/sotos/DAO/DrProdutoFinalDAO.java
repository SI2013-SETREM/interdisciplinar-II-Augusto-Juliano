package br.com.sotos.DAO;

import br.com.sotos.model.DrProdutoFinal;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Augusto
 */
public class DrProdutoFinalDAO extends DAO<DrProdutoFinal> {

    public DrProdutoFinalDAO(Class<DrProdutoFinal> typeClass) {
        super(typeClass);
    }

    public DrProdutoFinal findByProCodigoRef(String pro_codigoref) {
        Session session = super.getSession();
        List<DrProdutoFinal> lstDrProduto;
        lstDrProduto = session.createQuery("from DrProdutoFinal where pro_codigoref = '" + pro_codigoref + "'").list();
        session.close();
        return lstDrProduto.isEmpty() ? null : lstDrProduto.get(0);
    }
    
    public DrProdutoFinal findDrProdutoFinal(int pro_codigo, int tam_codigo, int cor_codigo) {
        Session session = super.getSession();
        List<DrProdutoFinal> lstDrProduto;
        lstDrProduto = session.createQuery("from DrProdutoFinal where pro_codigo = " + pro_codigo + " and tam_codigo = " + tam_codigo + " and cor_codigo = " + cor_codigo).list();
        session.close();
        return lstDrProduto.isEmpty() ? null : lstDrProduto.get(0);
    }

}
