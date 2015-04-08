/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daofactory;

import entity.Client;
import entity.Contract;
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
public class TarifPlanDAO extends AbstractDAO<TarifPlan> {

    /* private final Connection connection;
     private final String  sqlc= "INSERT INTO tarifplan " + "VALUES (?, ?, ?,?,?)";
     private final  String sqlr = "SELECT * FROM tarifplan WHERE idTarif = ?";
     private final String sqlu = "UPDATE tarifplan SET nameTarif=?, trafic=? ,speed=? ,price=?  WHERE idTarif=?";
     private final   String sqld = "DELETE FROM tarifplan WHERE idTarif = ?";
     private final String sqlAll = "SELECT * FROM tarifplan";*/
    @Override
    public int create(TarifPlan ob) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer idTarif = null;
        try {
            tx = session.beginTransaction();
//            TarifPlan t = new TarifPlan();
//            t.setId(ob.getId());
//            t.setNameTarif(ob.getNameTarif());
//            t.setTrafic(ob.getTrafic());
//            t.setSpeed(ob.getSpeed());
//            t.setPrice(ob.getPrice());
//            // t.setContract(ob.getContract());
            idTarif = (Integer) session.save(ob);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return idTarif;
    }

    @Override
    public TarifPlan read(int key) throws SQLException {

        Session session = null;
        TarifPlan t = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            t = (TarifPlan) session.load(TarifPlan.class, key);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return t;
    }

    @Override
    public void update(TarifPlan ob) throws SQLException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            TarifPlan t = (TarifPlan) session.get(TarifPlan.class, ob.getId());
            t.setNameTarif(ob.getNameTarif());
            t.setTrafic(ob.getTrafic());
            t.setSpeed(ob.getSpeed());
            t.setPrice(ob.getPrice());

            session.update(t);
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
            TarifPlan tarif
                    = (TarifPlan) session.get(TarifPlan.class, key);
            session.delete(tarif);
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
    public List<TarifPlan> getInfo() throws SQLException {
        Session session = null;
        List tarif = new ArrayList<TarifPlan>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tarif = session.createCriteria(TarifPlan.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'getAll'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return tarif;
    }

   // public TarifPlanDAO(Connection connection) {
    //   this.connection = connection;
    //}
    @Override
    public Collection getContractBy(Client ob) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
