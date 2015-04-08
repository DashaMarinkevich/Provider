/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package daofactory;

import entity.Client;
import entity.Service;
import entity.TarifPlan;
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
    public class ServiceDAO   extends AbstractDAO<Service> {

    

    /*private final Connection connection;
 private final String  sqlc= "INSERT INTO service " + "VALUES (?, ?, ?,?)";
  private final  String sqlr = "SELECT * FROM service WHERE idService = ?";
   private final String sqlu = "UPDATE service SET descripService=?, priceService=? ,note=?  WHERE idService=?";
 private final   String sqld = "DELETE FROM service WHERE idService = ?";
 private final String sqlAll = "SELECT * FROM service";*/
    @Override
    public int create(Service ob) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer idService = null;
        try {
            tx = session.beginTransaction();
          Service s = new Service();
            s.setId(ob.getId());
             s.setDescripService(ob.getDescripService());
            s.setPriceService(ob.getPriceService());
           s.setNote(ob.getNote());
            idService = (Integer) session.save(s);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return idService;
    }

    @Override
    public Service read(int key) throws SQLException {
       
        Session session = null;
        Service s= null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            s= (Service) session.load(Service.class, key);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return s;
    }

    @Override
    public void update(Service ob) throws SQLException {
       
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Service s= (Service) session.get(Service.class, ob.getId());
           s.setDescripService(ob.getDescripService());
            s.setPriceService(ob.getPriceService());
           s.setNote(ob.getNote());
            session.update(s);
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
                Service s 
                        = (Service) session.get(Service.class, key);
                session.delete(s);
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
    public List<Service> getInfo() throws SQLException {
        
        Session session = null;
        List s = new ArrayList<Service>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            s = session.createCriteria(Service.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'getAll'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return s;
    }

   // public ServiceDAO(Connection connection) {
     //   this.connection = connection;
    //}

    @Override
    public Collection getContractBy(Client ob)throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
