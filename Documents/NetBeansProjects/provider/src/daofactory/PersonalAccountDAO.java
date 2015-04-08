/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package daofactory;

import entity.Client;
import entity.PersonalAccount;
import entity.Service;
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
    public class PersonalAccountDAO   extends AbstractDAO<PersonalAccount> {

   /* private final Connection connection;
 private final String  sqlc= "INSERT INTO personalaccount " + "VALUES (?, ?, ?)";
  private final  String sqlr = "SELECT * FROM personalaccount WHERE numPersAccount = ?";
   private final String sqlu = "UPDATE personalaccount SET numPay=?,statusPersAccount=? WHERE numPersAccount=?";
 private final   String sqld = "DELETE FROM personalaccount WHERE numPersAccount = ?";
 private final String sqlAll = "SELECT * FROM personalaccount";*/
    @Override
    public int create(PersonalAccount ob) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer numPersAccount = null;
        try {
            tx = session.beginTransaction();
          PersonalAccount p = new PersonalAccount();
            p.setId(ob.getId());
            
           p.setStatusPersAccount(ob.getStatusPersAccount());
            numPersAccount = (Integer) session.save(p);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return numPersAccount;
    }

    @Override
    public PersonalAccount read(int key) throws SQLException {
       
       Session session = null;
       PersonalAccount p= null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            p= (PersonalAccount) session.load(PersonalAccount.class, key);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return p;
    }

    @Override
    public void update(PersonalAccount ob) throws SQLException {
       
         Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            PersonalAccount p= (PersonalAccount) session.get(PersonalAccount.class, ob.getId());
         
           p.setStatusPersAccount(ob.getStatusPersAccount());
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
                PersonalAccount p
                        = (PersonalAccount) session.get(PersonalAccount.class, key);
                session.delete(p);
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
    public List<PersonalAccount> getInfo() throws SQLException {
        
       Session session = null;
        List p = new ArrayList<PersonalAccount>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            p = session.createCriteria(PersonalAccount.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'getAll'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return p;
    }

   // public PersonalAccountDAO(Connection connection) {
    //    this.connection = connection;
   // }

    @Override
    public Collection getContractBy(Client ob)  throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
