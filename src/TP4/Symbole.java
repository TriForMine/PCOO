package TP4;

import java.awt.*;

public class Symbole {
    public final Nature nature;
    public final Epaisseur epaisseur;

    public Symbole(Nature nature, Epaisseur epaisseur) {
        this.nature = nature;
        this.epaisseur = epaisseur;
    }

    public int draw(Graphics g, int x, int y) {
        nature.color(g);
        return epaisseur.draw(g, x, y);
    }
}
