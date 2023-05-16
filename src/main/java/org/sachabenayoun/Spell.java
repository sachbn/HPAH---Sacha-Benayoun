package org.sachabenayoun;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
public class Spell {
    private String name;
    private int spellDamage;
    private int precision;

    public void increaseDamage(int amount) {
        this.spellDamage += amount;
    }
}

/* List<Spell> spells = new ArrayList<>();
        spells.add(new Spell("Stupefy", 10, 90));
        spells.add(new Spell("Incendio", 30, 70)); */