package Projet1.Zones;

import Projet1.Monsters.Gobelin;
import Projet1.Monsters.Monster;
import Projet1.NPCs.NPC;

public class Foret extends Zone {
    public Foret() {
        super("Forêt", new NPC[] {}, new Monster[] {
                new Gobelin(),
                new Gobelin(),
        }, new Zone[] {});
    }
}
