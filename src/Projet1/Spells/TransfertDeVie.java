package Projet1.Spells;

import Projet1.Common.Character;

public final class TransfertDeVie extends Spell {
    public TransfertDeVie() {
        super("Transfert de Vie", 12, 5);
    }

    @Override
    public void cast(Character caster, Character target) {
        super.cast(caster, target);
        caster.heal(getDamage(caster) / 2);
    }
}
