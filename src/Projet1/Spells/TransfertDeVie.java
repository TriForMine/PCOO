package Projet1.Spells;

import Projet1.Common.EtreVivant;

public class TransfertDeVie extends Spell {
    public TransfertDeVie() {
        super("Transfert de Vie", 12, 5);
    }

    @Override
    public void cast(EtreVivant caster, EtreVivant target) {
        super.cast(caster, target);
        caster.heal(this.getDamage(caster, target) / 2);
    }
}
