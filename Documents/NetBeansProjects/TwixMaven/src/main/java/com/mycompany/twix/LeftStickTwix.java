/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.twix;

/**
 *
 * @author Dasha-RV515
 */
public class LeftStickTwix extends Twix {

    public LeftStickTwix() {//левая полочка готовится с темным шокол.
        name = "Left Sticks Twix";
        chocol = "dark chocolate";
        caramel = "fondant caramel ";
        cake = " shortbread";
        toppings.add(" Milk");
    }

    @Override
    public String toString() {
        String str = new String();
        str = super.toString() + ": " + "From TOP to Bottom";
        return str;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof LeftStickTwix) {
            LeftStickTwix temp = (LeftStickTwix) obj;
            return this.cake == temp.cake
                    && this.chocol.equals(temp.chocol)
                    && this.name.equals(temp.name)
                    && this.caramel.equals(temp.caramel);
        } else {
            return false;
        }
    }

    public void poured() {//переопределяем метод покрытия карамели
        System.out.println("Pour on cookie caramel from top to bottom");
    }

    public void box() {//переопредел. метод упаковки
        System.out.println("Place twix in official TwixStore box for the LeftStick");
    }

}
