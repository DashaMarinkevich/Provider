/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package daofactory;


import entity.Client;
import entity.Contract;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Dasha-RV515
 */
    public class ContractDAO extends AbstractDAO <Contract> {

   /* private final Connection connection;
 private final String  sqlc= "INSERT INTO contract " + "VALUES (?, ?, ?,?,?,?);";
  private final  String sqlr = "SELECT * FROM contract WHERE numContract = ?";
   private final String sqlu = "UPDATE contract SET dateContract=?, statusContract=? ,idClient=? ,numPersAccount=?,idTarif=? WHERE numContract=?";
 private final   String sqld = "DELETE FROM contract WHERE numContract = ?";
 private final String sqlAll = "SELECT * FROM contract";

    public ContractDAO(Connection connection) {
        this.connection = connection;
    }
   */

    @Override
    public int create(Contract ob) throws SQLException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer numContract = null;
        try {
            tx = session.beginTransaction();
           Contract c = new Contract();
            c.setId(ob.getId());
            c.setDateContract(ob.getDateContract());
            c.setStatusContract(ob.getStatusContract());
//            c.setIdClient(ob.getIdClient());
//             c.setNumPersAccount(ob.getNumPersAccount());
//            c.setIdTarif(ob.getIdTarif());
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
    public Contract read(int key) throws SQLException {
        Session session = null;
        Contract contract = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            contract = (Contract) session.load(Contract.class, key);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return contract;
    }

    @Override
    public void update(Contract ob) throws SQLException {
          Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Contract c= (Contract) session.get(Contract.class, ob.getId());
            c.setDateContract(ob.getDateContract());
            c.setStatusContract(ob.getStatusContract());
//            c.setIdClient(ob.getIdClient());
//             c.setNumPersAccount(ob.getNumPersAccount());
//            c.setIdTarif(ob.getIdTarif());
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
                Contract contract
                        = (Contract) session.get(Contract.class, key);
                session.delete(contract);
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
    public List<Contract> getInfo() throws SQLException {
        Session session = null;
        List contract = new ArrayList<Contract>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            contract = session.createCriteria(Contract.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'getAll'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return contract;
    }
      public Collection getContractBy(Client ob)throws SQLException {
    Session session = null;
    List contracts = new ArrayList<Contract>();
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      int idClient = ob.getId();
      Query query = session.createQuery("from Contract where idClient = :idClient ").setInteger("idClient", idClient);
      contracts = (List<Contract>) query.list();
      session.getTransaction().commit();

    } finally {
      if (session != null && session.isOpen()) {
        session.close();
      }
    }
    return contracts;
  }

}
