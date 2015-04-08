package daofactory;

import entity.Client;
import entity.Entity;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dasha-RV515
 */
public abstract class AbstractDAO <T extends Entity>{
    public abstract int create(T ob) throws SQLException;
    
    public abstract T read(int key) throws SQLException;
    
    public abstract void update(T ob) throws SQLException;
    
    public abstract void delete(int key) throws SQLException;
    
    public abstract List<T> getInfo() throws SQLException;
      public abstract Collection getContractBy(Client ob) throws SQLException;
}

