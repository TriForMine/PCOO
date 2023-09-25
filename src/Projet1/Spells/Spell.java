package Projet1.Spells;

import Projet1.Classes.Player;
import Projet1.Common.Character;
import Projet1.Utils.DamageType;

/**
 * Represents an abstract Spell object with a name, damage, and cost.
 * Subclasses can inherit from this class to create specific types of Spells.
 */
public abstract class Spell {
    protected String name;
    protected int damage;
    protected int cost;

    /**
     * Creates a new Spell with the specified name, damage, and cost.
     *
     * @param name   the name of the Spell
     * @param damage the damage inflicted by the Spell
     * @param cost   the cost of using the Spell
     */
    protected Spell(String name, int damage, int cost) {
        this.name = name;
        this.damage = damage;
        this.cost = cost;
    }

    /**
     * Returns the name of the object.
     *
     * @return the name of the object
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the cost value.
     *
     * @return the cost value as an integer.
     */
    public int getCost() {
        return cost;
    }

    /**
     * Calculates the damage inflicted by a character.
     * If the caster is a player, the damage is increased by a factor of 2 if their level is 6 or higher.
     *
     * @param caster the character performing the attack
     * @return the calculated damage
     */
    protected int getDamage(Character caster) {
        if (caster instanceof Player player) {
            if (player.getLevel() >= 6) {
                return damage * 2;
            } else {
                return damage;
            }
        }
        return damage;
    }

    /**
     * Casts a spell on a target character.
     *
     * @param caster The character casting the spell.
     * @param target The character being targeted by the spell.
     */
    public void cast(Character caster, Character target) {
        if (caster.getMana() < cost) {
            System.out.println(caster.getName() + " n'a pas assez de mana pour lancer " + name + "!");
            return;
        }

        int damageDealt = target.takeDamage(getDamage(caster), DamageType.MAGICAL);
        System.out.println(caster.getName() + " lance " + name + " sur " + target.getName() + " et lui inflige " + damageDealt + " dégâts magiques!");
    }
}
