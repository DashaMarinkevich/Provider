/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daofactory;

import entity.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Dasha-RV515
 */
public class ClientDAO extends AbstractDAO<Client> {

    @Override
    public int create(Client client) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer idClient = null;
        try {
            tx = session.beginTransaction();
//            Client cl = new Client();
//            cl.setFullName(client.getFullName());
//            cl.setSeriaPassport(client.getSeriaPassport());
//            cl.setNumPassport(client.getNumPassport());
//            cl.setAdress(client.getAdress());
//            cl.setEmail(client.getEmail());
       //   cl.setContract(client.getContract());
            //cl.setPays(client.getPays());
            idClient = (Integer) session.save(client);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return idClient;
    }

    @Override
    public Client read(int key) throws SQLException {

        Session session = null;
        Client client = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            client = (Client) session.load(Client.class, key);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return client;
    }

    @Override
    public void update(Client client) throws SQLException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Client cl = (Client) session.get(Client.class, client.getId());
//            cl.setFullName(client.getFullName());
//            cl.setSeriaPassport(client.getSeriaPassport());
//            cl.setNumPassport(client.getNumPassport());
//            cl.setAdress(client.getAdress());
//            cl.setEmail(client.getEmail());
            //cl.setContract(client.getContract());
            // cl.setPays(client.getPays());
            session.update(cl);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(int key) throws SQLException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Client client
                    = (Client) session.get(Client.class, key);
            session.delete(client);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Client> getInfo() throws SQLException {

        Session session = null;
        List client = new ArrayList<Client>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            client = session.createQuery("FROM Client").list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'getAll'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return client;
    }

   // public ClientDAO(Connection connection) {
    //   this.connection = connection;
    //}
    @Override
    public Collection getContractBy(Client ob) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
