package Projet1.Zones;

import Projet1.Monsters.Monster;
import Projet1.Monsters.Orc;
import Projet1.NPCs.NPC;

public class RouteSud extends Zone {
    public RouteSud() {
        super("Route Sud", new NPC[] {}, new Monster[] {
                new Orc(),
                new Orc(),
        }, new Zone[] {});
    }
}
