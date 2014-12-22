/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.store;

import com.mycompany.twix.RightStickTwix;
import com.mycompany.twix.Twix;
import com.mycompany.twix.TwixV;

/**
 *
 * @author Dasha-RV515
 */
public class RightTwixStore extends TwixStore {//реализация . метода createTwix абстрактного класса TwixStore

    private static RightTwixStore unique;

    private RightTwixStore() {

    }

    public static RightTwixStore getIntense() {
        if (unique == null) {
            unique = new RightTwixStore();
        }
        return unique;
    }

    @Override
    protected Twix createTwix(String type) {
        TwixV ob=new TwixV();
        if (type.equals(ob.rt)) {
            return new RightStickTwix();

        } else {
            return null;
        }
    }
}
