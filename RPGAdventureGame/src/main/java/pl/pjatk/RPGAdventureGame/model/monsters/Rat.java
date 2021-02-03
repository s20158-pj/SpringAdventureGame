package pl.pjatk.RPGAdventureGame.model.monsters;

import javax.persistence.Entity;

@Entity
public class Rat extends Monster {

    public Rat() {
    }

    public Rat(int level) {
        this.name = "Rat";
        this.level = level;
        this.health = 7 * level;
        this.attack = 3 * level;
        this.money = 5 * level;
        this.experience = 8 * level;
    }
}
