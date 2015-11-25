package br.com.sotos.DAO;

/**
 *
 * @author Augusto
 */
import br.com.sotos.model.DrEtapaProducao;
import java.util.List;
import org.hibernate.Session;

public class DrEtapaProducaoDAO extends DAO<DrEtapaProducao> {

    public DrEtapaProducaoDAO(Class<DrEtapaProducao> typeClass) {
        super(typeClass);
    }
    
    public List<DrEtapaProducao> findByOrdCodigo(int ord_codigo) {
        Session session = super.getSession();
        List<DrEtapaProducao> list = session.createQuery("from DrEtapaProducao epp inner join fetch epp.drOrdemProducao ord inner join fetch epp.drEtapasProduto etp where ord.ord_codigo = " + ord_codigo + " order by etp.etp_ordem").list();
        session.close();
        return list;
    }
}
