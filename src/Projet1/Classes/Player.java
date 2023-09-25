package Projet1.Classes;

import Projet1.Common.Character;
import Projet1.Game;
import Projet1.Monsters.Monster;
import Projet1.NPCs.NPC;
import Projet1.Utils.DamageType;
import Projet1.Zones.Zone;

/**
 * The Player class extends the Character class and represents a player in a game.
 * It contains information about the player's name, health, mana, damage, level, and current zone.
 */
public abstract class Player extends Character {
    private int level;
    private Zone zone;

    /**
     * Protected constructor for creating a Player object.
     * Initializes the Player with a name, health, mana, damage, level, and zone.
     *
     * @param name   the name of the player
     * @param health the health points of the player
     * @param mana   the mana points of the player
     * @param damage the damage points of the player
     * @param level  the level of the player
     * @param zone   the current zone of the player
     */
    protected Player(String name, int health, int mana, int damage, int level, Zone zone) {
        super(name, health, mana, damage);
        this.level = level;
        this.zone = zone;
    }

    /**
     * This method returns the name of the class.
     *
     * @return the name of the class
     */
    public abstract String getClassName();

    /**
     * Returns the maximum health value, calculated by multiplying the maxHealth by the level.
     *
     * @return the maximum health value
     */
    @Override
    public int getMaxHealth() {
        return maxHealth * level;
    }

    /**
     * Returns the maximum mana based on the current level and maximum mana value.
     *
     * @return the maximum mana
     */
    @Override
    public int getMaxMana() {
        return maxMana * level;
    }

    /**
     * Gets the current level.
     *
     * @return the current level as an int.
     */
    public int getLevel() {
        return level;
    }

    /**
     * Retrieves the zone associated with this object.
     *
     * @return The zone object associated with this object.
     */
    public Zone getZone() {
        return zone;
    }

    /**
     * Calculates the damage based on the level of the object.
     *
     * @return the calculated damage.
     */
    @Override
    public int getDamage() {
        if (level >= 9) {
            return damage * 4;
        } else if (level >= 6) {
            return damage * 3;
        } else if (level >= 3) {
            return damage * 2;
        }

        return damage;
    }

    /**
     * Moves the character to the specified zone.
     *
     * @param z the zone to move the character to.
     */
    public void move(Zone z) {
        zone = z;
    }

    /**
     * Puts the character to sleep if the current zone allows sleeping.
     * Restores the object's health and mana to their maximum values.
     * Displays a message indicating successful sleep or inability to sleep.
     * Prompts the user to press Enter to continue.
     */
    public void sleep() {
        if (zone.canSleep()) {
            health = getMaxHealth();
            mana = getMaxMana();
            System.out.println("Vous vous êtes reposé, vous êtes maintenant en pleine forme!");

            Game.pressEnterToContinue();
        } else {
            System.out.println("Vous ne pouvez pas dormir ici!");

            Game.pressEnterToContinue();
        }
    }

    /**
     * Makes the character speak to the given NPC.
     * Calls the talk() method of the NPC object to initiate the conversation.
     *
     * @param npc the non-playable character to speak to
     */
    public void speak(NPC npc) {
        npc.talk();
    }

    /**
     * Initiates a fight between the character and the given monster.
     * The character and the monster take turns attacking each other until one of them is defeated.
     *
     * @param monster the monster to fight against
     * @return true if the character is alive after the fight, false otherwise
     */
    public boolean fight(Monster monster) {
        while (monster.isAlive() && isAlive()) {
            attack(monster);
            if (monster.isAlive()) {
                monster.attack(this);
            }
        }

        return isAlive();
    }

    /**
     * Applies damage to the character's health, based on the given damage amount and damage type.
     *
     * @param damage     the amount of damage to be applied
     * @param damageType the type of damage being applied
     * @return the amount of damage that was applied to the character's health
     * @throws IllegalArgumentException if the damage amount is negative
     */
    public int takeDamage(int damage, DamageType damageType) {
        if (damage < 0) {
            throw new IllegalArgumentException("damage cannot be negative");
        }

        health -= damage;
        return damage;
    }

    /**
     * Increases the character's level and displays a message with the new level.
     */
    public void levelUp() {
        level++;
        System.out.println("Vous avez gagné un niveau! Vous êtes maintenant niveau " + level + ".");
    }
}
