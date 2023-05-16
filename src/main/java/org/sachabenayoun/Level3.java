package org.sachabenayoun;

import java.util.Scanner;

public class Level3 {
    public void startLevel(Wizard wizard, Scanner scanner, String house) {
        System.out.println("\nYou find yourself near a lake in the Forbidden Forest.");
        System.out.println("Dementors are surrounding you!");
        Main.sleep(2);

        System.out.println("\nTo repel the Dementors, you need to learn a new spell: Expecto Patronum.");
        Main.sleep(2);

        Spell expectoPatronum = new Spell("Expecto Patronum", 20, 90);
        wizard.learnSpell(expectoPatronum);
        System.out.println("You have successfully learned the spell " + expectoPatronum.getName() + ".");
        Main.sleep(2);

        Enemy dementor = new Enemy("Dementor", 30, 60, 8);
        int dementorCount = 3;

        while (dementorCount > 0) {
            Level1.clearScreen();
            System.out.println("\nYour health: " + wizard.getHealth());
            System.out.println("Dementors health remaining: " + dementorCount);
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
                if (chosenSpell.getName().equalsIgnoreCase("Expecto Patronum")) {
                    wizard.useSpell(dementor, chosenSpell);
                    dementorCount--;
                } else {
                    System.out.println("That spell has no effect on Dementors. Try again!");
                }
            } else {
                System.out.println("Invalid action. The Dementor attacks you!");
            }

            int playerDamage = dementor.getAttackDamage();
            wizard.takeDamage(playerDamage);
            System.out.println("The Dementor attacks you, dealing " + playerDamage + " damage!");
            Main.sleep(2);

            if (wizard.getHealth() <= 0) {
                System.out.println("You have been defeated by the Dementors. Game Over!");
                break;
            }
        }

        if (dementorCount == 0) {
            System.out.println("You have repelled all the Dementors and can now continue your adventure!");
            wizard.restoreHealth();
            System.out.println("Your health has been restored to full.");
            Main.sleep(3);
            wizard.levelUp(scanner);
            Main.sleep(3);
        }
    }
}
