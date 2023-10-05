package Projet1.Classes;

import Projet1.Utils.DamageType;
import Projet1.Zones.Zone;

public final class Warrior extends Player {
    public Warrior(String name, Zone zone) {
        super(name, 8, 0, 4, 1, zone);
    }

    @Override
    public String getClassName() {
        return "Guerrier";
    }

    @Override
    public int takeDamage(int damage, DamageType damageType) {
        return super.takeDamage(
                damageType == DamageType.PHYSICAL ? damage - 2 : damage,
                damageType
        );
    }
}
