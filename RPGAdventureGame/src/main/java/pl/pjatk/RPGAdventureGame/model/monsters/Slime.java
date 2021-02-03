package pl.pjatk.RPGAdventureGame.model.monsters;

import javax.persistence.Entity;

@Entity
public class Slime extends Monster {

    public Slime() {
    }

    public Slime(int level) {
        this.name = "Slime";
        this.level = level;
        this.health = 5 * level;
        this.attack = 2 * level;
        this.money = 3 * level;
        this.experience = 4 * level;
    }
}
