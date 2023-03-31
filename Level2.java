package org.sachabenayoun;

import java.util.Scanner;

public class Level2 {
    public void startLevel(Wizard wizard, Scanner scanner, String house) {

        System.out.println("\nYou find yourself in the Chamber of Secrets.");
        System.out.println("A deadly Basilisk is guarding the entrance!");
        Main.sleep(2);

        System.out.println("\nTo defeat the Basilisk, you need a powerful weapon.");
        Main.sleep(2);

        Weapon weapon;
        if (house.equalsIgnoreCase("Gryffindor")) {
            weapon = new Weapon("Sword of Gryffindor", 50);
            System.out.println("As a Gryffindor, you summon the Sword of Gryffindor!");
        } else {
            weapon = new Weapon("Basilisk Fang", 40);
            System.out.println("You use Accio to summon a Basilisk Fang!");
        }
        wizard.equipWeapon(weapon);
        Main.sleep(2);

        Enemy basilisk = new Enemy("Basilisk", 160, 160, 20);

        while (basilisk.getHealth() > 0) {
            Level1.clearScreen();
            System.out.println("\nYour health: " + wizard.getHealth());
            System.out.println("Basilisk's health: " + basilisk.getHealth());
            Main.sleep(1);

            System.out.println("\nChoose an action:");
            System.out.println("1. Attack with " + weapon.getName());
            System.out.println("2. Cast a spell");

            int choice = scanner.nextInt();
            if (choice == 1) {
                boolean damage = wizard.attack(basilisk);
                System.out.println("You attack the Basilisk with " + weapon.getName() + " and deal " + damage + " damage!");
            } else if (choice == 2) {
                System.out.println("Choose a spell:");
                for (int i = 0; i < wizard.getLearnedSpells().size(); i++) {
                    System.out.println((i + 1) + ". " + wizard.getLearnedSpells().get(i).getName());
                }

                int spellChoice = scanner.nextInt();
                Spell chosenSpell = wizard.getLearnedSpells().get(spellChoice - 1);

                wizard.useSpell(basilisk, chosenSpell);
            } else {
                System.out.println("Invalid action. The Basilisk attacks you!");
            }

            int playerDamage = basilisk.getAttackDamage();
            wizard.takeDamage(playerDamage);
            System.out.println("The Basilisk attacks you, dealing " + playerDamage + " damage!");
            Main.sleep(2);

            if (wizard.getHealth() <= 0) {
                System.out.println("You have been defeated by the Basilisk. Game Over!");
                break;
            }
        }

        if (basilisk.getHealth() <= 0) {
            System.out.println("You have defeated the Basilisk and can now continue your adventure!");
            wizard.restoreHealth();
            System.out.println("Your health has been restored to full.");
            Main.sleep(3);
            wizard.levelUp(scanner);
            Main.sleep(3);
        }
    }
}
