package TP4;

import javax.swing.*;

public class Code39Main {
    public static void main(String[] args) {
        String code = Code39.getCode("CODE39");

        JFrame frame = new JFrame(); // creation d’une fenetre graphique
        frame.setSize(800, 600); // taille de la fenetre
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
// comportement lors de la fermeture
        frame.setLocationRelativeTo(null); // on centre la fenetre
        frame.getContentPane().add(new Code39Panel(code)); // on ajoute le panneau
        frame.setVisible(true); // on rend la fenetre visible
    }
}