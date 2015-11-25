package br.com.sotos.DAO;

import br.com.sotos.model.DrOrdemProdutos;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Augusto
 */
public class DrOrdemProdutosDAO extends DAO<DrOrdemProdutos> {

    public DrOrdemProdutosDAO(Class<DrOrdemProdutos> typeClass) {
        super(typeClass);
    }
    
    public List<DrOrdemProdutos> findByOrdCodigo(int ord_codigo) {
        Session session = super.getSession();
        List<DrOrdemProdutos> list = session.createQuery("from DrOrdemProdutos opr inner join fetch opr.drOrdemProducao ord where ord.ord_codigo = " + ord_codigo).list();
        session.close();
        return list;
    }

}
