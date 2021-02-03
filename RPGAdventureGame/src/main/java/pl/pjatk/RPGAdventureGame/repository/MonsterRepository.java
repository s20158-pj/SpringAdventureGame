package pl.pjatk.RPGAdventureGame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.RPGAdventureGame.model.monsters.Monster;

public interface MonsterRepository extends JpaRepository<Monster, Integer> {
}
