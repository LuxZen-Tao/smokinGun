package uk.co.gnosis.smokingun;

import java.util.Scanner;

class RangeController {
    private Gun playerWeapon;
    private Magazine spareMag = new Magazine(0); // Standard spare mag size for most handguns
    private final Scanner scanner = new Scanner(System.in);
    private Typewriter type= new Typewriter();

    public RangeController() {
        // You could easily change this to: playerWeapon = new DesertEagle();

    }

    public Gun ChooseWeapon(Scanner sc) {
        int choice = 0;
        while (choice < 1 || choice > 6) {
            System.out.println("Choose your weapon:");
            System.out.println("1. Desert Eagle");
            System.out.println("2. AK-47");
            System.out.println("3. Glock17");
            System.out.println("4. Police Special");
            System.out.println("5. ElephantThumper");
            System.out.println("6. ChickenLittle");

            System.out.print("Selection: ");
            try {
                choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        playerWeapon = new DesertEagle();
                        break;
                    case 2:
                        playerWeapon = new AK47();
                        break;
                    case 3:
                        playerWeapon = new Glock17();
                        break;
                    case 4:
                        playerWeapon = new PoliceSpecial();
                        break;
                    case 5:
                        playerWeapon = new ElephantThumper();
                        break;
                    case 6:
                        playerWeapon = new ChickenLittle();
                        break;
                    default:
                        System.out.println("Invalid choice, try again!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
        return playerWeapon;
    }

    public static void bootSequence() {
        String[] bootMessages = {
                "[SYSTEM] Initializing Gnosis Engine...",
                "[FILES] Loading uk.co.gnosis.smokingun.Bullet...",
                "[FILES] Loading uk.co.gnosis.smokingun.Gun...",
                "[DEVICES] Detecting Standard Issue Beretta...",
                "[DEVICES] Calibrating 9mm ballistic coefficients...",
                "[SUCCESS] Range Safety Protocols Active."
        };

        System.out.println("--- SYSTEM BOOT ---");

        for (String msg : bootMessages) {
            try {
                // Print the message one by one
                System.out.print(msg);

                // "Loading" animation frames
                for (int i = 0; i < 3; i++) {
                    Thread.sleep(400); // Wait 0.4 seconds
                    System.out.print(".");
                }

                System.out.println(" [OK]");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("-------------------\n");
    }

    public void startSession() {
        bootSequence();
        String gameGreats = """
                .----------------.  .----------------.  .----------------.  .----------------. 
                | .--------------. || .--------------. || .--------------. || .--------------. |
                | |   _____      | || |     ____     | || |     ____     | || |     ____     | |
                | |  |_   _|     | || |   .'    `.   | || |   .'    `.   | || |   .'    `.   | |
                | |    | |       | || |  /  .--.  \\  | || |  /  .--.  \\  | || |  /  .--.  \\  | |
                | |    | |   _   | || |  | |    `|  | || |  |  `--'  /  | || |  |  `--'  /  | |
                | |   _| |_ ( )_ | || |  \\  `--'  /  | || |   `.___.'`   | || |   `.___.'`   | |
                |_|  |_(_)|____||_||_|   `.____.'   |_| \\\\`._____.'\\__|_||_|   `.____.'   |_| 
                '----------------' '----------------' '----------------' '----------------' 
                
                """;
        System.out.println(gameGreats);
        LoadingBar.display();

        Typewriter.wait(1000);

        welcomeSpeech();

        type.write("First, choose your weapon!", 40);
        ChooseWeapon(scanner);

        boolean isRunning = true;
        while (isRunning) {
            Typewriter.write("\n--- FIRING RANGE MENU ---", 30);
            System.out.println("Gun: " + playerWeapon.name + " (" + playerWeapon.caliber + ")");
            System.out.println("Ammo in Gun: " + (playerWeapon.loaded != null ? playerWeapon.loaded.getCount() : "N/A"));
            System.out.println("Ammo in spare pouch mag: " + spareMag.getCount() + "/12");

            System.out.println("1. Fill Pouch Magazine");
            System.out.println("2. Load Pouch Mag into Gun");
            System.out.println("3. Fire Single Shot");
            System.out.println("4. Rapid Fire (Mag Dump)");
            System.out.println("5. Clear Jam");
            System.out.println("6. Eject Magazine");
            System.out.println("0. Leave Range");
            System.out.print("Selection: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    // Pass gun specs to the fill method
                    SmokingGun.fillMag(spareMag, playerWeapon.caliber, playerWeapon.minDmg, playerWeapon.maxDmg);
                    break;
                case "2":
                    playerWeapon.loadGun(spareMag);
                    spareMag = new Magazine(playerWeapon.magSize); // Create a new empty mag for the pouch
                    break;
                case "3":
                    playerWeapon.fire();
                    break;
                case "4":
                    playerWeapon.rapidFire();
                    break;
                case "5":
                    playerWeapon.clearJam();
                    break;
                case "6":
                    playerWeapon.ejectMag();
                    break;
                case "0":
                    isRunning = false;
                    System.out.println("See ya, MuvaFuka!");
                    break;
                default:
                    System.out.println("Invalid choice, rookie!");
            }
        }
    }

    public Typewriter getType() {
        return type;
    }

    public void setType(Typewriter type) {
        this.type = type;
    }

    public static void welcomeSpeech() {
        System.out.println("====================================================");
        Typewriter.write("WELCOME TO THE SMOKING GUN RANGE, AMMO-HEADS!", 40);
        Typewriter.wait(500);

        Typewriter.write("Step right up! We got white bullets, black bullets,", 30);
        Typewriter.write("Spanish bullets, German bullets...", 30);
        Typewriter.write("We got big bullets, little bullets, hot bullets, cold bullets!", 25);

        // The famous drawl
        System.out.print("We got CHICKEN ");
        Typewriter.write("BUUUULLLLLLLEEEETTTTTTSSSSSSS!!!!", 150); // Slow and dramatic

        Typewriter.wait(500);
        Typewriter.write("\nIF WE DON'T HAVE THE CALIBER, YOU DON'T NEED THE KILL!", 50);
        System.out.println("====================================================");
        Typewriter.wait(1000);
    }
}
