package pl.pjatk.RPGAdventureGame.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.pjatk.RPGAdventureGame.model.Player;
import pl.pjatk.RPGAdventureGame.repository.PlayerRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MoveServiceTest {

    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private MoveService moveService;

    @Test
    void didGoUp() throws Exception {
        Player player = new Player("Zbyniu", 1, 2, 3, 4, 5, 6, 7);
        when(playerRepository.findById(1)).thenReturn(Optional.of(player));
        when(playerRepository.save(player)).thenReturn(player);

        Player movedNorthPlayer = moveService.move(1, "N");

        assertThat(movedNorthPlayer.getyCoor()).isEqualTo(6);
    }

    @Test
    void didGoUpTwice() throws Exception {
        Player player = new Player("Zbyniu", 1, 2, 3, 4, 5, 6, 7);
        when(playerRepository.findById(1)).thenReturn(Optional.of(player));
        when(playerRepository.save(player)).thenReturn(player);

        Player movedNorthPlayer = moveService.move(1, "N");
        movedNorthPlayer = moveService.move(1, "N");

        assertThat(movedNorthPlayer.getyCoor()).isEqualTo(5);
    }

    @Test
    void didGoDown() throws Exception {
        Player player = new Player("Zbyniu", 1, 2, 3, 4, 5, 6, 7);
        when(playerRepository.findById(1)).thenReturn(Optional.of(player));
        when(playerRepository.save(player)).thenReturn(player);

        Player movedSouthPlayer = moveService.move(1, "S");

        assertThat(movedSouthPlayer.getyCoor()).isEqualTo(8);
    }

    @Test
    void didGoDownTwice() throws Exception {
        Player player = new Player("Zbyniu", 1, 2, 3, 4, 5, 6, 7);
        when(playerRepository.findById(1)).thenReturn(Optional.of(player));
        when(playerRepository.save(player)).thenReturn(player);

        Player movedSouthPlayer = moveService.move(1, "S");
        movedSouthPlayer = moveService.move(1, "S");

        assertThat(movedSouthPlayer.getyCoor()).isEqualTo(9);
    }

    @Test
    void didGoWest() throws Exception {
        Player player = new Player("Zbyniu", 1, 2, 3, 4, 5, 6, 7);
        when(playerRepository.findById(1)).thenReturn(Optional.of(player));
        when(playerRepository.save(player)).thenReturn(player);

        Player movedWestPlayer = moveService.move(1, "W");

        assertThat(movedWestPlayer.getxCoor()).isEqualTo(5);
    }

    @Test
    void didGoWestTwice() throws Exception {
        Player player = new Player("Zbyniu", 1, 2, 3, 4, 5, 6, 7);
        when(playerRepository.findById(1)).thenReturn(Optional.of(player));
        when(playerRepository.save(player)).thenReturn(player);

        Player movedWestPlayer = moveService.move(1, "W");
        movedWestPlayer = moveService.move(1, "W");

        assertThat(movedWestPlayer.getxCoor()).isEqualTo(4);
    }

    @Test
    void didGoEast() throws Exception {
        Player player = new Player("Zbyniu", 1, 2, 3, 4, 5, 6, 7);
        when(playerRepository.findById(1)).thenReturn(Optional.of(player));
        when(playerRepository.save(player)).thenReturn(player);

        Player movedEastPlayer = moveService.move(1, "E");

        assertThat(movedEastPlayer.getxCoor()).isEqualTo(7);
    }

    @Test
    void didGoEastTwice() throws Exception {
        Player player = new Player("Zbyniu", 1, 2, 3, 4, 5, 6, 7);
        when(playerRepository.findById(1)).thenReturn(Optional.of(player));
        when(playerRepository.save(player)).thenReturn(player);

        Player movedEastPlayer = moveService.move(1, "E");
        movedEastPlayer = moveService.move(1, "E");

        assertThat(movedEastPlayer.getxCoor()).isEqualTo(8);
    }

}
