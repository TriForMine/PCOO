package Projet1.Monsters;

import Projet1.Spells.Spell;
import Projet1.Spells.TransfertDeVie;

public final class Necromant extends Monster {
    public Necromant() {
        super("Nécromant", 30, 10, 8);
        this.spells = new Spell[] {
                new TransfertDeVie()
        };
    }
}
