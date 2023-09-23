package Projet1.Classes;

import Projet1.Spells.BouleDeFeu;
import Projet1.Spells.RayonDeGivre;
import Projet1.Spells.Spell;
import Projet1.Zones.Zone;

public final class Mage extends Player {
    public Mage(String name, Zone zone) {
        super(name, 7, 4, 2, 1, zone);
        this.spells = new Spell[] {
            new BouleDeFeu(),
            new RayonDeGivre()
        };
    }

    @Override
    public String getClassName() {
        return "Mage";
    }
}
