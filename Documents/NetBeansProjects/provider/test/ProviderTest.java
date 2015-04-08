/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import daofactory.ClientDAO;
import daofactory.DAOFactory;
import daofactory.PaysDAO;
import daofactory.TarifPlanDAO;
import entity.Client;
import entity.Contract;
import entity.Pays;
import entity.TarifPlan;
import java.io.File;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author Dasha-RV515
 */
public class ProviderTest {
    
    private static Configuration config;
    private static SessionFactory factory;
    private static Session hibernateSession;
    private static Client cli = new Client();
    private static ClientDAO cl = DAOFactory.getInstance().getClientDAO();
     private static PaysDAO ps = DAOFactory.getInstance().getPaysDAO();
     private static Pays pays = new Pays(); 
     TarifPlanDAO t = DAOFactory.getInstance().getTarifPlanDAO();
    static int cl1 = 0;
int p1=0;
    @Before
    public void init() {
        config = new Configuration();
        config.configure();
        factory = config.buildSessionFactory();
        hibernateSession = factory.openSession();
    }

    @Test
    public void createClient() throws SQLException {
        String fullName = "Ivanov Petr";
        String seriaPassport = "PR";
        int numPassport = 1203;
        String adress = "Visokaya 5";
        String email = "pert@";
        String login="user6";
        int password=110;
        Client cli = new Client(1, fullName, seriaPassport, numPassport, adress, email,login,password);
        cl1 = cl.create(cli);
        List<Client> client = DAOFactory.getInstance().getClientDAO().getInfo();
        assertEquals(cl1, cli.getId());
    }
@Test
    public void createPays() throws SQLException {
       double sumPay =1220;
        String datePay = "11.10.2012";
        String fullName = "Ivanov Ivan";
        String seriaPassport = "PB";
        int numPassport = 1203;
        String adress = "Visokaya  25";
        String email = "p0rt@";
         String login="user7";
        int password=111;
        Client clip = new Client(2, fullName, seriaPassport, numPassport, adress, email,login,password);
        Pays p = new Pays(1, sumPay,datePay,clip);
         p1= ps.create(p);
        assertEquals(p1,p.getId());
    }
    @Test
    public void updateClient() throws SQLException {
        Client cli = new Client(2, "Oleg", "LM", 1234, "Berlin", "E-MailUdp","user8",121);
        cl.update(cli);
        List<Client> client = DAOFactory.getInstance().getClientDAO().getInfo();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>" + cli.toString());
        Assert.assertEquals(cli.getFullName(), "Oleg");
        Assert.assertEquals(cli.getEmail(), "E-MailUdp");
        Assert.assertTrue(cli.getId() > 0);
    }


    
  @Test(expected = AssertionError.class)
    public void addWithException() throws AssertionError {
        assertSame(new Pays(4,120,"12.02.2001",cli), cli.getPays());
    }
   
    @Test(expected = Exception.class)
public void deleteClient() throws Exception {
        cl.delete(cl1);
        List<Client> client = DAOFactory.getInstance().getClientDAO().getInfo();
        assertSame(client.get(cl1).getId(), cli.getId());
    }

@Test
    public void deletePays() throws SQLException {
        List<Pays> p = DAOFactory.getInstance().getPaysDAO().getInfo();
             int k=p.size();
              Client clip = new Client(3, "sdgsdgs", "sd",1205,"sdgsd","sdgsdhhs","user9",431);
        Pays ps2 = new Pays(2,25000,"23.04.2010",clip);
         int p2= ps.create(ps2);
        ps.delete(p2);
        p = DAOFactory.getInstance().getPaysDAO().getInfo();
             int l=p.size();
        Assert.assertTrue(k==l);
    }
        @Test
    public void listEquality() throws SQLException {
 TarifPlan tar1=new TarifPlan(5, "Domosed Optumum", 260, 540, 11400);
 TarifPlan tar2=new TarifPlan(5,  "Domosed Optumum", 260, 540, 11400);
        assertEquals(tar1,tar2);
    }
     @Test
    public void createUpdateTarif() throws SQLException {
        TarifPlan tarif = new TarifPlan(2, "Optimum",  1234,121,129);
         int t1 = t.create(tarif);
        t.update(tarif);;
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>" + t.toString());
        Assert.assertEquals(tarif.getNameTarif(), "Optimum");
        Assert.assertEquals(tarif.getTrafic(), 1234);
        Assert.assertTrue(tarif.getId() > 0);
    }
    @Test
    public void deleteTarifPlan() throws SQLException {
        List<TarifPlan> p = DAOFactory.getInstance().getTarifPlanDAO().getInfo();
             int k=p.size();
              TarifPlan tp = new TarifPlan(3, "sdgsdgs", 1205,431,123400);
         int t2= t.create(tp);
        t.delete(t2);
       p = DAOFactory.getInstance().getTarifPlanDAO().getInfo();
             int l=p.size();
        Assert.assertFalse(k!=l);
    }
}
