package Projet1;

import Projet1.Classes.Mage;
import Projet1.Classes.Player;
import Projet1.Classes.Barbarian;
import Projet1.Classes.Warrior;
import Projet1.Monsters.Monster;
import Projet1.NPCs.NPC;
import Projet1.Zones.World;
import Projet1.Zones.Zone;

import java.util.Scanner;

public class Game {
    private static Player player;
    private static final Scanner scanner = new Scanner(System.in);
    private static final World world = new World();

    public Game() {
        createPlayer();
    }

    private boolean checkIfGameEnded() {
        if (!player.isAlive()) {
            System.out.println("Vous êtes mort!");
            return true;
        }

        if (World.allZonesCleared()) {
            System.out.println("Vous avez gagné!");
            return true;
        }

        return false;
    }

    private void createPlayer() {
        System.out.println("Choisissez votre nom: ");
        String name = scanner.nextLine();

        System.out.println("Bienvenue " + name + "!");

        while (player == null) {
            chooseClass(name);
        }

        System.out.println("Vous êtes un " + player.getClassName() + "!");

        start();
    }

    private void chooseClass(String name) {
        System.out.println("Choisissez votre classe: ");
        System.out.println("1. Guerrier");
        System.out.println("2. Mage");
        System.out.println("3. Barbare");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                player = new Warrior(name, World.getStartingZone());
                break;
            case 2:
                player = new Mage(name, World.getStartingZone());
                break;
            case 3:
                player = new Barbarian(name, World.getStartingZone());
                break;
            default:
                System.out.println("Choix invalide!");
                break;
        }
    }

    private void start() {
        while (!checkIfGameEnded()) {
            System.out.println("Vous êtes dans la zone " + player.zone.getName() + "!");
            System.out.println("Vous avez " + player.getHealth() + " / " + player.getMaxHealth() + " PV et " + player.getMana() + " / " + player.getMaxMana() + " PM.");
            System.out.println("Que voulez-vous faire?");

            System.out.println("1. Dormir");
            System.out.println("2. Parler à un PNJ (" + player.zone.getNPCCount() + ")");
            System.out.println("3. Combattre un monstre (" + player.zone.getMonsterCount() + ")");
            System.out.println("4. Se déplacer");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (player.zone.canSleep()) {
                        player.sleep();
                    } else {
                        System.out.println("Vous ne pouvez pas dormir ici!");
                    }
                    break;
                case 2:
                    if (player.zone.hasNPCs()) {
                        speakToNPC();
                    } else {
                        System.out.println("Il n'y a pas de PNJ ici!");
                    }
                    break;
                case 3:
                    if (player.zone.hasMonsters()) {
                        fightMonster();
                    } else {
                        System.out.println("Il n'y a pas de monstre ici!");
                    }
                    break;
                case 4:
                    if (player.zone.hasLinkedZones()) {
                        move();
                    } else {
                        System.out.println("Aucune zone n'est liée à celle-ci!");
                    }
                    break;
                default:
                    System.out.println("Choix invalide!");
                    break;
            }
        }
    }

    private void speakToNPC() {
        System.out.println("Avec qui voulez-vous parler?");
        for (int i = 0; i < player.zone.getNPCCount(); i++) {
            NPC npc = player.zone.getNPCs()[i];
            System.out.println((i + 1) + ". " + npc.name);
        }

        int choice = scanner.nextInt();

        if (choice > 0 && choice <= player.zone.getNPCCount()) {
            player.speak(player.zone.getNPCs()[choice - 1]);
        } else {
            System.out.println("Choix invalide!");
        }
    }

    private void fightMonster() {
        System.out.println("Quel monstre voulez-vous combattre?");
        for (int i = 0; i < player.zone.getMonsterCount(); i++) {
            Monster monster = player.zone.getMonsters()[i];
            System.out.println((i + 1) + ". " + monster.name);
        }

        int choice = scanner.nextInt();

        if (choice > 0 && choice <= player.zone.getMonsterCount()) {
            if (player.fight(player.zone.getMonsters()[choice - 1])) {
                player.zone.removeMonster(choice - 1);

                System.out.println("Vous avez vaincu le monstre!");

                player.levelUp();
            } else {
                System.out.println("Vous avez été vaincu par le monstre!");
            }
        } else {
            System.out.println("Choix invalide!");
        }
    }

    private void move() {
        System.out.println("Où voulez-vous aller?");
        for (int i = 0; i < player.zone.getLinkedZoneCount(); i++) {
            Zone zone = player.zone.getLinkedZones()[i];
            System.out.println((i + 1) + ". " + zone.getName());
        }

        int choice = scanner.nextInt();

        if (choice > 0 && choice <= player.zone.getLinkedZoneCount()) {
            player.move(player.zone.getLinkedZones()[choice - 1]);
        } else {
            System.out.println("Choix invalide!");
        }
    }
}
