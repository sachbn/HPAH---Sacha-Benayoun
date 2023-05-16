package org.sachabenayoun;

import java.util.Scanner;

public class Level5 {
    public void startLevel(Wizard wizard, Scanner scanner, String house) {
        System.out.println("\nYou find yourself in the Hogwarts Exam Room.");
        System.out.println("Dolores Umbridge is giving you a hard time during the exams!");
        Main.sleep(2);

        System.out.println("\nYou must battle Dolores Umbridge until you can use fireworks from your inventory.");
        Main.sleep(2);

        Weapon weapon;
        weapon = new Weapon("Fireworks", 10);
        wizard.equipWeapon(weapon);

        Enemy umbridge = new Enemy("Dolores Umbridge", 120, 120, 15);
        boolean fireworksUsed = false;

        while (umbridge.getHealth() > 0 && !fireworksUsed) {
            Level1.clearScreen();
            System.out.println("\nYour health: " + wizard.getHealth());
            System.out.println("Dolores Umbridge's health: " + umbridge.getHealth());
            Main.sleep(1);

            System.out.println("\nChoose an action:");
            System.out.println("1. Cast a spell");
            System.out.println("2. Use Fireworks");

            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("Choose a spell:");
                for (int i = 0; i < wizard.getLearnedSpells().size(); i++) {
                    System.out.println((i + 1) + ". " + wizard.getLearnedSpells().get(i).getName());
                }

                int spellChoice = scanner.nextInt();
                Spell chosenSpell = wizard.getLearnedSpells().get(spellChoice - 1);

                wizard.useSpell(umbridge, chosenSpell);
            } else if (choice == 2) {
                System.out.println("You don't have Fireworks in your inventory. Keep fighting!");

            } else {
                System.out.println("Invalid action. Dolores Umbridge attacks you!");
            }

            int playerDamage = umbridge.getAttackDamage();
            wizard.takeDamage(playerDamage);
            System.out.println("Dolores Umbridge attacks you, dealing " + playerDamage + " damage!");
            Main.sleep(2);

            if (wizard.getHealth() <= 0) {
                System.out.println("You have been defeated by Dolores Umbridge. Game Over!");
                break;
            }
        }

        if (fireworksUsed) {
            System.out.println("You have defeated Dolores Umbridge with Fireworks and can now continue your adventure!");
            wizard.restoreHealth();
            System.out.println("Your health has been restored to full.");
            Main.sleep(3);
            wizard.levelUp(scanner);
            Main.sleep(3);
        }
    }
}
