package uk.co.gnosis.smokingun;

import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom; // Better for ranges

public class SmokingGun {
    public static void main(String[] args) {
        // Phase 1: The Technical Hardware Boot
        System.out.println("--- INITIALIZING GNOSIS BALLISTICS KERNEL ---");
        for (int i = 0; i <= 100; i += 5) {
            LoadingBar.updateProgress(5);
            try {
                Thread.sleep(100); // Simulate "heavy" loading
            } catch (InterruptedException e) {
            }
        }
        System.out.println("\n[SYSTEM] KERNEL ONLINE.\n");

        // Phase 2: The "Chet Pussy" Welcome
        Typewriter.write("WELCOME TO THE SMOKING GUN RANGE!", 40);
        Typewriter.wait(500);

        Typewriter.write("Step right up, bullet-lovers!", 30);
        Typewriter.write("We got 9mm, .45 ACP, .357 Magnum, .50 Caliber...", 25);
        Typewriter.write("We got jacketed bullets, hollow point bullets, tracer bullets, armor-piercing bullets!", 20);

        System.out.print("WE GOT CHICKEN ");
        Typewriter.write("BUUUULLLLLLLEEEETTTTTTSSSSSSS!!!!", 150);

        Typewriter.wait(800);
        Typewriter.write("\nIF WE DON'T HAVE IT, YOU DON'T NEED TO SHOOT IT!", 50);

        // Phase 3: Start the Range
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
