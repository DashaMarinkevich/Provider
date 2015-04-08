/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package daofactory;

import entity.Client;
import entity.Contract;
import entity.Contract_Service;
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
    public class Contract_ServiceDAO   extends AbstractDAO<Contract_Service> {

   /* private final Connection connection;
 private final String  sqlc= "INSERT INTO contract_service " + "VALUES (?, ?)";
  private final  String sqlr = "SELECT * FROM contract_service WHERE numContract = ?";
   private final String sqlu = "UPDATE contract_service SET idService=?  WHERE numContract=?";
 private final   String sqld = "DELETE FROM contract_service WHERE numContract = ?";
 private final String sqlAll = "SELECT * FROM contract_service";*/
    @Override
    public int create(Contract_Service ob) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer numContract = null;
        try {
            tx = session.beginTransaction();
           Contract_Service c = new Contract_Service();
            c.setId(ob.getId());
            c.setIdService(ob.getIdService());
            numContract = (Integer) session.save(c);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return numContract;
    }

    @Override
    public Contract_Service read(int key) throws SQLException {
       
        Session session = null;
        Contract_Service c = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            c= (Contract_Service) session.load(Contract_Service.class, key);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return c;
    }

    @Override
    public void update(Contract_Service ob) throws SQLException {
       Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Contract_Service c= (Contract_Service) session.get(Contract_Service.class, ob.getId());
            c.setIdService(ob.getIdService());
            session.update(c);
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
                Contract_Service c
                        = ( Contract_Service) session.get( Contract_Service.class, key);
                session.delete(c);
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
    public List<Contract_Service> getInfo() throws SQLException {
        
        Session session = null;
        List c = new ArrayList<Contract_Service>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            c = session.createCriteria(Contract_Service.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'getAll'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return c;
    }

    @Override
    public Collection getContractBy(Client ob) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }

   // public Contract_ServiceDAO(Connection connection) {
     //   this.connection = connection;
   // }
   

