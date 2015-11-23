package br.com.sotos.DAO;

import br.com.sotos.model.DrProduto;
import br.com.sotos.model.DrProdutoCores;
import br.com.sotos.model.DrProdutoTamanho;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Augusto
 */
public class DrProdutoDAO extends DAO<DrProduto> {

    public DrProdutoDAO(Class<DrProduto> typeClass) {
        super(typeClass);
    }

    public List<DrProdutoCores> getCores(DrProduto drProduto) {
        Session session = super.getSession();
        List<DrProdutoCores> lstProdutoCores = session.createQuery("from DrProdutoCores prc inner join fetch prc.drProduto pro where pro.pro_codigo = " + drProduto.getPro_codigo()).list();
        session.close();
        return lstProdutoCores;
    }

    public List<DrProdutoTamanho> getTamanhos(DrProduto drProduto) {
        Session session = super.getSession();
        List<DrProdutoTamanho> lstProdutoTamanhos = session.createQuery("from DrProdutoTamanho prt inner join fetch prt.drProduto pro where pro.pro_codigo = " + drProduto.getPro_codigo()).list();
        session.close();
        return lstProdutoTamanhos;
    }
}
