package Projet1.Zones;

import Projet1.Monsters.Dragon;
import Projet1.Monsters.Monster;
import Projet1.Monsters.Necromant;
import Projet1.NPCs.NPC;

public class Volcan extends Zone {
    public Volcan() {
        super("Volcan", new NPC[] {}, new Monster[] {
                new Dragon()
        }, new Zone[] {});
    }
}
