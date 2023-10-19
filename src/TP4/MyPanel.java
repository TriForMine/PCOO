package TP4;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MyPanel extends JPanel {
    private static final Random r = new Random();
    private static final int[] rayons = new int[100];
    private static final int[] x = new int[100];
    private static final int[] y = new int[100];
    private static final Color[] colors = new Color[100];

    public MyPanel() {
        for (int i = 0; i < 100; i++) {
            rayons[i] = r.nextInt(10, 100);
            x[i] = r.nextInt(800);
            y[i] = r.nextInt(600);
            colors[i] = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        /*
        g.drawRect(400, 300, 100, 100);
        g.drawPolygon(new int[]{400, 500, 450}, new int[]{300, 300, 200}, 3);
         */

        for (int i = 0; i < 100; i++) {
            g.setColor(colors[i]);
            g.fillOval(
                    x[i] - rayons[i] / 2,
                    y[i] - rayons[i] / 2,
                    rayons[i],
                    rayons[i]
            );
        }
    }
}