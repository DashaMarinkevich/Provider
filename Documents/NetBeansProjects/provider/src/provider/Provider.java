/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provider;

import daofactory.ClientDAO;
import daofactory.ContractDAO;
import daofactory.DAOFactory;
import daofactory.PaysDAO;
import daofactory.TarifPlanDAO;
import entity.Client;
import entity.Contract;
import entity.Pays;
import entity.PersonalAccount;
import entity.TarifPlan;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Dasha-RV515
 */
public class Provider {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        List<Client> client = DAOFactory.getInstance().getClientDAO().getInfo();
        System.out.println("========Все клиенты=========");
        for (int i = 0; i < client.size(); ++i) {
            System.out.println("ИМя клиента : " + client.get(i).getFullName() + ", Сериа пасспорта : " + client.get(i).getSeriaPassport() + ",  Номер  : " + client.get(i).getNumPassport() + ",  Адрес : " + client.get(i).getAdress() + ",  Email : " + client.get(i).getEmail()+ ",  Login : " + client.get(i).getLogin());
            System.out.println("=============================");
        }
        List<Pays> pays = DAOFactory.getInstance().getPaysDAO().getInfo();
        System.out.println("========Все платежи=========");
        for (int i = 0; i < pays.size(); ++i) {
            System.out.println("Номер платежа : " + pays.get(i).getId() + ",Cумма : " + pays.get(i).getSumPay() + ",  Дата : " + pays.get(i).getDatePay());
            System.out.println("=============================");
        }
        Client cl=new Client(4,"weqw","ss",12,"sdsdhs","sdgsdhsdf","user4",120);
        int c1=DAOFactory.getInstance().getClientDAO().create(cl);
        Pays p1=new Pays(4,120,"12.02.2001",cl);
        int p=DAOFactory.getInstance().getPaysDAO().create(p1);
        pays = DAOFactory.getInstance().getPaysDAO().getInfo();
        System.out.println("========Все платежи=========");
       for (Iterator iterator =pays.iterator(); iterator.hasNext();){
            Pays pay = (Pays) iterator.next(); 
            System.out.println("Num pays: " + pay.getId() + " Date pays: " + pay.getDatePay() + " Sum pays: " + pay.getSumPay());
            System.out.println("=============================");
    Client c = pay.getClient();
           System.out.println("Клиент : " + c.getId());
        }
        ClientDAO c=new ClientDAO();
       PaysDAO pd=new PaysDAO();
        c.update(new Client(c1,"weqw","ss",36,"sdsdhs","ssssssssss","user5",121));
        pd.update(new Pays(p,240,"12.02.2001",cl));
        c.delete(c1);
//        List<PersonalAccount> peraccount = DAOFactory.getInstance().getPersonalAccountDAO().getInfo();
//        System.out.println("========Все лиц счета=========");
//        for (int i = 0; i < peraccount.size(); ++i) {
//            System.out.println("Номер  : " + peraccount.get(i).getId() + ",Cтатус : " + peraccount.get(i).getStatusPersAccount());
//            System.out.println("=============================");
//        }
        List<TarifPlan> tarifPlan = DAOFactory.getInstance().getTarifPlanDAO().getInfo();
        System.out.println("========Все тарифы=========");
        for (int i = 0; i < tarifPlan.size(); ++i) {
            System.out.println("Номер  : " + tarifPlan.get(i).getId() + ",Имя : " + tarifPlan.get(i).getNameTarif() + ",Стоимиость : " + tarifPlan.get(i).getPrice() + ",Трафик : " + tarifPlan.get(i).getTrafic() + ",Скорость : " + tarifPlan.get(i).getSpeed());
            System.out.println("=============================");
        }
        Collection clients = DAOFactory.getInstance().getClientDAO().getInfo();
        Iterator iterator = clients.iterator();
        System.out.println("========Все клиенты=========");
        while (iterator.hasNext()) {
            Client cli = (Client) iterator.next();
            System.out.println("FullName : " + cli.getFullName() + "  Passport : " + cli.getSeriaPassport() + "  " + cli.getNumPassport()+ ",  Login : " + cli.getLogin());
            Collection contracts = DAOFactory.getInstance().getContractDAO().getContractBy(cli);
            Iterator iterator2 = contracts.iterator();
            while (iterator2.hasNext()) {
                Contract contract = (Contract) iterator2.next();
                System.out.println("Договор № " + contract.getId() + "Договор Статус " + contract.getStatusContract());

            }
        }
                TarifPlanDAO t = DAOFactory.getInstance().getTarifPlanDAO();

        Integer t1 = t.create(new TarifPlan(3, "Domosed", 120, 230, 1200));
        Integer t2 = t.create(new TarifPlan(4, "Domosed 2", 240, 250, 2600));

