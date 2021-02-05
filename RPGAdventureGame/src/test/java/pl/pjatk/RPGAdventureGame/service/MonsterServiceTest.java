package pl.pjatk.RPGAdventureGame.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.pjatk.RPGAdventureGame.model.monsters.Monster;
import pl.pjatk.RPGAdventureGame.model.monsters.Rat;
import pl.pjatk.RPGAdventureGame.model.monsters.Slime;
import pl.pjatk.RPGAdventureGame.repository.MonsterRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MonsterServiceTest {

    @Mock
    private MonsterRepository monsterRepository;

    @InjectMocks
    private MonsterService monsterService;

    @Test
    void isPlayerRepositoryEmptySlime() {
        when(monsterRepository.findAll()).thenReturn(List.of(new Slime()));

        List<Monster> all = monsterService.findAll();

        assertThat(all).isNotEmpty();
    }

    @Test
    void findByIdSlime() {
        when(monsterRepository.findById(1)).thenReturn(Optional.of(new Slime()));

        Optional<Monster> monster = monsterRepository.findById(1);

        assertThat(monster).isNotEmpty();
    }

    @Test
    void isPlayerRepositoryEmptyRat() {
        when(monsterRepository.findAll()).thenReturn(List.of(new Rat()));

        List<Monster> all = monsterService.findAll();

        assertThat(all).isNotEmpty();
    }

    @Test
    void findByIdRat() {
        when(monsterRepository.findById(1)).thenReturn(Optional.of(new Rat()));

        Optional<Monster> monster = monsterRepository.findById(1);

        assertThat(monster).isNotEmpty();
    }

    @Test
    void wasDeleted() {
        monsterRepository.deleteById(1);

        verify(monsterRepository, times(1)).deleteById(1);
    }

    @Test
    void isSavedRat() {
        Rat rat = new Rat(2);
        when(monsterRepository.save(rat)).thenReturn(rat);

        Rat savedRat = monsterRepository.save(rat);

        assertThat(savedRat.getId()).isEqualTo(rat.getId());
    }

    @Test
    void isSavedSlime() {
        Slime slime = new Slime(2);
        when(monsterRepository.save(slime)).thenReturn(slime);

        Slime savedSlime = monsterRepository.save(slime);

        assertThat(savedSlime.getId()).isEqualTo(slime.getId());
    }

}
