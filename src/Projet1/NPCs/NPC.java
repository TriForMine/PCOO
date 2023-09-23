package Projet1.NPCs;

import Projet1.Common.EtreVivant;

public abstract class NPC extends EtreVivant {
    public String phrase;

    public NPC(String name) {
        super(name, 0, 0, 0);
    }

    public void talk() {
        System.out.println(this.phrase);
    }
}
