/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.store;

import com.mycompany.twix.Twix;
import java.util.Iterator;

/**
 *
 * @author Dasha-RV515
 */
public abstract class TwixStore {

    public Twix orderTwix(String type) {//тип передается  orderTwix при вызове
        Twix twix;
        twix = createTwix(type);//обращаемся к фабрике с запросом на создание объкта(все подтипы должны реализовыв. этот метод)
        String s = twix.toString();
        System.out.println("Caramel poured on twix.." + s);
        boolean a = twix.equals(twix);
        if (a) {
            System.out.println("TWIX CREATE ON THE STORE");
        }
        twix.prepare();
        twix.bake();//выпекаем 
        twix.poured();//покрываем карамелью
        twix.cover();//шоколадом
        twix.box();//упаковываем
        return twix;//получаем обьект ецшч
    }

    protected abstract Twix createTwix(String type);//объект фабрики перем. в метод

}
