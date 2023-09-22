package Projet1;

abstract class Player extends EtreVivant {
    public int level;
    public Zone zone;
    public int damage;

    public void move(Zone z) {
        this.zone = z;
    }

    public void sleep() {
        throw new UnsupportedOperationException();
    }

    public void speak(NPC npc) {
        throw new UnsupportedOperationException();
    }

    public void fight(Monster monster) {
        throw new UnsupportedOperationException();
    }
}
