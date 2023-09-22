package Projet1.NPCs;

import Projet1.Common.EtreVivant;

public abstract class NPC extends EtreVivant {
    public String phrase;

    public void talk() {
        System.out.println(this.phrase);
    }
}
