package TP2;

public class TestCanal {
    public static void main(String[] args) {
        Canal[] canaux = new Canal[10];

        for (int i = 0; i < canaux.length; i++) {
            canaux[i] = new Canal("canal " + i);
        }

        int i = 0;

        String message = "";

        canaux[i].arriver();
        while (!message.equals("exit")) {
            System.out.print("Entrez un message : ");
            message = canaux[i].lireMessage();

            if (message.startsWith("switch ")) {
                String nom = message.substring(message.indexOf(" ") + 1);
                int nouveau = trouverCanal(canaux, nom);
                if (nouveau == -1) {
                    System.out.println("Ce canal n'existe pas!");
                } else {
                    i = nouveau;
                    canaux[i].arriver();
                }
            }
        }
        System.out.println("Fermeture du canal.");
    }

    private static int trouverCanal(Canal[] canaux, String nom) {
        for (int i = 0; i < canaux.length; i++) {
            if (canaux[i].getNom().equals(nom)) {
                return i;
            }
        }

        return -1;
    }
}