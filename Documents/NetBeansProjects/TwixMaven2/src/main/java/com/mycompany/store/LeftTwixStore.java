/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.store;

import com.mycompany.twix.LeftStickTwix;
import com.mycompany.twix.Twix;
import com.mycompany.twix.TwixV;

/**
 *
 * @author Dasha-RV515
 */
public class LeftTwixStore extends TwixStore {

    private static LeftTwixStore unique;

    public static LeftTwixStore getIntense() {
        if (unique == null) {
            unique = new LeftTwixStore();
        }
        return unique;
    }

    @Override
    protected Twix createTwix(String type) {
      TwixV ob=new TwixV();
        if (type.equals(ob.lt)) {
            return new LeftStickTwix();
        } else {
            return null;
        }
    }
}
