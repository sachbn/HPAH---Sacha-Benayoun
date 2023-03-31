package org.sachabenayoun;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import java.util.Random;

@Getter
@Setter
@AllArgsConstructor
public class Pet {
    private String name;

    public static Pet generateRandomPet() {
        String[] petNames = {"Owl", "Raven", "Cat"};
        Random random = new Random();

        String randomPetName = petNames[random.nextInt(petNames.length)];

        return new Pet(randomPetName);
    }
}

// Pet playerPet = Pet.generateRandomPet();
// System.out.println("Player's pet: " + playerPet.getName());