package global.goit.services;

import global.goit.entities.Client;
import global.goit.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.Transaction;

public class ClientCrudService {

    public void createClient(Client client) {
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(client);
            transaction.commit();
        } catch (SessionException e) {
            throw new RuntimeException();
        }
    }

    public void deleteClient(int clientId) {
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createQuery("delete from Client WHERE id= :client_id")
                    .setParameter("client_id", clientId)
                    .executeUpdate();
            transaction.commit();
        } catch (SessionException e) {
            throw new RuntimeException();
        }
    }
}
