package org.sachabenayoun;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        clearScreen();
        displayMessageWithDelay("Welcome to the Wizarding World of Harry Potter!", 2);

        String playerName = promptForInput("\nPlease enter your character's name:");
        displayMessageWithDelay("\nHello, " + playerName + "! The Sorting Hat will now place you in a Hogwarts house.", 2);

        House playerHouse = House.SortingHat();
        displayMessageWithDelay("\nYou have been sorted into " + playerHouse.getName() + "!\n", 1);
        displayMessageWithDelay("House description: " + playerHouse.getDescription() + "\n", 3);

        displayMessageWithDelay("Now, let's choose your wand!\n", 2);
        Wand playerWand = Wand.generateRandomWand();
        displayMessageWithDelay("Your wand has a " + playerWand.getCore() + " core, is made of " + playerWand.getWood() + " wood, and is " + playerWand.getLength() + " inches long.\n", 3);

        displayMessageWithDelay("You can also choose a pet to accompany you on your journey.\n", 2);
        Pet playerPet = choosePet();
        displayMessageWithDelay("Your new pet is a " + playerPet.getName() + ".\n", 2);

        displayMessageWithDelay("Now, let's create your character in the game!", 2);
        Wizard player = new Wizard(playerName, playerHouse, playerWand, 100);
        displayCharacterSummary(player, playerPet);

        displayMessageWithDelay("\nYou are now ready to embark on your adventure in the Wizarding World of Harry Potter!", 2);
        clearScreen();

        displayMessageWithDelay("----LEVEL I----",2);
        Level1 level1 = new Level1();
        level1.startLevel(player, scanner);



        clearScreen();
        displayMessageWithDelay("----LEVEL II----",2);
        Level2 level2 = new Level2();
        level2.startLevel(player, scanner, playerHouse.getName());
    }

    private static void displayMessageWithDelay(String message, int seconds) {
        System.out.println(message);
        sleep(seconds);
    }

    private static String promptForInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    private static Pet choosePet() {
        System.out.println("Choose your pet:");
        System.out.println("1. Owl");
        System.out.println("2. Cat");
        System.out.println("3. Toad");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                return new Pet("Owl");
            case 2:
                return new Pet("Cat");
            case 3:
                return new Pet("Toad");
            default:
                System.out.println("Invalid choice. You will receive a random pet.");
                return Pet.generateRandomPet();
        }
    }

    private static void displayCharacterSummary(Wizard player, Pet playerPet) {
        clearScreen();
        displayMessageWithDelay("Character summary:\n", 1);
        System.out.println("Name: " + player.getName());
        System.out.println("House: " + player.getHouse().getName());
        System.out.println("Wand: " + player.getWand().getCore() + " core, " + player.getWand().getWood() + " wood, " + player.getWand().getLength() + " inches long");

        System.out.println("Pet: " + playerPet.getName());
        sleep(4);
    }

    static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
