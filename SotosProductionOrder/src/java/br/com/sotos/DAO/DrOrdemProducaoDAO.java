package br.com.sotos.DAO;

import br.com.sotos.model.DrOrdemProducao;
import com.google.gson.JsonObject;
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
        for (JsonObject object : objects) {
            DrOrdemProducao drOrdemProducao = new DrOrdemProducao();
            
            //TODO: Código cabuloso aqui...        
            
            session.save(drOrdemProducao);
        }
        t.commit();
        session.close();
    }

}
