package pl.pjatk.RPGAdventureGame.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.RPGAdventureGame.model.Player;
import pl.pjatk.RPGAdventureGame.service.MoveService;

@RestController
@RequestMapping("/player/move")
public class MoveController {

    private MoveService moveService;

    public MoveController(MoveService moveService) {
        this.moveService = moveService;
    }

    @PutMapping("/{id}/{direction}")
    public ResponseEntity<Player> move(@PathVariable Integer id, @PathVariable String direction) throws Exception {
        return ResponseEntity.ok(moveService.move(id, direction));
    }


}
