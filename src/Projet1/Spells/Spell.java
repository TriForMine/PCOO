package Projet1.Spells;

import Projet1.Classes.Player;
import Projet1.Common.EtreVivant;
import Projet1.Utils.DamageType;

public abstract class Spell {
    public String name;
    public int damage;
    public int cost;

    public Spell(String name, int damage, int cost) {
        this.name = name;
        this.damage = damage;
        this.cost = cost;
    }

    protected int getDamage(EtreVivant caster, EtreVivant target) {
        if (caster instanceof Player) {
            if (((Player) caster).level >= 6) {
                return this.damage * 2;
            } else {
                return this.damage;
            }
        }
        return this.damage;
    }

    public void cast(EtreVivant caster, EtreVivant target) {
        System.out.println(caster.getName() + " lance " + this.name + " sur " + target.getName());
        target.takeDamage(this.getDamage(caster, target), DamageType.MAGICAL);
    }
}
