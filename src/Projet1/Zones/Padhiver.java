package Projet1.Zones;

import Projet1.Monsters.Monster;
import Projet1.NPCs.NPC;
import Projet1.NPCs.NPC1;
import Projet1.NPCs.NPC2;

public final class Padhiver extends Zone {
    public Padhiver() {
        super("Padhiver", new NPC[] {
                new NPC1(),
                new NPC2()
        }, new Monster[] {}, new Zone[] {});
    }
}
