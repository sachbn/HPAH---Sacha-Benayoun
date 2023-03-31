package org.sachabenayoun;

import java.util.Scanner;

public class Level1 {
    public void startLevel(Wizard wizard, Scanner scanner) {

        System.out.println("\nYou find yourself in the Hogwarts Dungeon Toilets.");
        System.out.println("A terrifying Troll is blocking your way out!");
        Main.sleep(2);

        System.out.println("\nTo defeat the Troll, you need to learn a new spell: Wingardium Leviosa.");
        Main.sleep(2);

        Spell wingardiumLeviosa = new Spell("Wingardium Leviosa", 20, 90);
        wizard.learnSpell(wingardiumLeviosa);
        System.out.println("You have successfully learned the spell " + wingardiumLeviosa.getName() + ".");
        Main.sleep(2);

        System.out.println("\nNow, use your spells to defeat the Troll.");
        Main.sleep(2);

        Enemy troll = new Enemy("Troll", 100, 100, 10);

        // Fight
        while (troll.getHealth() > 0) {
            clearScreen();
            System.out.println("\nYour health: " + wizard.getHealth());
            System.out.println("Troll's health: " + troll.getHealth());
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
                displayCastingAnimation(chosenSpell.getName(), chosenSpell.getPrecision());
                boolean success = wizard.useSpell(troll, chosenSpell);

                if (success) {
                    Main.sleep(2);
                    int damage = chosenSpell.getSpellDamage();
                    troll.takeDamage(damage);
                    System.out.println("Your spell was successful!");
                    System.out.println("You deal " + damage + " damage to the Troll!");
                } else {
                    System.out.println("Your spell failed...");
                    Main.sleep(2);
                }
            } else {
                System.out.println("Invalid action. The Troll attacks you!");

            }


            int playerDamage = troll.getAttackDamage();
            wizard.takeDamage(playerDamage);
            Main.sleep(4);

            if (wizard.getHealth() <= 0) {
                System.out.println("You have been defeated by the Troll. Game Over!");
                break;
            }


            if (troll.getHealth() <= 0) {
                clearScreen();
                System.out.println("You have defeated the Troll and can now continue your adventure!");
                wizard.restoreHealth();
                Main.sleep(2);
                wizard.levelUp(scanner);
                Main.sleep(2);
                System.out.println("Your health has been restored to full.");
                Main.sleep(3);
        }
        }

    }

    static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    private void displayCastingAnimation(String spellName, int precision) {
        System.out.println("\nCasting " + spellName + "...");

        int totalBars = 11;
        int successBars = (int) (totalBars * (precision / 100.0));

        for (int i = 0; i < totalBars; i++) {
            if (i < successBars) {
                System.out.print("|");
            } else {
                System.out.print(" ");
            }
            printWithDelay("=", 150);
        }

        System.out.println("|");
    }

    private void printWithDelay(String str, long delayMillis) {
        System.out.print(str);
        try {
            Thread.sleep(delayMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
