package br.com.sotos.DAO;

/**
 *
 * @author Augusto
 */
import br.com.sotos.model.DrCor;
import java.util.List;
import org.hibernate.Session;

public class DrCorDAO extends DAO<DrCor> {

    public DrCorDAO(Class<DrCor> typeClass) {
        super(typeClass);
    }
    
    public List<DrCor> findByProCodigo(int pro_codigo){
        Session session = super.getSession();
        List<DrCor> drCorLst = session.createQuery("select prc.drCor from DrProdutoCores prc inner join prc.drProduto pro where pro.pro_codigo = " + pro_codigo).list();
        session.close();
        return drCorLst;
    }
}
