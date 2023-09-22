package Projet1.Spells;

import Projet1.Classes.Player;
import Projet1.Common.EtreVivant;

public abstract class Spell {
    public String name;
    public int damage;
    public int cost;

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

    public abstract void cast(EtreVivant caster, EtreVivant target);
}
