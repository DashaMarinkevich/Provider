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
public class RightStickTwix extends Twix {//переопределяются методы абстрактного класса Twix

    public RightStickTwix() {//правая полочка готовится с молочным шокол.
        name = "Right Sticks Twix";
        chocol = "milk chocolate";
        caramel = "fondant caramel ";
        cake = " shortbread";
        time = 30;

    }

    @Override
    public String toString() {
        String str = new String();
        str = super.toString() + ": " + "Vertically";
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
        if (obj instanceof RightStickTwix) {
            RightStickTwix temp = (RightStickTwix) obj;
            return this.cake == temp.cake
                    && this.chocol.equals(temp.chocol)
                    && this.name.equals(temp.name)
                    && this.caramel.equals(temp.caramel);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.time;
        return hash;
    }

    public void poured() {//переопределяем метод покрытия карамели
        System.out.println("Pour on cookie caramel vertically");
    }

    public void box() {//переопредел. метод упаковки
        System.out.println("Place twix in official TwixStore box for the RightStick");
    }

}
