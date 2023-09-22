package Projet1.Zones;

import Projet1.Monsters.Monster;
import Projet1.NPCs.NPC;

public abstract class Zone {
    public String name;
    public NPC[] npcs;
    public Monster[] monsters;
    public Zone[] linkedZones;

    public boolean canSleep() {
        return this.monsters.length == 0;
    }
}