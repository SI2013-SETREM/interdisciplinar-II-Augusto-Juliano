package br.com.sotos.DAO;

import br.com.sotos.model.DrProdutoTamanho;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Augusto
 */
public class DrProdutoTamanhoDAO extends DAO<DrProdutoTamanho> {

    public DrProdutoTamanhoDAO(Class<DrProdutoTamanho> typeClass) {
        super(typeClass);
    }

    public List<DrProdutoTamanho> findByProCodigo(int pro_codigo) {
        Session session = super.getSession();
        List<DrProdutoTamanho> list = session.createQuery("from DrProdutoTamanho prt inner join fetch prt.drProduto pro where pro.pro_codigo = " + pro_codigo + " order by prt.prt_codigo").list();
        session.close();
        return list;
    }

}
