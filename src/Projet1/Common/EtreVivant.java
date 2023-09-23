package Projet1.Common;

import Projet1.Spells.Spell;
import Projet1.Utils.DamageType;

public abstract class EtreVivant {
    protected String name;
    protected int maxHealth;
    protected int health;
    protected int maxMana;
    protected int mana;
    protected Spell[] spells;
    protected int damage;

    protected EtreVivant(String name, int health, int mana, int damage) {
        this.name = name;
        this.maxHealth = health;
        this.health = health;
        this.maxMana = mana;
        this.mana = mana;
        this.damage = damage;
        this.spells = new Spell[0];
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }

    public int getMana() {
        return this.mana;
    }

    public int getMaxMana() {
        return this.maxMana;
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public Spell highestAvailableSpell() {
        Spell highestAvailableSpell = null;
        for (Spell spell : this.spells) {
            if (spell.getCost() <= this.mana && (highestAvailableSpell == null || highestAvailableSpell.getCost() < spell.getCost())) {
                highestAvailableSpell = spell;
            }
        }
        return highestAvailableSpell;
    }

    public abstract void attack(EtreVivant target);

    public abstract int takeDamage(int damage, DamageType damageType);

    public void heal(int amount) {
        this.health += amount;
        if (this.health > this.maxHealth) {
            this.health = this.maxHealth;
        }
    }
}
