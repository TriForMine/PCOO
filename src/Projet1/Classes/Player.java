package Projet1.Classes;

import Projet1.Common.EtreVivant;
import Projet1.Monsters.Monster;
import Projet1.NPCs.NPC;
import Projet1.Spells.Spell;
import Projet1.Utils.DamageType;
import Projet1.Zones.Zone;

public abstract class Player extends EtreVivant {
    public int level;
    public Zone zone;

    public Player(String name, int health, int mana, int damage, int level, Zone zone) {
        super(name, health, mana, damage);
        this.level = level;
        this.zone = zone;
    }

    public int getMaxHealth() {
        return this.maxHealth * this.level;
    }

    public int getMaxMana() {
        return this.maxMana * this.level;
    }

    protected int getDamage() {
        if (this.level >= 9) {
            return this.damage * 4;
        } else if (this.level >= 6) {
            return this.damage * 3;
        } else if (this.level >= 3) {
            return this.damage * 2;
        }

        return this.damage;
    }

    public void move(Zone z) {
        this.zone = z;
    }

    public void sleep() {
        if (this.zone.canSleep()) {
            this.health = this.getMaxHealth();
            this.mana = this.getMaxMana();
        }
    }

    public void speak(NPC npc) {
        npc.talk();
    }

    public boolean fight(Monster monster) {
        while (monster.isAlive() && this.isAlive()) {
            this.attack(monster);
            if (monster.isAlive()) {
                monster.attack(this);
            }
        }

        return this.isAlive();
    }

    public void attack(EtreVivant target) {
        Spell spell = this.highestAvailableSpell();
        if (spell != null) {
            spell.cast(this, target);
        } else {
            target.takeDamage(this.getDamage(), DamageType.PHYSICAL);
        }
    }

    public void takeDamage(int damage, DamageType damageType) {
        this.health -= damage;
    }
}