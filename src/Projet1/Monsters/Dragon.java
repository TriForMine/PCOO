package Projet1.Monsters;

import Projet1.Spells.SouffleDuDragon;
import Projet1.Spells.Spell;

public final class Dragon extends Monster {
    public Dragon() {
        super("Dragon", 70, 24, 12);
        this.spells = new Spell[] {
                new SouffleDuDragon()
        };
    }
}
