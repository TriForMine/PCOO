package Projet1.Zones;

import Projet1.Monsters.ChauveSouris;
import Projet1.Monsters.Monster;
import Projet1.NPCs.NPC;

public final class MaraisDesMorts extends Zone {
    public MaraisDesMorts() {
        super("Marais des Morts", new NPC[] {}, new Monster[] {
                new ChauveSouris(),
                new ChauveSouris(),
                new ChauveSouris(),
        }, new Zone[] {});
    }
}
