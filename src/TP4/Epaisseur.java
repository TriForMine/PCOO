package TP4;

import java.awt.*;

public enum Epaisseur {
    LARGE(6),
    ETROIT(2);
    private final int largeur;
    private final int hauteur = 160;

    Epaisseur(int largeur) {
        this.largeur = largeur;
    }

    public int draw(Graphics g, int x, int y) {
        g.fillRect(x, y, largeur, hauteur);
        return largeur;
    }
}
