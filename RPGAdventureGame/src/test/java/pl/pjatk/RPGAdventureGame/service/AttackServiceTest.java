package pl.pjatk.RPGAdventureGame.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.pjatk.RPGAdventureGame.model.Player;
import pl.pjatk.RPGAdventureGame.model.monsters.Monster;
import pl.pjatk.RPGAdventureGame.model.monsters.Rat;
import pl.pjatk.RPGAdventureGame.repository.MonsterRepository;
import pl.pjatk.RPGAdventureGame.repository.PlayerRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AttackServiceTest {

    @Mock
    private PlayerRepository playerRepository;

    @Mock
    private MonsterRepository monsterRepository;

    @InjectMocks
    private AttackService attackService;

    @Test
    void didWon() {
        Player player = new Player("Zbyniu", 1000, 20, 3, 0, 0, 6, 7);
        Monster monster = new Rat(1);
        when(playerRepository.findById(1)).thenReturn(Optional.of(player));
        when(monsterRepository.findById(1)).thenReturn(Optional.of(monster));
        when(playerRepository.save(player)).thenReturn(player);
        when(monsterRepository.save(monster)).thenReturn(monster);
        when(playerRepository.save(player)).thenReturn(player);

        attackService.attack(1, 1);

        assertThat(player).isNotNull();
    }

    @Test
    void isPlayerHealthCorrect() {
        Player player = new Player("Zbyniu", 1000, 20, 3, 0, 0, 6, 7);
        Monster monster = new Rat(1);
        when(playerRepository.findById(1)).thenReturn(Optional.of(player));
        when(monsterRepository.findById(1)).thenReturn(Optional.of(monster));
        when(playerRepository.save(player)).thenReturn(player);
        when(monsterRepository.save(monster)).thenReturn(monster);
        when(playerRepository.save(player)).thenReturn(player);

        attackService.attack(1, 1);

        assertThat(player.getHealth()).isEqualTo(997);
    }

    @Test
    void isPlayerMoneyCorrect() {
        Player player = new Player("Zbyniu", 1000, 20, 3, 0, 0, 6, 7);
        Monster monster = new Rat(2);
        when(playerRepository.findById(1)).thenReturn(Optional.of(player));
        when(monsterRepository.findById(1)).thenReturn(Optional.of(monster));
        when(playerRepository.save(player)).thenReturn(player);
        when(monsterRepository.save(monster)).thenReturn(monster);
        when(playerRepository.save(player)).thenReturn(player);

        attackService.attack(1, 1);

        assertThat(player.getMoney()).isEqualTo(10);
    }

    @Test
    void isPlayerExperienceCorrect() {
        Player player = new Player("Zbyniu", 1000, 20, 3, 0, 0, 6, 7);
        Monster monster = new Rat(2);
        when(playerRepository.findById(1)).thenReturn(Optional.of(player));
        when(monsterRepository.findById(1)).thenReturn(Optional.of(monster));
        when(playerRepository.save(player)).thenReturn(player);
        when(monsterRepository.save(monster)).thenReturn(monster);
        when(playerRepository.save(player)).thenReturn(player);

        attackService.attack(1, 1);

        assertThat(player.getExperience()).isEqualTo(16);
    }


}
