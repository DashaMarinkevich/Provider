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
public class TarifPlan extends Entity {

    private String nameTarif;
    private int trafic;
    private double speed;
    private double price;
 //private Set<Contract> contract = new HashSet();
    public TarifPlan() {
    }
public TarifPlan(int id, String nameTarif, int trafic, double speed, double price) {
        super(id);
        this.nameTarif = nameTarif;
        this.trafic = trafic;
        this.speed = speed;
        this.price = price;
        //this.contract=contract;
             
    }
   

    public String getNameTarif() {
        return nameTarif;
    }

    public void setNameTarif(String nameTarif) {
        this.nameTarif = nameTarif;
    }

    public int getTrafic() {
        return trafic;
    }

    public void setTrafic(int trafic) {
        this.trafic = trafic;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
//public void setContract(Set contract) {
//    this.contract = contract;
//  }
// 
//  public Set getContract() {
//    return contract;
//  }
    @Override
    public String toString() {
        return "TarifPlan{" + "nameTarif=" + nameTarif + ", trafic=" + trafic + ", speed=" + speed + ", price=" + price + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.nameTarif);
        hash = 37 * hash + this.trafic;
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.speed) ^ (Double.doubleToLongBits(this.speed) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
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
        final TarifPlan other = (TarifPlan) obj;
        if (!Objects.equals(this.nameTarif, other.nameTarif)) {
            return false;
        }
        if (this.trafic != other.trafic) {
            return false;
        }
        if (Double.doubleToLongBits(this.speed) != Double.doubleToLongBits(other.speed)) {
            return false;
        }
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        return true;
    }

    

}
