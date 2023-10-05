package Projet1;

public class Main {
    public static void main(String[] args) {
        while (Game.askForReplay()) {
            new Game();
        }
    }
}
