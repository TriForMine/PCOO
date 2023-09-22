package Projet1;

public abstract class EtreVivant {
    public String name;
    public int MaxHP;
    public int HP;
    public int MaxMP;
    public int MP;
    public Spell[] spells;

    public void attack(EtreVivant target) {
        throw new java.lang.UnsupportedOperationException("Not supported yet.");
    }

    public void takeDamage(int damage, DamageType damageType) {
        throw new java.lang.UnsupportedOperationException("Not supported yet.");
    }

    public void heal(int amount) {
        throw new java.lang.UnsupportedOperationException("Not supported yet.");
    }
}