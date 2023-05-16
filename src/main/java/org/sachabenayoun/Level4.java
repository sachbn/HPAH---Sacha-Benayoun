package org.sachabenayoun;

import java.util.Scanner;

public class Level4 {
    public void startLevel(Wizard wizard, Scanner scanner, String house) {
        System.out.println("\nYou find yourself in the Little Hangleton graveyard.");
        System.out.println("Voldemort and Peter Pettigrew are trying to regain full power!");
        Main.sleep(2);

        System.out.println("\nYou need to get closer to Peter Pettigrew and use Accio to bring him to you.");
        Main.sleep(2);

        Spell accio = new Spell("Accio", 10, 95);
        wizard.learnSpell(accio);
        System.out.println("You have successfully learned the spell " + accio.getName() + ".");
        Main.sleep(2);

        Enemy voldemort = new Enemy("Voldemort", 200, 200, 30);
        Enemy pettigrew = new Enemy("Peter Pettigrew", 60, 60, 10);
        boolean isPettigrewCaptured = false;

        while (voldemort.getHealth() > 0 && !isPettigrewCaptured) {
            Level1.clearScreen();
            System.out.println("\nYour health: " + wizard.getHealth());
            System.out.println("Voldemort's health: " + voldemort.getHealth());
            System.out.println("Peter Pettigrew's health: " + pettigrew.getHealth());
            Main.sleep(1);

            System.out.println("\nChoose a spell to cast:");
            int spellIndex = 1;
            for (Spell spell : wizard.getLearnedSpells()) {
                System.out.println(spellIndex + ". " + spell.getName());
                spellIndex++;
            }

            int choice = scanner.nextInt();
            if (choice >= 1 && choice <= wizard.getLearnedSpells().size()) {
                Spell chosenSpell = wizard.getLearnedSpells().get(choice - 1);
                if (chosenSpell.getName().equalsIgnoreCase("Accio")) {
                    System.out.println("\nYou cast Accio to bring Peter Pettigrew to you.");
                    wizard.useSpell(pettigrew, chosenSpell);
                    isPettigrewCaptured = true;
                    System.out.println("You have successfully captured Peter Pettigrew!");
                    Main.sleep(2);
                } else {
                    System.out.println("That spell has no effect on Voldemort or Pettigrew. Try again!");
                }
            } else {
                System.out.println("Invalid action. Voldemort attacks you!");
            }

            int playerDamage = voldemort.getAttackDamage();
            wizard.takeDamage(playerDamage);
            System.out.println("Voldemort attacks you, dealing " + playerDamage + " damage!");
            Main.sleep(2);

            if (wizard.getHealth() <= 0) {
                System.out.println("You have been defeated by Voldemort. Game Over!");
                break;
            }
        }

        if (isPettigrewCaptured) {
            System.out.println("You have successfully captured Peter Pettigrew and can now escape!");
            wizard.restoreHealth();
            System.out.println("Your health has been restored to full.");
            Main.sleep(3);
            wizard.levelUp(scanner);
            Main.sleep(3);
        }
    }
}
