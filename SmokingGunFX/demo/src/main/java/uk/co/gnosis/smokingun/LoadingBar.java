package uk.co.gnosis.smokingun;

public class LoadingBar {
    private static int progress;

    public LoadingBar() {
        this.progress = 0;
    }

    public static void updateProgress(int increment) {
        progress += increment;
        if (progress > 100) {
            progress = 100;
        }
        display();
    }

    static void display() {
        int barLength = 50; // Length of the loading bar
        int filledLength = (int) (progress / 100.0 * barLength);
        StringBuilder bar = new StringBuilder();
        for (int i = 0; i < filledLength; i++) {
            bar.append("=");
        }
        for (int i = filledLength; i < barLength; i++) {
            bar.append(" ");
        }
        System.out.print("\rLoading: [" + bar + "] " + progress + "%");
    }
}
