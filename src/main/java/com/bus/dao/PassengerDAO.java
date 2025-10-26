package com.bus.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.bus.entity.Passenger;
import com.bus.util.HibernateUtil;

public class PassengerDAO {
    public void savePassenger(Passenger passenger) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(passenger);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    // ✅ Get all passengers
    public List<Passenger> getAllPassengers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Passenger", Passenger.class).list();
        }
    }
}
