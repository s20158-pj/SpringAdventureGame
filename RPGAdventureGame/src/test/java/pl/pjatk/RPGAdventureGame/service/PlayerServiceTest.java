package pl.pjatk.RPGAdventureGame.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.pjatk.RPGAdventureGame.model.Player;
import pl.pjatk.RPGAdventureGame.repository.PlayerRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PlayerServiceTest {

    @Mock
    private PlayerRepository playerRepository;

//    @Mock
//    private Player player;

    @InjectMocks
    private PlayerService playerService;

    @Test
    void isPlayerRepositoryEmpty() {
        when(playerRepository.findAll()).thenReturn(List.of(new Player()));

        List<Player> all = playerService.findAll();

        assertThat(all).isNotEmpty();
    }

    @Test
    void findById() {
        when(playerRepository.findById(1)).thenReturn(Optional.of(new Player()));

        Optional<Player> player = playerRepository.findById(1);

        assertThat(player).isNotEmpty();
    }

    @Test
    void wasDeleted() {
        playerRepository.deleteById(1);

        verify(playerRepository, times(1)).deleteById(1);
    }

    @Test
    void isSaved() {
        Player player = new Player("zbyniu", 1, 2, 3, 4, 5, 6, 7);
        when(playerRepository.save(player)).thenReturn(player);

        Player savedPlayer = playerRepository.save(player);

        assertThat(savedPlayer.getId()).isEqualTo(player.getId());
    }

    @Test
    void didRestOneTime() {
        Player player = new Player("Zbyniu", 1, 2, 3, 4, 5, 6, 7);
        when(playerRepository.findById(1)).thenReturn(Optional.of(player));
        when(playerRepository.save(player)).thenReturn(player);

        Player restedPlayer = playerService.rest(1);

        assertThat(restedPlayer.getHealth()).isEqualTo(51);
    }

    @Test
    void didRestTwoTimes() {
        Player player = new Player("Zbyniu", 1, 2, 3, 4, 5, 6, 7);
        when(playerRepository.findById(1)).thenReturn(Optional.of(player));
        when(playerRepository.save(player)).thenReturn(player);


        Player restedPlayer = playerService.rest(1);
        Player doubleRestedPlayer = playerService.rest(1);

        assertThat(doubleRestedPlayer.getHealth()).isEqualTo(101);
    }

//    @Test
//    void didRestTwoTimes() {
//        when(playerRepository.findById(player.getId())).thenReturn(Optional.of(player));
//        when(playerRepository.save(player)).thenReturn(player);
//        when(player.getHealth()).thenReturn(50);
//
//        Player restedPlayer = playerService.rest(player.getId());
//
//        assertThat(restedPlayer.getHealth()).isEqualTo(player.getHealth());
//    }

}
