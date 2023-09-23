package Projet1.Zones;

import Projet1.Monsters.Monster;
import Projet1.NPCs.NPC;
import Projet1.NPCs.NPC3;

public final class RouteNord extends Zone {
    public RouteNord() {
        super("Route Nord", new NPC[] {
                new NPC3()
        }, new Monster[] {}, new Zone[] {});
    }
}
