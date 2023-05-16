package org.sachabenayoun;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter

public class Wizard {
    private String name;
    private House house;
    private Wand wand;
    private int health;
    private int maxHealth;
    private List<Spell> learnedSpells;
    private List<Potion> potions;
    private Weapon equippedWeapon;

    public Wizard(String name, House house, Wand wand, int maxHealth) {
        this.name = name;
        this.house = house;
        this.wand = wand;
        this.health = maxHealth;
        this.maxHealth = maxHealth;
        this.learnedSpells = new ArrayList<>();
        this.potions = new ArrayList<>();
        this.equippedWeapon = null;
    }

    public List<Spell> getLearnedSpells() {
        return learnedSpells;
    }

    public void learnSpell(Spell spell) {
        learnedSpells.add(spell);
    }

    public void restoreHealth() {
        this.health = this.maxHealth;
    }

    public void addPotion(Potion potion) {
        potions.add(potion);
    }

    public boolean useSpell(Enemy enemy, Spell spell) {
        if (!learnedSpells.contains(spell)) {
            System.out.println("Spell not learned!");
            return false;
        }

        double precision = spell.getPrecision() * house.getPrecisionModifier();
        if (Math.random() * 100 <= precision) {
            int damage = (int) (spell.getSpellDamage() * house.getDamageModifier());
            enemy.takeDamage(damage);
            System.out.println("Spell hit! Dealt " + damage + " damage.");
            return true;
        } else {
            System.out.println("Spell missed!");
            return false;
        }
    }

    public void usePotion(int index) {
        if (index < 0 || index >= potions.size()) {
            System.out.println("Invalid potion index!");
            return;
        }

        Potion potion = potions.get(index);
        int healAmount = (int) (potion.getHealingPoints() * house.getHealModifier());
        health = Math.min(health + healAmount, maxHealth);
        potions.remove(index);
        System.out.println("Potion used! Healed for " + healAmount + " health.");
    }

    public void takeDamage(int damage) {
        int actualDamage = (int) (damage * house.getResistanceModifier());
        health -= actualDamage;
        System.out.println("Took " + actualDamage + " damage. Health remaining: " + health);
    }
    public void levelUp(Scanner scanner) {
        System.out.println("Congratulations! You can choose to increase your maximum health or increase the damage of all your spells.");
        System.out.println("Enter 1 to increase maximum health or 2 to increase the damage of all spells:");

        int choice = scanner.nextInt();
        if (choice == 1) {
            this.maxHealth += 10;
            System.out.println("Your maximum health has been increased by 10.");
        } else if (choice == 2) {
            for (Spell spell : this.learnedSpells) {
                spell.increaseDamage(5);
            }
            System.out.println("The damage of all your spells has been increased by 5.");
        } else {
            System.out.println("Invalid choice. No changes made.");
        }
    }
    public void equipWeapon(Weapon weapon) {
        this.equippedWeapon = weapon;
        System.out.println("You have equipped the " + weapon.getName() + ".");
    }

    public boolean attack(Enemy enemy) {
        if (equippedWeapon == null) {
            System.out.println("You have no weapon equipped.");
            return false;
        }

        int damage = equippedWeapon.getDamage();
        enemy.takeDamage(damage);
        System.out.println("You attack the " + enemy.getName() + " with the " + equippedWeapon.getName() + " and deal " + damage + " damage.");
        return true;
    }
}

/*
public class Main {
    public static void main(String[] args) {
        // ... Les instances de Spell, Potion, Enemy, Wand, Pet, et House ...

        Wizard player = new Wizard("John Doe", playerHouse, playerWand, 100);

        player.learnSpell(new Spell("Stupefy", 10, 90));
        player.addPotion(new Potion("Blue Potion", 20));

        Enemy goblin = new Enemy("Goblin", 50, 10);
        Spell stupefy = player.getLearnedSpells().get(0);

        player.useSpell(goblin, stupefy);
    }
}



 */