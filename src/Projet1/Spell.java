package Projet1;

public abstract class Spell {
    public String name;
    public int damage;
    public int cost;

    abstract void Launch(EtreVivant caster, EtreVivant target);
}
