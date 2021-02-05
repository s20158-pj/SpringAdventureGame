package pl.pjatk.RPGAdventureGame.factories;

import org.springframework.stereotype.Component;
import pl.pjatk.RPGAdventureGame.model.monsters.Monster;
import pl.pjatk.RPGAdventureGame.model.monsters.Rat;
import pl.pjatk.RPGAdventureGame.model.monsters.Slime;

@Component
public class MonsterFactory {

    public MonsterFactory() {
    }

    public Monster monstFactory(String name, Integer level) throws Exception  {
        name = name.toLowerCase();
        switch (name) {
            case "rat":
                Rat rat = new Rat(level);
                return rat;
            case "slime":
                Slime slime = new Slime(level);
                return slime;
            default:
                throw new Exception("You hace choosen nonexisting monster");
        }
    }

}
