package uk.co.gnosis.smokingun;

public class Typewriter {
    // Default speed in milliseconds
    private static final int DEFAULT_SPEED = 35;

    public static void write(String text) {
        write(text, DEFAULT_SPEED);
    }

    public static void write(String text, int speed) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                // Short pause between each character
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(); // New line after finishing the string
    }

    public static void wait(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) {}
    }
}