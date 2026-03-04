package uk.co.gnosis.smokingun;

class Bullet {
    String caliber;
    float damage;
    float dX;
    float dY;

    // Constructor now accepts the randomized damage
    Bullet(String caliber, float damage) {
        this.caliber = caliber;
        this.damage = damage;
    }
}