/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author Dasha-RV515
 */
public class Pays extends Entity {

    private double sumPay;
    private String datePay;
    private Client client;
     private Pays pays;
    //private Set personalAccount;

    public Pays() {
    }

    public Pays(int id, double sumPay, String datePay,Client client) {
        super(id);
        this.sumPay = sumPay;
        this.datePay = datePay;
        this.client = client;
    }

    public double getSumPay() {
        return sumPay;
    }

    public void setSumPay(double sumPay) {
        this.sumPay = sumPay;
    }

    public String getDatePay() {
        return datePay;
    }

    public void setDatePay(String datePay) {
        this.datePay = datePay;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

//    public void setPersonalAccount(Set personalAccount) {
//        this.personalAccount = personalAccount;
//    }
//
//    public Set getPersonalAccount() {
//        return personalAccount;
    //}

    @Override
    public String toString() {
        return "Pays{" + "sumPay=" + sumPay + ", datePay=" + datePay +  '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.sumPay) ^ (Double.doubleToLongBits(this.sumPay) >>> 32));
        hash = 59 * hash + Objects.hashCode(this.datePay);
      // hash = 59 * hash + this.idClient;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pays other = (Pays) obj;
        if (Double.doubleToLongBits(this.sumPay) != Double.doubleToLongBits(other.sumPay)) {
            return false;
        }
        if (!Objects.equals(this.datePay, other.datePay)) {
            return false;
        }
//        if (this.idClient != other.idClient) {
//            return false;
//        }
        return true;
    }

}
