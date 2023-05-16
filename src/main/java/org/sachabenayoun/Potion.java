package org.sachabenayoun;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
public class Potion {
    private String name;
    private int healingPoints;
}

/*List<Potion> potions = new ArrayList<>();
        potions.add(new Potion("Blue Potion", 20));
        potions.add(new Potion("Green Potion", 50));*/