package com.bus.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.bus.entity.Bus;
import com.bus.util.HibernateUtil;

public class BusDAO {
    public void saveBus(Bus bus) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(bus);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    // ✅ Get all buses
    public List<Bus> getAllBuses() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Bus", Bus.class).list();
        }
    }
}
