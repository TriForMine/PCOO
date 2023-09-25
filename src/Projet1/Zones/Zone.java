package Projet1.Zones;

import Projet1.Monsters.Monster;
import Projet1.NPCs.NPC;

/**
 * The Zone class represents a zone in a game world. It contains information about the name, NPCs, monsters, and linked zones.
 * It provides methods to retrieve information about the NPCs, monsters, and linked zones within the zone.
 * It also provides methods to manipulate and interact with the zone, such as removing monsters and checking if the zone is suitable for sleeping.
 */
public abstract class Zone {
    protected String name;
    protected NPC[] npcs;
    protected Monster[] monsters;
    protected Zone[] linkedZones;

    /**
     * Creates a Zone object with the given parameters.
     *
     * @param name        the name of the zone
     * @param npcs        an array of NPC objects in the zone
     * @param monsters    an array of Monster objects in the zone
     * @param linkedZones an array of Zone objects that are linked to this zone
     */
    protected Zone(String name, NPC[] npcs, Monster[] monsters, Zone[] linkedZones) {
        this.name = name;
        this.npcs = npcs;
        this.monsters = monsters;
        this.linkedZones = linkedZones;
    }

    /**
     * Returns an array of alive Monster objects in the zone.
     *
     * @return an array of alive Monster objects in the zone
     */
    public Monster[] getMonsters() {
        Monster[] aliveMonsters = new Monster[getMonsterCount()];
        int index = 0;
        for (Monster monster : monsters) {
            if (monster != null) {
                aliveMonsters[index] = monster;
                index++;
            }
        }

        return aliveMonsters;
    }

    /**
     * Returns an array of alive NPC (Non-Player Character) objects in the zone.
     *
     * @return an array of alive NPC objects in the zone
     */
    public NPC[] getNPCs() {
        NPC[] aliveNPCs = new NPC[getNPCCount()];
        int index = 0;
        for (NPC npc : npcs) {
            if (npc != null) {
                aliveNPCs[index] = npc;
                index++;
            }
        }

        return aliveNPCs;
    }

    /**
     * Returns an array of linked Zone objects.
     *
     * @return an array of linked Zone objects
     */
    public Zone[] getLinkedZones() {
        Zone[] aliveLinkedZones = new Zone[getLinkedZoneCount()];
        int index = 0;
        for (Zone zone : linkedZones) {
            if (zone != null) {
                aliveLinkedZones[index] = zone;
                index++;
            }
        }

        return aliveLinkedZones;
    }

    /**
     * Returns the count of non-null NPC objects.
     *
     * @return the count of non-null NPC objects
     */
    public int getNPCCount() {
        int count = 0;
        for (NPC npc : npcs) {
            if (npc != null) {
                count++;
            }
        }
        return count;
    }

    /**
     * Returns the count of non-null Monster objects.
     *
     * @return the count of non-null Monster objects
     */
    public int getMonsterCount() {
        int count = 0;
        for (Monster monster : monsters) {
            if (monster != null) {
                count++;
            }
        }
        return count;
    }

    /**
     * Returns the count of non-null Zone objects in the linkedZones list.
     *
     * @return the count of non-null Zone objects
     */
    public int getLinkedZoneCount() {
        int count = 0;
        for (Zone zone : linkedZones) {
            if (zone != null) {
                count++;
            }
        }
        return count;
    }

    /**
     * Returns whether the linkedZones list contains any non-null NPC objects.
     *
     * @return true if the linkedZones list contains at least one non-null NPC object, false otherwise
     */
    public boolean hasNPCs() {
        return getNPCCount() > 0;
    }

    /**
     * Returns whether the linkedZones list contains any non-null Monster objects.
     *
     * @return true if the linkedZones list contains at least one non-null Monster object, false otherwise
     */
    public boolean hasMonsters() {
        return getMonsterCount() > 0;
    }

    /**
     * Returns whether the linkedZones list contains any linked zones.
     *
     * @return true if the linkedZones list contains at least one linked zone, false otherwise
     */
    public boolean hasLinkedZones() {
        return getLinkedZoneCount() > 0;
    }

    /**
     * Removes a monster from the specified index in the monsters array.
     *
     * @param index The index of the monster to be removed.
     *              Note that this index refers to the alive monsters, not the index of the monsters array.
     *              It is zero-based.
     */
    public void removeMonster(int index) {
        int monsterIndex = 0;
        for (int i = 0; i < monsters.length; i++) {
            if (monsters[i] != null) {
                if (monsterIndex == index) {
                    monsterIndex = i;
                    break;
                }
                monsterIndex++;
            }
        }
        monsters[monsterIndex] = null;
    }

    /**
     * Returns the name of the object.
     *
     * @return The name of the object.
     */
    public String getName() {
        return name;
    }

    /**
     * Checks if the object can sleep.
     *
     * @return {@code true} if the object can sleep, {@code false} otherwise.
     */
    public boolean canSleep() {
        return !hasMonsters();
    }

    /**
     * Sets the linked zones for the object.
     *
     * @param linkedZones the array of zones to be linked.
     */
    public void setLinkedZones(Zone[] linkedZones) {
        this.linkedZones = linkedZones;
    }
}
