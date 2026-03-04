package uk.co.gnosis.smokingun;

import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom; // Better for ranges

public class SmokingGun {
    public static void main(String[] args) {
        RangeController range = new RangeController();
        range.startSession();
    }

    // UPDATED: Now passes gun specs to the mag
    public static void fillMag(Magazine m, String caliber, float min, float max) {
        if (m.isFull()) {
            System.out.println("Mag is already full!");
        } else {
            System.out.println("Loading " + caliber + " rounds into mag...");
            while (!m.isFull()) {
                m.addBullet(caliber, min, max);
            }
            System.out.println("Mag is now full with " + m.getCount() + " rounds!");
        }
    }

}
