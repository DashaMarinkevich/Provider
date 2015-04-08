/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daofactory;

import entity.Client;
import entity.Pays;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class PaysDAO extends AbstractDAO<Pays> {

   /* private final Connection connection;
 private final String  sqlc= "INSERT INTO pays " + "VALUES (?, ?, ?,?);";
  private final  String sqlr = "SELECT * FROM pays WHERE numPay = ?;";
   private final String sqlu = "UPDATE pays SET  sumPay=? ,datePay=?,idClient=? WHERE numPay=?";
 private final   String sqld = "DELETE FROM pays WHERE numPay = ?;";
 private final String sqlAll = "SELECT * FROM pays";*/
    @Override
    public int create(Pays pays) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer numPay = null;
        try {
            tx = session.beginTransaction();
//            Pays p = new Pays();
//            p.setId(pays.getId());
//            p.setSumPay(pays.getSumPay());
//            p.setDatePay(pays.getDatePay());
//            p.setIdClient(pays.getIdClient());
            numPay = (Integer) session.save(pays);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return numPay;
    }

    @Override
    public Pays read(int key) throws SQLException {
        Session session = null;
        Pays pay = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            pay = (Pays) session.load(Pays.class, key);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return pay;
    }

    @Override
    public void update(Pays pays) throws SQLException {
         Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Pays p= (Pays ) session.get(Pays.class, pays.getId());
             p.setSumPay(pays.getSumPay());
            p.setDatePay(pays.getDatePay());
        p.setClient(pays.getClient());
            session.update(p);
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
                Pays pay
                        = (Pays) session.get(Pays.class, key);
                session.delete(pay);
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
    public List<Pays> getInfo() throws SQLException {
        Session session = null;
        List pay = new ArrayList<Pays>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            pay = session.createCriteria(Pays.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'getAll'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return pay;
    }

  // public PaysDAO(Connection connection) {
    //    this.connection = connection;
   // }

    @Override
    public Collection getContractBy(Client ob) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
