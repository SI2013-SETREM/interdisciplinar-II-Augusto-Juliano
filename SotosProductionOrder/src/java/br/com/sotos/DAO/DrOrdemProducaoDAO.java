package br.com.sotos.DAO;

import br.com.sotos.model.DrOrdemProducao;
import br.com.sotos.model.DrProduto;
import com.google.gson.JsonObject;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Augusto
 */
public class DrOrdemProducaoDAO extends DAO<DrOrdemProducao> {

    public DrOrdemProducaoDAO(Class<DrOrdemProducao> typeClass) {
        super(typeClass);
    }
    
    public void insertOrders(List<JsonObject> objects){
        Session session = super.getSession();
        Transaction t = session.beginTransaction();
        DrOrdemProducao drOrdemProducao = new DrOrdemProducao();
        drOrdemProducao.setOrd_datacadastro(new Date());
        //drOrdemProducao.setOrd_dataentrega(objects.get(0).get("ord_dataproducao"));
        
        for (JsonObject object : objects) {
            
            
            //TODO: Código cabuloso aqui...        
            
            //session.save(drOrdemProducao);
        }
        //t.commit();
        session.close();
    }

}
