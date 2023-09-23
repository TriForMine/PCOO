package Projet1.Zones;

public final class World {
    private final Zone[] zones = new Zone[] {
            new Padhiver(),
            new RouteNord(),
            new RouteSud(),
            new Foret(),
            new MaraisDesMorts(),
            new Crypte(),
            new Volcan(),
    };

    public World() {
        // Padhiver
        zones[0].setLinkedZones(new Zone[] {
                // Route Nord
                zones[1],
                // Route Sud
                zones[2],
        });

        // Route Nord
        zones[1].setLinkedZones(new Zone[] {
                // Padhiver
                zones[0],
                // Forêt
                zones[3],
        });

        // Route Sud
        zones[2].setLinkedZones(new Zone[] {
                // Padhiver
                zones[0],
                // Marais des Morts
                zones[4],
        });

        // Forêt
        zones[3].setLinkedZones(new Zone[] {
                // Route Nord
                zones[1],
                // Volcan,
                zones[6],
        });

        // Marais des Morts
        zones[4].setLinkedZones(new Zone[] {
                // Route Sud,
                zones[2],
                // Crypte
                zones[5],
        });

        // Crypte
        zones[5].setLinkedZones(new Zone[] {
                // Marais des Morts
                zones[4],
        });

        // Volcan
        zones[6].setLinkedZones(new Zone[] {
                // Forêt
                zones[3],
        });
    }

    public boolean allZonesCleared() {
        for (Zone zone : zones) {
            if (zone.hasMonsters()) {
                return false;
            }
        }
        return true;
    }

    public Zone getStartingZone() {
        return zones[0];
    }

    public Zone[] getZones() {
        return zones;
    }

    public Zone getZone(int index) {
        return zones[index];
    }
}
