package uk.co.gnosis.smokingun;

public class LoadingBar {
    private static final int BAR_LENGTH = 50;
    private static int progress = 0;

    public LoadingBar() {
        progress = 0;
    }

    public static void updateProgress(int increment) {
        progress += increment;
        if (progress > 100) {
            progress = 100;
        }
        display();
    }

    static void runIntroAnimation() {
        progress = 0;
        while (progress < 100) {
            updateProgress(4);
            Typewriter.wait(35);
        }
        System.out.println();
    }

    static void display() {
        int filledLength = (int) (progress / 100.0 * BAR_LENGTH);
        StringBuilder bar = new StringBuilder();
        for (int i = 0; i < filledLength; i++) {
            bar.append("=");
        }
        for (int i = filledLength; i < BAR_LENGTH; i++) {
            bar.append(" ");
        }
        System.out.print("\rLoading: [" + bar + "] " + progress + "%");
    }
}
