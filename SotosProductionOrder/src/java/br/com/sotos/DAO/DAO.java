package br.com.sotos.DAO;

import br.com.sotos.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Augusto
 * @param <T>
 *
 */
public class DAO<T> {

    Class<T> typeClass;

    public DAO(Class<T> typeClass) {
        this.typeClass = typeClass;
    }

    private Session session;

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public void insert(T entity) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(entity);
        t.commit();
        session.close();
    }

    public void update(T entity) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.merge(entity);
        t.commit();
        session.close();
    }

    public void delete(T entity) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(entity);
        t.commit();
        session.close();
    }

    public T findById(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        T entity = (T) session.get(typeClass, id);
        session.close();
        return entity;
    }

    public List<T> findAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<T> list = session.createQuery("from " + typeClass.getSimpleName()).list();
        session.close();
        return list;
    }

    /**
     * Exemplo de Uso da DAO
     *
     * public String insert(){ DrCor d = new DrCor();
     * d.setCor_descricao("TESTE"); d.setCor_codigocor("asd");
     *
     * DAO<DrCor> dao = new DAO(DrCor.class); dao.insert(d); }
     *
     */
}
