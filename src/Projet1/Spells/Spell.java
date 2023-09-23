package Projet1.Spells;

import Projet1.Classes.Player;
import Projet1.Common.EtreVivant;
import Projet1.Utils.DamageType;

public abstract class Spell {
    protected String name;
    protected int damage;
    protected int cost;

    protected Spell(String name, int damage, int cost) {
        this.name = name;
        this.damage = damage;
        this.cost = cost;
    }

    public String getName() {
        return this.name;
    }

    public int getCost() {
        return this.cost;
    }

    protected int getDamage(EtreVivant caster) {
        if (caster instanceof Player player) {
            if (player.getLevel() >= 6) {
                return this.damage * 2;
            } else {
                return this.damage;
            }
        }
        return this.damage;
    }

    public void cast(EtreVivant caster, EtreVivant target) {
        int damageDealt = target.takeDamage(this.getDamage(caster), DamageType.MAGICAL);
        System.out.println(caster.getName() + " lance " + this.name + " sur " + target.getName() + " et lui inflige " + damageDealt + " dégâts magiques!");
    }
}
