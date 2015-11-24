package br.com.sotos.DAO;

import br.com.sotos.model.DrTamanho;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Augusto
 */
public class DrTamanhoDAO extends DAO<DrTamanho> {

    public DrTamanhoDAO(Class<DrTamanho> typeClass) {
        super(typeClass);
    }
    
    public List<DrTamanho> findByProCodigo(int pro_codigo){
        Session session = super.getSession();
        List<DrTamanho> drTamanhoLst = session.createQuery("select prt.drTamanho from DrProdutoTamanho prt inner join prt.drProduto pro where pro.pro_codigo = " + pro_codigo).list();
        session.close();
        return drTamanhoLst;
    }

}
