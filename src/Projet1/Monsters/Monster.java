package Projet1.Monsters;

import Projet1.Common.EtreVivant;
import Projet1.Spells.Spell;
import Projet1.Utils.DamageType;

public abstract class Monster extends EtreVivant {
    public Monster(String name, int maxHealth, int maxMana, int damage) {
        super(name, maxHealth, maxMana, damage);
    }

    public void attack(EtreVivant target) {
        Spell spell = this.highestAvailableSpell();
        if (spell != null) {
            spell.cast(this, target);
        } else {
            target.takeDamage(this.damage, DamageType.PHYSICAL);
        }
    }

    public void takeDamage(int damage, DamageType damageType) {
        this.health -= damage;
    }
}
