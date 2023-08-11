package global.goit.services;

import global.goit.entities.Client;
import global.goit.entities.Planet;
import global.goit.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.Transaction;

public class PlanetCrudService {

    public void createPlanet(Planet planet) {
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(planet);
            transaction.commit();
        } catch (SessionException e) {
            throw new RuntimeException();
        }
    }

    public void deletePlanet(String planetId) {
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createQuery("delete from Planet WHERE id= :planet_id")
                    .setParameter("planet_id", planetId)
                    .executeUpdate();
            transaction.commit();
        } catch (SessionException e) {
            throw new RuntimeException();
        }
    }
}
