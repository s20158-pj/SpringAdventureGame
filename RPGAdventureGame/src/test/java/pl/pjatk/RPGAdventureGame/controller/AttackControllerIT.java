package pl.pjatk.RPGAdventureGame.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import pl.pjatk.RPGAdventureGame.model.Player;
import pl.pjatk.RPGAdventureGame.model.monsters.Monster;
import pl.pjatk.RPGAdventureGame.model.monsters.Rat;
import pl.pjatk.RPGAdventureGame.service.MonsterService;
import pl.pjatk.RPGAdventureGame.service.PlayerService;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AttackControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AttackController attackController;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private MonsterService monsterService;

    @Test
    void wasAttacked() throws Exception {
        playerService.save(new Player("zbyniu", 1, 2, 3, 4, 5, 6, 7));
        monsterService.save("Rat", 2);


        mockMvc.perform(put("/player/attack/1/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }


}
