package Projet1.NPCs;

import Projet1.Common.EtreVivant;
import Projet1.Utils.DamageType;

public abstract class NPC extends EtreVivant {
    protected String phrase;

    protected NPC(String name, String phrase) {
        super(name, 0, 0, 0);
        this.phrase = phrase;
    }

    public void talk() {
        System.out.println(this.name + ":");
        System.out.println(this.phrase);
    }

    @Override
    public void attack(EtreVivant target) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int takeDamage(int damage, DamageType damageType) {
        throw new UnsupportedOperationException();
    }
}
