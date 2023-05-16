package org.sachabenayoun;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import java.util.Random;

@Getter
@Setter
@AllArgsConstructor
public class Wand {
    private String core;
    private String wood;
    private double length;

    public static Wand generateRandomWand() {
        String[] cores = {"phoenix feather", "dragon heartstring", "unicorn hair"};
        String[] woods = {"oak", "mahogany", "ash", "maple", "holly"};
        Random random = new Random();

        String randomCore = cores[random.nextInt(cores.length)];
        String randomWood = woods[random.nextInt(woods.length)];
        double randomLength = random.nextInt(8,12);

        return new Wand(randomCore, randomWood, randomLength);
    }
}

// Wand playerWand = Wand.generateRandomWand();
// System.out.println("Player's wand: " + playerWand.getWood() + " wood with a " + playerWand.getCore() + " core, " + playerWand.getLength() + " inches long.");