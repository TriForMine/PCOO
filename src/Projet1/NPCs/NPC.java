package Projet1.NPCs;

import Projet1.Common.Character;
import Projet1.Utils.DamageType;

public abstract class NPC extends Character {
    protected String phrase;

    protected NPC(String name, String phrase) {
        super(name, 0, 0, 0);
        this.phrase = phrase;
    }

    public void talk() {
        System.out.println(name + ":");
        System.out.println(phrase);
    }

    @Override
    public void attack(Character target) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int takeDamage(int damage, DamageType damageType) {
        throw new UnsupportedOperationException();
    }
}
