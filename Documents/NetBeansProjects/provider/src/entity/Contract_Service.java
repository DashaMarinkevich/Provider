/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Dasha-RV515
 */
public class Contract_Service extends Entity {

    private int idService;

    public Contract_Service() {
    }

    public Contract_Service(int id, int idService) {
        super(id);
        this.idService =  idService;
  
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    @Override
    public String toString() {
        return "Contract_Service{" + "idService=" + idService + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.idService;
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
        final Contract_Service other = (Contract_Service) obj;
        if (this.idService != other.idService) {
            return false;
        }
        return true;
    }

   
}
