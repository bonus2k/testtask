package com.space.util;

import com.space.model.Ship;
import com.space.model.ShipType;

import java.util.Date;

public class test {
    public static void main(String[] args) {
        Ship ship = new Ship();
        ship.setId(1L);
        ship.setName("First");
        ship.setPlanet("Mars");
        ship.setShipType(ShipType.MILITARY);
        ship.setProdDate(new Date());
        ship.setUsed(true);
        ship.setSpeed(32.2);
        ship.setCrewSize(11);
        ship.setRating(20.0);




        Ship ship1 = new Ship();
        ship1.setCrewSize(20);
        ship1.setId(10L);
        ship1.setName("First2");
        ship1.setPlanet(null);
        ship1.setProdDate(null);

        UtilForShips.copyNonNullProperties(ship1, ship);

        System.out.println(ship1);
        System.out.println(ship);

    }

}
