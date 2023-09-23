package Projet1.Classes;

import Projet1.Zones.Zone;

public final class Barbarian extends Player {
    public Barbarian(String name, Zone zone) {
        super(name, 9, 0, 5, 1, zone);
    }

    @Override
    public String getClassName() {
        return "Barbare";
    }
}

