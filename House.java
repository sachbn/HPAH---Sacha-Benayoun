package org.sachabenayoun;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import java.util.Random;

@Getter
@Setter
@AllArgsConstructor
public class House {
    private String name;
    private String description;
    private double damageModifier;
    private double healModifier;
    private double precisionModifier;
    private double resistanceModifier;

    public static House SortingHat() {
        String[] houseNames = {"Gryffindor", "Hufflepuff", "Ravenclaw", "Slytherin"};
        Random random = new Random();
        String randomHouseName = houseNames[random.nextInt(houseNames.length)];

        switch (randomHouseName) {
            case "Gryffindor":
                return new House("Gryffindor",
                        "Gryffindor members are brave and resilient.",
                        1, 1, 1, 1.1);
            case "Hufflepuff":
                return new House("Hufflepuff",
                        "Hufflepuff members are dedicated and hardworking.",
                        1, 1.1, 1, 1);
            case "Ravenclaw":
                return new House("Ravenclaw",
                        "Ravenclaw members are intelligent and wise.",
                        1, 1, 1.1, 1);
            case "Slytherin":
                return new House("Slytherin",
                        "Slytherin members are cunning and ambitious.",
                        1.1, 1, 1, 1);
            default:
                throw new IllegalStateException("Unexpected value: " + randomHouseName);
        }
    }
}