        t.update(new TarifPlan(t2, "Domosed 2+2", 240, 250, 36000));
        tarifPlan = DAOFactory.getInstance().getTarifPlanDAO().getInfo();
        System.out.println("========Все тарифы=========");
        for (int i = 0; i < tarifPlan.size(); ++i) {
            System.out.println("Номер  : " + tarifPlan.get(i).getId() + ",Имя : " + tarifPlan.get(i).getNameTarif() + ",Стоимиость : " + tarifPlan.get(i).getPrice() + ",Трафик : " + tarifPlan.get(i).getTrafic() + ",Скорость : " + tarifPlan.get(i).getSpeed());
            System.out.println("=============================");
        }
        t.delete(t1);
        t.delete(t2);
         tarifPlan = DAOFactory.getInstance().getTarifPlanDAO().getInfo();
        System.out.println("========Все тарифы=========");
        for (int i = 0; i < tarifPlan.size(); ++i) {
            System.out.println("Номер  : " + tarifPlan.get(i).getId() + ",Имя : " + tarifPlan.get(i).getNameTarif() + ",Стоимиость : " + tarifPlan.get(i).getPrice() + ",Трафик : " + tarifPlan.get(i).getTrafic() + ",Скорость : " + tarifPlan.get(i).getSpeed());
            System.out.println("=============================");
        }
//        ClientDAO cl = DAOFactory.getInstance().getClientDAO();
//        TarifPlanDAO t = DAOFactory.getInstance().getTarifPlanDAO();
//
//        Integer t1 = t.create(new TarifPlan(3, "Domosed", 120, 230, 1200));
//        Integer t2 = t.create(new TarifPlan(4, "Domosed 2", 240, 250, 2600));
//
//        t.update(new TarifPlan(t2, "Domosed 2+2", 240, 250, 36000));
//        tarifPlan = DAOFactory.getInstance().getTarifPlanDAO().getInfo();
//        System.out.println("========Все тарифы=========");
//        for (int i = 0; i < tarifPlan.size(); ++i) {
//            System.out.println("Номер  : " + tarifPlan.get(i).getId() + ",Имя : " + tarifPlan.get(i).getNameTarif() + ",Стоимиость : " + tarifPlan.get(i).getPrice() + ",Трафик : " + tarifPlan.get(i).getTrafic() + ",Скорость : " + tarifPlan.get(i).getSpeed());
//            System.out.println("=============================");
//        }
//        t.delete(t1);
//        t.delete(t2);
//        Set<Pays> set1 = new HashSet();
//        set1.add(new Pays(4, 120, "11.01.2010"));
//        set1.add(new Pays(5, 230, "12.02.2011"));
//
//        Integer empID1 = cl.create(new Client(4, "segs sgsd", "VC", 12, "dsgd df s", "sdgs dsg ds", set1));
//
//        Set<Pays> set2 = new HashSet();
//        set2.add(new Pays(6, 134, "13.03.2010"));
//
//        Integer empID2 = cl.create(new Client(5, "ghf", "NC", 24, "xccx", "xbxcbxb", set2));
//
//        client = DAOFactory.getInstance().getClientDAO().getInfo();
//        System.out.println("========Все клиенты=========");
//        for (int i = 0; i < client.size(); ++i) {
//            System.out.println("ИМя клиента : " + client.get(i).getFullName() + ", Сериа пасспорта : " + client.get(i).getSeriaPassport() + ",  Номер  : " + client.get(i).getNumPassport() + ",  Адрес : " + client.get(i).getAdress() + ",  Email : " + client.get(i).getEmail());
//            System.out.println("=============================");
//
//            Set pay = client.get(i).getPays();
//            for (Iterator iterator2 = pay.iterator(); iterator2.hasNext();) {
//                Pays p = (Pays) iterator2.next();
//                System.out.println("Num pays: " + p.getId() + " Date pays: " + p.getDatePay() + " Sum pays: " + p.getSumPay());
//            }
//        }
//        cl.update(new Client(empID1, "ghf", "NC", 36, "xccx", "xbxcbxb", set1));
//
//        cl.delete(empID1);
//        cl.delete(empID2);
//
//        client = DAOFactory.getInstance().getClientDAO().getInfo();
//        System.out.println("========Все клиенты=========");
//        for (int i = 0; i < client.size(); ++i) {
//            System.out.println("ИМя клиента : " + client.get(i).getFullName() + ", Сериа пасспорта : " + client.get(i).getSeriaPassport() + ",  Номер  : " + client.get(i).getNumPassport() + ",  Адрес : " + client.get(i).getAdress() + ",  Email : " + client.get(i).getEmail());
//            System.out.println("=============================");
//
//            Set pay = client.get(i).getPays();
//            for (Iterator iterator2
//                    = pay.iterator(); iterator2.hasNext();) {
//                Pays p = (Pays) iterator2.next();
//                System.out.println("Num pays: " + p.getId() + " Date pays: " + p.getDatePay() + " Sum pays: " + p.getSumPay());
//            }
//        }

    }

}
