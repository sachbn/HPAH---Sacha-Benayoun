package org.sachabenayoun;

import java.util.Scanner;
import org.sachabenayoun.Wizard;

public class Level6 {
    public void startLevel(Wizard player, Scanner scanner, String house) {
        System.out.println("Welcome to Level 6!\n");
        System.out.println("In this level, you will face a magical creature that has escaped the Forbidden Forest.");
        
        System.out.println("Press enter to continue...");
        scanner.nextLine();

        System.out.println("While walking through the Hogwarts grounds, you come across a fearsome magical creature - a Niffler!");

        System.out.println("In order to proceed, you need to use a spell to calm the creature and prevent it from causing any more trouble.");

        boolean success = false;

        while (!success) {
            System.out.println("Choose a spell to use:");
            System.out.println("1. Stupefy (Stunning Spell)");
            System.out.println("2. Expelliarmus (Disarming Spell)");
            System.out.println("3. Riddikulus (Boggart-Banishing Spell)");
            System.out.println("4. Piertotum Locomotor (Animation Charm)");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("You try to use Stupefy, but the Niffler dodges your spell.");
                    break;
                case 2:
                    System.out.println("You use Expelliarmus, but the Niffler is unaffected.");
                    break;
                case 3:
                    System.out.println("You successfully use Riddikulus, and the Niffler becomes calm and friendly. Well done!");
                    success = true;
                    break;
                case 4:
                    System.out.println("You try to use Piertotum Locomotor, but nothing happens.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }

        System.out.println("Congratulations! You have completed Level 6.");
    }
}
