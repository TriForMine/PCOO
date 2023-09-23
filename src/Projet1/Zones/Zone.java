package Projet1.Zones;

import Projet1.Monsters.Monster;
import Projet1.NPCs.NPC;

public abstract class Zone {
    protected String name;
    protected NPC[] npcs;
    protected Monster[] monsters;
    protected Zone[] linkedZones;

    public Zone(String name, NPC[] npcs, Monster[] monsters, Zone[] linkedZones) {
        this.name = name;
        this.npcs = npcs;
        this.monsters = monsters;
        this.linkedZones = linkedZones;
    }

    public Monster[] getMonsters() {
        Monster[] aliveMonsters = new Monster[getMonsterCount()];
        int index = 0;
        for (Monster monster : this.monsters) {
            if (monster != null) {
                aliveMonsters[index] = monster;
                index++;
            }
        }

        return aliveMonsters;
    }

    public NPC[] getNPCs() {
        NPC[] aliveNPCs = new NPC[getNPCCount()];
        int index = 0;
        for (NPC npc : this.npcs) {
            if (npc != null) {
                aliveNPCs[index] = npc;
                index++;
            }
        }

        return aliveNPCs;
    }

    public Zone[] getLinkedZones() {
        Zone[] aliveLinkedZones = new Zone[getLinkedZoneCount()];
        int index = 0;
        for (Zone zone : this.linkedZones) {
            if (zone != null) {
                aliveLinkedZones[index] = zone;
                index++;
            }
        }

        return aliveLinkedZones;
    }

    public int getNPCCount() {
        int count = 0;
        for (NPC npc : this.npcs) {
            if (npc != null) {
                count++;
            }
        }
        return count;
    }

    public int getMonsterCount() {
        int count = 0;
        for (Monster monster : this.monsters) {
            if (monster != null) {
                count++;
            }
        }
        return count;
    }

    public int getLinkedZoneCount() {
        int count = 0;
        for (Zone zone : this.linkedZones) {
            if (zone != null) {
                count++;
            }
        }
        return count;
    }

    public boolean hasNPCs() {
        return getNPCCount() > 0;
    }

    public boolean hasMonsters() {
        return getMonsterCount() > 0;
    }

    public boolean hasLinkedZones() {
        return getLinkedZoneCount() > 0;
    }

    public void removeMonster(int index) {
        // Index is the index of the alive monsters, not the index of the monsters array
        // We need to find the index of the monster in the monsters array
        int monsterIndex = 0;
        for (int i = 0; i < this.monsters.length; i++) {
            if (this.monsters[i] != null) {
                if (monsterIndex == index) {
                    monsterIndex = i;
                    break;
                }
                monsterIndex++;
            }
        }
        monsters[monsterIndex] = null;
    }

    public String getName() {
        return this.name;
    }

    public boolean canSleep() {
        return !hasMonsters();
    }

    public void setLinkedZones(Zone[] linkedZones) {
        this.linkedZones = linkedZones;
    }
}
