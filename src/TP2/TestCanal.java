package TP2;

public class TestCanal {
    public static void main(String[] args) {
        Canal c = new Canal();
        System.out.print("Entrez un message : ");
        while (!c.lireMessage().equals("exit")) {
            System.out.print("Entrez un message : ");
        }
        System.out.println("Fermeture du canal.");
    }
}