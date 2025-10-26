package com.bus.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.bus.entity.Ticket;
import com.bus.util.HibernateUtil;

public class TicketDAO {
    public void bookTicket(Ticket ticket) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(ticket);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    // ✅ Get all tickets
    public List<Ticket> getAllTickets() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Ticket", Ticket.class).list();
        }
    }
}
