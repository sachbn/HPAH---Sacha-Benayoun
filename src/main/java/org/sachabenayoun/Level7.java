package org.sachabenayoun;

import java.util.Scanner;

public class Level7 {
    public void startLevel(Wizard wizard, Scanner scanner, String house) {
        System.out.println("\nYou find yourself at the Battle of Hogwarts.");
        System.out.println("Lord Voldemort and Bellatrix Lestrange are your final enemies!");
        Main.sleep(2);

        Enemy voldemort = new Enemy("Lord Voldemort", 180, 180, 30);
        Enemy bellatrix = new Enemy("Bellatrix Lestrange", 150, 150, 25);

        while (voldemort.getHealth() > 0 || bellatrix.getHealth() > 0) {
            Level1.clearScreen();
            System.out.println("\nYour health: " + wizard.getHealth());
            System.out.println("Voldemort's health: " + voldemort.getHealth());
            System.out.println("Bellatrix's health: " + bellatrix.getHealth());
            Main.sleep(1);

            System.out.println("\nChoose an action:");
            System.out.println("1. Cast a spell");
            System.out.println("2. Choose enemy to attack");

            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("Choose a spell:");
                for (int i = 0; i < wizard.getLearnedSpells().size(); i++) {
                    System.out.println((i + 1) + ". " + wizard.getLearnedSpells().get(i).getName());
                }

                int spellChoice = scanner.nextInt();
                Spell chosenSpell = wizard.getLearnedSpells().get(spellChoice - 1);

                System.out.println("Choose your target:");
                System.out.println("1. Lord Voldemort");
                System.out.println("2. Bellatrix Lestrange");

                int targetChoice = scanner.nextInt();
                Enemy target = (targetChoice == 1) ? voldemort : bellatrix;

                wizard.useSpell(target, chosenSpell);
            } else if (choice == 2) {
                System.out.println("Choose enemy to attack:");
                System.out.println("1. Lord Voldemort");
                System.out.println("2. Bellatrix Lestrange");

                int targetChoice = scanner.nextInt();
                Enemy target = (targetChoice == 1) ? voldemort : bellatrix;

                int playerDamage = target.getAttackDamage();
                wizard.takeDamage(playerDamage);
                System.out.println(target.getName() + " attacks you, dealing " + playerDamage + " damage!");
                Main.sleep(2);
            } else {
                System.out.println("Invalid action. The enemies attack you!");
            }

            if (wizard.getHealth() <= 0) {
                System.out.println("You have been defeated by Voldemort and Bellatrix. Game Over!");
                break;
            }
        }

        if (voldemort.getHealth() <= 0 && bellatrix.getHealth() <= 0) {
            System.out.println("You have defeated Lord Voldemort and Bellatrix Lestrange! You have won the Battle of Hogwarts!");
            wizard.restoreHealth();
            System.out.println("Your health has been restored to full.");
            Main.sleep(3);
            System.out.println("Congratulations, you have completed your adventure!");
        }
    }
}
