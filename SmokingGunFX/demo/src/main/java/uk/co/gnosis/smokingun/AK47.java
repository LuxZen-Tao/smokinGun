package uk.co.gnosis.smokingun;

public class AK47
extends Gun {
    public AK47() {
        super("AK-47", "7.62mm", 30, 25.0f, 35.0f, 5.0f);
    }
}
// The "White/Black" bullets (Standard)
class PoliceSpecial extends Gun {
    public PoliceSpecial() {
        super("S&W Model 10", ".38 Special", 6, 20.0f, 35.0f, 1.0f);
    }
}

// The "Big" bullets
class ElephantThumper extends Gun {
    public ElephantThumper() {
        super("Nitros Express", ".700 NE", 2, 500.0f, 750.0f, 5.0f);
    }
}

// The "Chicken" bullets (Fast, weak, but never jams)
class ChickenLittle extends Gun {
    public ChickenLittle() {
        super("Feather-Weight 22", ".22 LR", 30, 5.0f, 10.0f, 0.1f);
    }
}
