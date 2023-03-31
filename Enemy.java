package org.sachabenayoun;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
public class Enemy {
    private String name;
    private int health;
    private int maxHealth;
    @Getter
    private int attackDamage;

    public void takeDamage(int damage) {
        health -= damage;
        System.out.println(name + " took " + damage + " damage. Health remaining: " + health);
    }

    public boolean isDefeated() {
        return health <= 0;
    }
}