package uk.co.gnosis.smokingun;

import java.util.Random;

abstract class Gun {
    String name;
    String caliber;
    float minDmg;
    float maxDmg;
    int magSize;
    float jamChance; // Custom jam chance per gun!

    Magazine loaded;
    boolean isJammed = false;
    protected static Random rng = new Random();

    // The constructor now takes all the specs from the "Child" class
    public Gun(String name, String caliber, int magSize, float min, float max, float jamChance) {
        this.name = name;
        this.caliber = caliber;
        this.magSize = magSize;
        this.minDmg = min;
        this.maxDmg = max;
        this.jamChance = jamChance;

        // Start with a random amount of ammo based on the specific gun's mag size
        int randomAmmo = rng.nextInt(magSize + 1);
        loaded = new Magazine(randomAmmo, caliber, minDmg, maxDmg, magSize);
    }

    public void fire() {
        if (isJammed) {
            System.out.println("!CLICK! " + name + " is jammed!");
            return;
        }
        if (rng.nextFloat() * 100 < jamChance) {
            isJammed = true;
            System.out.println("...CRUNCH... " + name + " jammed!");
            return;
        }
        if (loaded != null && !loaded.isEmpty()) {
            Bullet b = loaded.removeBullet();
            System.out.printf("[%s] BANG! %s dealt %.1f dmg.%n", name, b.caliber, b.damage);
        } else {
            System.out.println("*click* ... empty.");
        }
    }

    // ... (rest of Gun methods like rapidFire and clearJam remain the same)
    public void rapidFire() {
        if (isJammed) return;
        if (loaded != null) {
            while (!loaded.isEmpty() && !isJammed) { fire(); }
        }
    }

    public void clearJam() {
        isJammed = false;
        System.out.println("Cleared the chamber!");
    }

    public void ejectMag() {
        if (loaded != null) {
            System.out.println("Mag ejected!");
            loaded = null;
        }
    }

    public void loadGun(Magazine spareMag) {
        if (spareMag != null && !spareMag.isEmpty()) {
            loaded = spareMag;
            System.out.println("Gun loaded with " + loaded.getCount() + " rounds.");
        } else {
            System.out.println("No ammo to load!");
        }
    }
}
