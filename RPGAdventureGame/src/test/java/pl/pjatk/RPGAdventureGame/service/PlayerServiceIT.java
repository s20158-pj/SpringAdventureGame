package pl.pjatk.RPGAdventureGame.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.pjatk.RPGAdventureGame.model.Player;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PlayerServiceIT {

    @Autowired
    private PlayerService playerService;

    @Test
    void isEmpty() {
        List<Player> all = playerService.findAll();

        assertThat(all).isEmpty();
    }

    @Test
    void wasFound() {
        Player player = new Player("zbyniu", 1, 2, 3, 4, 5, 6, 7);
        Player save = playerService.save(player);
        Optional<Player> optionalPlayer = playerService.findByID(1);

        assertThat(optionalPlayer).isPresent();
    }

    @Test
    void isSavedInDb() {
        Player player = new Player("zbyniu", 1, 2, 3, 4, 5, 6, 7);
        Player save = playerService.save(player);

        assertThat(save).isNotNull();
    }

    @Test
    void isEmptyAfterDelete() {
        Player player = new Player("zbyniu", 1, 2, 3, 4, 5, 6, 7);
        Player save = playerService.save(player);
        playerService.delete(1);
        List<Player> allPlayers = playerService.findAll();

        assertThat(allPlayers).isEmpty();
    }


}
