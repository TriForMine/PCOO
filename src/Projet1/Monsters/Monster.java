package Projet1.Monsters;

import Projet1.Common.Character;
import Projet1.Utils.DamageType;

public abstract class Monster extends Character {
    protected Monster(String name, int maxHealth, int maxMana, int damage) {
        super(name, maxHealth, maxMana, damage);
    }

    public int takeDamage(int damage, DamageType damageType) {
        if (damage < 0) {
            throw new IllegalArgumentException("damage cannot be negative");
        }

        this.health -= damage;
        return damage;
    }
}
