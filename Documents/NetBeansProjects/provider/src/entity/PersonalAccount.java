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
public class PersonalAccount extends Entity {

    
    private String statusPersAccount;
    private Set<Contract> contract;

    public PersonalAccount() {
    }

    public PersonalAccount(int id,  String statusPersAccount, Set contract) {
        super(id);
        this.statusPersAccount = statusPersAccount;
        this.contract = contract;

    }

    

    public String getStatusPersAccount() {
        return statusPersAccount;
    }

    public void setStatusPersAccount(String statusPersAccount) {
        this.statusPersAccount = statusPersAccount;
    }

    public void setContract(Set contract) {
        this.contract = contract;
    }

    public Set getContract() {
        return contract;
    }

    @Override
    public String toString() {
        return "PersonalAccount{"  + ", statusPersAccount=" + statusPersAccount + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.statusPersAccount);
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
        final PersonalAccount other = (PersonalAccount) obj;
       
        if (!Objects.equals(this.statusPersAccount, other.statusPersAccount)) {
            return false;
        }
        return true;
    }

}
