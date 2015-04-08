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
public class Contract extends Entity {

    private String dateContract;
    private String statusContract;
//    private int numPersAccount;
//    private int idClient;
//    private int idTarif;

    public Contract() {
    }

    public Contract(int id, String dateContract, String statusContract) {
        super(id);
        this.dateContract = dateContract;
        this.statusContract = statusContract;
//        this.numPersAccount = numPersAccount;
//        this.idClient = idClient;
//        this.idTarif= idTarif;
    }

    public String getDateContract() {
        return dateContract;
    }

    public void setDateContract(String dateContract) {
        this.dateContract = dateContract;
    }

    public String getStatusContract() {
        return statusContract;
    }

    public void setStatusContract(String statusContract) {
        this.statusContract = statusContract;
    }

//    public int getNumPersAccount() {
//        return numPersAccount;
//    }
//
//    public void setNumPersAccount(int numPersAccount) {
//        this.numPersAccount = numPersAccount;
//    }
// public int getIdClient() {
//        return idClient;
//    }
//
//    public void setIdClient(int idClient) {
//        this.idClient = idClient;
//    }
//     public int getIdTarif() {
//        return idTarif;
//    }
//
//    public void setIdTarif(int idTarif) {
//        this.idTarif = idTarif;
//    }
    @Override
    public String toString() {
        return "Contract{" + "dateContract=" + dateContract + ", statusContract=" + statusContract + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.dateContract);
        hash = 61 * hash + Objects.hashCode(this.statusContract);
//        hash = 61 * hash + this.numPersAccount;
//        hash = 61 * hash + this.idClient;
//        hash = 61 * hash + this.idTarif;
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
        final Contract other = (Contract) obj;
        if (!Objects.equals(this.dateContract, other.dateContract)) {
            return false;
        }
        if (!Objects.equals(this.statusContract, other.statusContract)) {
            return false;
        }
//        if (this.numPersAccount != other.numPersAccount) {
//            return false;
//        }
//        if (this.idClient != other.idClient) {
//            return false;
//        }
//        if (this.idTarif != other.idTarif) {
//            return false;
//        }
        return true;
    }

}
