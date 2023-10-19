package Projet1;

import Projet1.Classes.Barbarian;
import Projet1.Classes.Mage;
import Projet1.Classes.Player;
import Projet1.Classes.Warrior;
import Projet1.Monsters.Monster;
import Projet1.NPCs.NPC;
import Projet1.Zones.World;
import Projet1.Zones.Zone;

import java.util.Scanner;

public class Game {
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean firstTime = true;
    private final World world = new World();
    private Player player;

    public Game() {
        createPlayer();
    }

    public static boolean askForReplay() {
        if (firstTime) {
            firstTime = false;
            return true;
        }

        System.out.println("Voulez-vous rejouer? (O/N)");
        String reply = scanner.nextLine();

        return reply.equalsIgnoreCase("o");
    }

    public static void pressEnterToContinue() {
        System.out.println("\nAppuyez sur Entrée pour continuer...");
        scanner.nextLine();
    }

    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec(new String[]{"cmd", "/c", "cls"});
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception ignored) {
        }
    }

    private boolean checkIfGameEnded() {
        clearConsole();

        if (!player.isAlive()) {
            System.out.println("Vous êtes mort!");
            System.out.println("Vous avez perdu!");
            return true;
        }

        if (world.allZonesCleared()) {
            System.out.println("Vous avez vaincu tous les monstres!");
            System.out.println("Vous avez gagné!");
            return true;
        }

        return false;
    }

    private void createPlayer() {
        clearConsole();

        System.out.println("Choisissez votre nom: ");
        String name = scanner.nextLine();
        System.out.println();

        while (player == null) {
            chooseClass(name);
        }

        introduction();

        start();
    }

    private void introduction() {
        clearConsole();

        System.out.println("Bienvenue dans Les Nuits de Padhiver!");
        System.out.println("Vous êtes " + player.getName() + " un " + player.getClassName() + " qui doit sauver le monde!");
        System.out.println("Vous devez vaincre tous les monstres pour gagner!");
        System.out.println("Vous pouvez vous déplacer entre les zones en utilisant les portails.");
        System.out.println("Vous pouvez parler aux PNJ pour obtenir des informations.");
        System.out.println("Vous pouvez dormir pour récupérer vos PV et PM.");

        pressEnterToContinue();
    }

    private int getChoice() {
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.println();

        return choice;
    }

    private void chooseClass(String name) {
        clearConsole();

        System.out.println("Choisissez votre classe: ");
        System.out.println("1. Guerrier");
        System.out.println("2. Mage");
        System.out.println("3. Barbare");

        int choice = getChoice();

        switch (choice) {
            case 1:
                player = new Warrior(name, world.getStartingZone());
                break;
            case 2:
                player = new Mage(name, world.getStartingZone());
                break;
            case 3:
                player = new Barbarian(name, world.getStartingZone());
                break;
            default:
                System.out.println("Choix invalide!");
                break;
        }
    }

    private void start() {
        while (!checkIfGameEnded()) {
            clearConsole();

            System.out.println("Vous êtes dans la zone " + player.getZone().getName() + "!");
            System.out.println("Vous avez " + player.getHealth() + " / " + player.getMaxHealth() + " PV et " + player.getMana() + " / " + player.getMaxMana() + " PM.");
            System.out.println("Que voulez-vous faire?");

            System.out.println("1. Dormir" + (player.getZone().canSleep() ? "" : " (Impossible)"));
            System.out.println("2. Parler à un PNJ (" + player.getZone().getNPCCount() + ")");
            System.out.println("3. Combattre un monstre (" + player.getZone().getMonsterCount() + ")");
            System.out.println("4. Se déplacer");

            int choice = getChoice();

            switch (choice) {
                case 1:
                    player.sleep();
                    break;
                case 2:
                    speakToNPC();
                    break;
                case 3:
                    fightMonster();
                    break;
                case 4:
                    move();
                    break;
                default:
                    System.out.println("Choix invalide!");
                    break;
            }
        }
    }

    private void speakToNPC() {
        clearConsole();

        if (!player.getZone().hasNPCs()) {
            System.out.println("Il n'y a pas de PNJ ici!");
            return;
        }

        System.out.println("Avec qui voulez-vous parler?");
        for (int i = 0; i < player.getZone().getNPCCount(); i++) {
            NPC npc = player.getZone().getNPCs()[i];
            System.out.println((i + 1) + ". " + npc.getName());
        }
        System.out.println((player.getZone().getNPCCount() + 1) + ". Annuler");

        int choice = getChoice();

        clearConsole();

        if (choice > 0 && choice <= player.getZone().getNPCCount()) {
            player.speak(player.getZone().getNPCs()[choice - 1]);

            pressEnterToContinue();
        } else if (choice == player.getZone().getNPCCount() + 1) {
            System.out.println("Vous avez annulé votre choix!");
        } else {
            System.out.println("Choix invalide!");
        }
    }

    private void fightMonster() {
        clearConsole();

        if (!player.getZone().hasMonsters()) {
            System.out.println("Il n'y a pas de monstre ici!");
            return;
        }

        System.out.println("Quel monstre voulez-vous combattre?");
        for (int i = 0; i < player.getZone().getMonsterCount(); i++) {
            Monster monster = player.getZone().getMonsters()[i];
            System.out.println((i + 1) + ". " + monster.getName());
        }
        System.out.println((player.getZone().getMonsterCount() + 1) + ". Annuler");

        int choice = getChoice();

        clearConsole();
        if (choice > 0 && choice <= player.getZone().getMonsterCount()) {
            System.out.println("Vous combattez un(e) " + player.getZone().getMonsters()[choice - 1].getName() + "!");
            System.out.println();

            if (player.fight(player.getZone().getMonsters()[choice - 1])) {
                player.getZone().removeMonster(choice - 1);

                System.out.println();
                System.out.println("Vous avez vaincu le monstre!");
                System.out.println();

                player.levelUp();
            } else {
                System.out.println();
                System.out.println("Vous avez été vaincu par le monstre!");
            }

            pressEnterToContinue();
        } else if (choice == player.getZone().getMonsterCount() + 1) {
            System.out.println("Vous avez annulé votre choix!");
        } else {
            System.out.println("Choix invalide!");
        }
    }

    private void move() {
        clearConsole();

        if (!player.getZone().hasLinkedZones()) {
            System.out.println("Il n'y a pas de portail ici!");
            return;
        }

        System.out.println("Où voulez-vous aller?");
        for (int i = 0; i < player.getZone().getLinkedZoneCount(); i++) {
            Zone zone = player.getZone().getLinkedZones()[i];
            System.out.println((i + 1) + ". " + zone.getName());
        }
        System.out.println((player.getZone().getLinkedZoneCount() + 1) + ". Annuler");

        int choice = getChoice();

        clearConsole();
        if (choice > 0 && choice <= player.getZone().getLinkedZoneCount()) {
            player.move(player.getZone().getLinkedZones()[choice - 1]);
        } else if (choice == player.getZone().getLinkedZoneCount() + 1) {
            System.out.println("Vous avez annulé votre choix!");
        } else {
            System.out.println("Choix invalide!");
        }
    }
}
