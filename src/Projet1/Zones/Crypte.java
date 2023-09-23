package Projet1.Zones;

import Projet1.Monsters.ChauveSouris;
import Projet1.Monsters.Monster;
import Projet1.Monsters.Necromant;
import Projet1.NPCs.NPC;

public class Crypte extends Zone {
    public Crypte() {
        super("Crypte", new NPC[] {}, new Monster[] {
                new Necromant()
        }, new Zone[] {});
    }
}
