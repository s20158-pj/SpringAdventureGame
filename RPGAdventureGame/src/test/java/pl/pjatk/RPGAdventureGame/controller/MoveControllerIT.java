package pl.pjatk.RPGAdventureGame.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import pl.pjatk.RPGAdventureGame.model.Player;
import pl.pjatk.RPGAdventureGame.service.MoveService;
import pl.pjatk.RPGAdventureGame.service.PlayerService;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MoveControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private MoveService moveService;

//    @AfterEach
//    void afterEach() {
//        playerService.delete(1);
//    }

    @Test
    void movedNorth() throws Exception {
        playerService.save(new Player("zbyniu", 1, 2, 3, 4, 5, 6, 7));


        mockMvc.perform(put("/player/move/1/N"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"id\":1,\"name\":\"zbyniu\",\"health\":1,\"attack\":2,\"mana\":3,\"money\":4,\"experience\":5,\"xCoor\":6,\"yCoor\":6}")));
    }

    @Test
    void movedSouth() throws Exception {
        playerService.save(new Player("zbyniu", 1, 2, 3, 4, 5, 6, 7));


        mockMvc.perform(put("/player/move/1/S"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"id\":1,\"name\":\"zbyniu\",\"health\":1,\"attack\":2,\"mana\":3,\"money\":4,\"experience\":5,\"xCoor\":6,\"yCoor\":8}")));
    }

    @Test
    void movedWest() throws Exception {
        playerService.save(new Player("zbyniu", 1, 2, 3, 4, 5, 6, 7));


        mockMvc.perform(put("/player/move/1/W"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"id\":1,\"name\":\"zbyniu\",\"health\":1,\"attack\":2,\"mana\":3,\"money\":4,\"experience\":5,\"xCoor\":5,\"yCoor\":7}")));
    }

    @Test
    void movedEast() throws Exception {
        playerService.save(new Player("zbyniu", 1, 2, 3, 4, 5, 6, 7));


        mockMvc.perform(put("/player/move/1/E"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"id\":1,\"name\":\"zbyniu\",\"health\":1,\"attack\":2,\"mana\":3,\"money\":4,\"experience\":5,\"xCoor\":7,\"yCoor\":7}")));
    }

}
