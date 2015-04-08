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
public class Service extends Entity {

    private String descripService;
    private double priceService;
    private String note;

    public Service() {
    }

    public Service(int id, String descripService, double priceService, String note) {
        super(id);
        this.descripService = descripService;
        this.priceService= priceService;
        this. note=  note;
    }

    public String getDescripService() {
        return descripService;
    }

    public void setDescripService(String descripService) {
        this.descripService = descripService;
    }

    public double getPriceService() {
        return  priceService;
    }

    public void setPriceService(double priceServicet) {
        this. priceService =  priceService;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Service{" + "descripService=" + descripService + ", priceService=" + priceService + ", note=" + note + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.descripService);
        hash = 73 * hash + (int) (Double.doubleToLongBits(this.priceService) ^ (Double.doubleToLongBits(this.priceService) >>> 32));
        hash = 73 * hash + Objects.hashCode(this.note);
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
        final Service other = (Service) obj;
        if (!Objects.equals(this.descripService, other.descripService)) {
            return false;
        }
        if (Double.doubleToLongBits(this.priceService) != Double.doubleToLongBits(other.priceService)) {
            return false;
        }
        if (!Objects.equals(this.note, other.note)) {
            return false;
        }
        return true;
    }

   
}
