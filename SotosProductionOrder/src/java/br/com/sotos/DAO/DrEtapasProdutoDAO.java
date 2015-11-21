package br.com.sotos.DAO;

import br.com.sotos.model.DrEtapasProduto;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Augusto
 */
public class DrEtapasProdutoDAO extends DAO<DrEtapasProduto> {

    public DrEtapasProdutoDAO(Class<DrEtapasProduto> typeClass) {
        super(typeClass);
    }

    public List<DrEtapasProduto> findByProCodigo(int pro_codigo) {
        Session session = super.getSession();
        List<DrEtapasProduto> list = session.createQuery("from DrEtapasProduto etp inner join fetch etp.drProduto pro where pro.pro_codigo = " + pro_codigo + " order by etp.etp_ordem").list();
        session.close();
        return list;
    }

}
