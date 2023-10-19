package TP4;

import java.awt.*;

public enum Nature {
    BARRE,
    ESPACE;

    public void color(Graphics g) {
        if (this == Nature.BARRE) {
            g.setColor(Color.BLACK);
        } else if (this == Nature.ESPACE) {
            g.setColor(Color.WHITE);
        }
    }
}
