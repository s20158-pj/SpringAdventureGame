package pl.pjatk.RPGAdventureGame.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import pl.pjatk.RPGAdventureGame.model.Player;
import pl.pjatk.RPGAdventureGame.service.PlayerService;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PlayerControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PlayerService playerService;

    @Test
    void findAll() throws Exception {
        mockMvc.perform(get("/player"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void shouldNotFound() throws Exception {
        mockMvc.perform(get("/player/1"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldMatchContent() throws Exception {
        playerService.save(new Player("zbyniu", 1, 2, 3, 4, 5, 6, 7));

        mockMvc.perform(get("/player/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"id\":1,\"name\":\"zbyniu\",\"health\":1,\"attack\":2,\"mana\":3,\"money\":4,\"experience\":5,\"xCoor\":6,\"yCoor\":7}")));
    }

    @Test
    void didRest() throws Exception {
        playerService.save(new Player("zbyniu", 1, 2, 3, 4, 5, 6, 7));

        mockMvc.perform(put("/player/1/rest"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void didRestCorrectly() throws Exception {
        playerService.save(new Player("zbyniu", 1, 2, 3, 4, 5, 6, 7));
        playerService.rest(1);

        mockMvc.perform(get("/player"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"id\":1,\"name\":\"zbyniu\",\"health\":51,\"attack\":2,\"mana\":3,\"money\":4,\"experience\":5,\"xCoor\":6,\"yCoor\":7}")));
    }

    @Test
    void wasDeleted() throws Exception {
        playerService.save(new Player("zbyniu", 1, 2, 3, 4, 5, 6, 7));

        mockMvc.perform(delete("/player/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
