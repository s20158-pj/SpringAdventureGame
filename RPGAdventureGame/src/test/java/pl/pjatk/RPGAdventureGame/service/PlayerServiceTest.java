package pl.pjatk.RPGAdventureGame.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.pjatk.RPGAdventureGame.model.Player;
import pl.pjatk.RPGAdventureGame.repository.PlayerRepository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PlayerServiceTest {

    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private PlayerService playerService;

    @Test
    void isPlayerRepositoryEmpty() {
        when(playerRepository.findAll()).thenReturn(List.of(new Player()));

        List<Player> all = playerService.findAll();

        assertThat(all).isNotEmpty();
    }

}
