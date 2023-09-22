package Projet1.Classes;

import Projet1.Utils.DamageType;
import Projet1.Zones.Zone;

public class Guerrier extends Player {
    public Guerrier(String name, Zone zone) {
        super(name, 8, 0, 4, 1, zone);
    }

    public void takeDamage(int damage, DamageType damageType) {
        super.takeDamage(damageType == DamageType.PHYSICAL ? damage - 2 : damage, damageType);
    }
}
