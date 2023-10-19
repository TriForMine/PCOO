package TP4;

import javax.swing.*;
import java.awt.*;

public class Code39Panel extends JPanel {
    private final String code;

    public Code39Panel(String code) {
        this.code = code;
    }

    @Override
    protected void paintComponent(Graphics g) {
        IterateurSymbole iterateurSymbole = new IterateurSymbole(code);
        int x = 200;
        int y = 200;

        Symbole vide = new Symbole(Nature.ESPACE, Epaisseur.ETROIT);

        int i = 0;
        while (iterateurSymbole.hasNext()) {
            Symbole symbole = iterateurSymbole.next();
            x += symbole.draw(g, x, y);

            if (i > 9 && i < code.length() - 9 && i % 9 == 0) {
                x += vide.draw(g, x, y);
            }
            i += 1;
        }
    }
}