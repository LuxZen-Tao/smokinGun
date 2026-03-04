package uk.co.gnosis.smokingun;

public class RangeArt {

    // The high-energy, heavy-caliber logo
    private static final String BARKER_LOGO = """
           _                                    _____                 
          | |                                  |  __ \\                
      ___ | |__   ___  _ __ ___   ___  _   _ __ | |  \\/ _   _ _ __      
     / __|| '_ \\ / _ \\| '_ ` _ \\ / _ \\| | | | '_ \\| | __ | | | | '_ \\ 
     \\__ \\| | | | (_) | | | | | |  __/| |_| | | | | |_\\] || |_| | | | |
     |___/|_| |_|\\___/|_| |_| |_|\\___| \\__,_||_| |_|\\____/ \\__,_||_| |_|
    """;

    // A small "divider" that looks like a row of bullets
    private static final String BULLET_DIVIDER = "  [=] [=] [=] [=] [=] [=] [=] [=] [=] [=] [=] [=] [=] [=] [=] ";

    public static void printMenuHeader() {
        System.out.println(BULLET_DIVIDER);

        // Use Typewriter for the logo to give it that CRT "draw-in" effect
        Typewriter.write(BARKER_LOGO, 2); // Very fast, like a sudden flash

        System.out.println(BULLET_DIVIDER);
        Typewriter.write("Step up to the line, bullet-lover! Whatcha shootin'?", 30);
        System.out.println();
    }
}