/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.twixmaven2;

import com.mycompany.twix.Twix;
import com.mycompany.store.TwixStore;
import com.mycompany.store.LeftTwixStore;
import com.mycompany.store.RightTwixStore;
import java.util.Random;

/**
 *
 * @author Dasha-RV515
 */
public class TwixTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TwixStore rStore = RightTwixStore.getIntense();//создаем фабрику для создания правой палочки
        TwixStore lStore = LeftTwixStore.getIntense();//создаем фабрику для создания левой палочки
        Random random = new Random();

        int u = Math.abs(random.nextInt()) % 2;//генерация палочек в пачке
        //System.out.println(u);
        if (u == 0) {
            Twix twix = rStore.orderTwix("Right_Sticks");//выполнения правых палочек
            System.out.println("The pack contains " + twix.getName());

        } else {
            Twix twix = lStore.orderTwix("Left_Sticks");//выполнения левых  палочек
            System.out.println("The pack contains " + twix.getName());

        }
    }

}
