package org.sachabenayoun;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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