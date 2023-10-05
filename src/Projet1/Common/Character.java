package Projet1.Common;

import Projet1.Spells.Spell;
import Projet1.Utils.DamageType;

/**
 * The Character class represents a generic character in a game.
 * It provides methods to get and modify the character's name, health,
 * mana, damage, and spells. It also provides methods to check if the
 * character is alive, get the highest available spell, attack another
 * character, and take damage. Additionally, it provides a method to heal
 * the character.
 */
public abstract class Character {
    protected String name;
    protected int maxHealth;
    protected int health;
    protected int maxMana;
    protected int mana;
    protected Spell[] spells;
    protected int damage;

    /**
     * Constructs a new Character with the given parameters.
     *
     * @param name   the name of the Character (cannot be null)
     * @param health the health points of the Character (cannot be negative)
     * @param mana   the mana points of the Character (cannot be negative)
     * @param damage the damage points of the Character (cannot be negative)
     * @throws IllegalArgumentException if name is null, health is negative, mana is negative, or damage is negative
     */
    protected Character(String name, int health, int mana, int damage) {
        if (name == null) {
            throw new IllegalArgumentException("name cannot be null");
        }
        if (health < 0) {
            throw new IllegalArgumentException("health cannot be negative");
        }
        if (mana < 0) {
            throw new IllegalArgumentException("mana cannot be negative");
        }
        if (damage < 0) {
            throw new IllegalArgumentException("damage cannot be negative");
        }

        this.name = name;
        this.maxHealth = health;
        this.health = health;
        this.maxMana = mana;
        this.mana = mana;
        this.damage = damage;
        this.spells = new Spell[0];
    }

    /**
     * Returns the name of the character.
     *
     * @return the name of the character
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the health of the character.
     *
     * @return the health of the character
     */
    public int getHealth() {
        return health;
    }

    /**
     * Returns the maximum health of the character.
     *
     * @return the maximum health of the character
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    /**
     * Returns the current mana of the character.
     *
     * @return the current mana of the character
     */
    public int getMana() {
        return mana;
    }

    /**
     * Returns the maximum mana of the character.
     *
     * @return the maximum mana of the character
     */
    public int getMaxMana() {
        return maxMana;
    }

    /**
     * Returns the damage value of the character.
     *
     * @return the damage value of the character
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Returns true if the character is alive, false otherwise.
     *
     * @return true if the character is alive, false otherwise
     */
    public boolean isAlive() {
        return health > 0;
    }

    /**
     * Returns the highest available spell for the character.
     * <p>
     * The highest available spell is determined based on the character's mana and the cost of the spell.
     * It returns the spell with the highest cost that the character has enough mana for.
     * If there are multiple spells with the same cost, the method returns the first one encountered in the list.
     *
     * @return the highest available spell for the character, null if no spell is available
     */
    public Spell highestAvailableSpell() {
        Spell highestAvailableSpell = null;
        for (Spell spell : spells) {
            if (spell.getCost() <= mana && (highestAvailableSpell == null || highestAvailableSpell.getCost() < spell.getCost())) {
                highestAvailableSpell = spell;
            }
        }
        return highestAvailableSpell;
    }

    /**
     * Attacks the specified character.
     * <p>
     * If the character has a spell available, it casts the highest available spell on the target.
     * Otherwise, it performs a physical attack on the target using its damage value.
     *
     * @param target the character to attack
     */
    public void attack(Character target) {
        Spell spell = highestAvailableSpell();
        if (spell != null) {
            spell.cast(this, target);
        } else {
            int takenDamage = target.takeDamage(getDamage(), DamageType.PHYSICAL);
            System.out.println(name + " attaque " + target.getName() + " et lui inflige " + takenDamage + " dégâts.");
        }
    }

    /**
     * Inflicts damage to the character.
     * <p>
     * Calculates and applies the damage to the character based on the specified damage and damage type.
     * Returns the amount of damage that was inflicted.
     *
     * @param damage     the amount of damage to be inflicted
     * @param damageType the type of damage to be inflicted
     * @return the amount of damage that was inflicted
     */
    public abstract int takeDamage(int damage, DamageType damageType);

    /**
     * Restores the character's health by the specified amount.
     * <p>
     * If the amount is negative, an IllegalArgumentException is thrown. Otherwise, the character's health is increased
     * by the specified amount, capped at the maximum health.
     *
     * @param amount the amount of health to be restored
     */
    public void heal(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("heal amount cannot be negative");
        }

        health = Math.min(health + amount, maxHealth);
    }
}
