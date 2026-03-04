package uk.co.gnosis.smokingun;

import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

class Magazine {
    private Stack<Bullet> bullets = new Stack<>();
    private int capacity;

    public Magazine(int startingCount, String caliber, float min, float max, int capacity) {
        this.capacity = capacity;
        for (int i = 0; i < startingCount; i++) {
            addBullet(caliber, min, max);
        }
    }

    // Default constructor for the spare mag
    public Magazine(int capacity) {
        this.capacity = capacity;
    }

    public void addBullet(String caliber, float min, float max) {
        if (bullets.size() < capacity) {
            float randomDmg = (float) ThreadLocalRandom.current().nextDouble(min, max);
            bullets.push(new Bullet(caliber, randomDmg));
        }
    }

    public Bullet removeBullet() { return bullets.isEmpty() ? null : bullets.pop(); }
    public boolean isFull() { return bullets.size() >= capacity; }
    public int getCount() { return bullets.size(); }

    public boolean isEmpty() {
        return bullets.isEmpty();
    }
}
