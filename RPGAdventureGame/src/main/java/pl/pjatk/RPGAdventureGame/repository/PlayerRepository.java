package pl.pjatk.RPGAdventureGame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pjatk.RPGAdventureGame.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

}
