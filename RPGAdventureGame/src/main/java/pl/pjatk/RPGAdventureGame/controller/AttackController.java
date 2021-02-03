package pl.pjatk.RPGAdventureGame.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.RPGAdventureGame.model.Player;
import pl.pjatk.RPGAdventureGame.service.AttackService;

@RestController
@RequestMapping("/player/attack")
public class AttackController {

    private AttackService attackService;

    public AttackController(AttackService attackService) {
        this.attackService = attackService;
    }

//    @PutMapping("/{id}/{id}")
//    public ResponseEntity<Player> attack() {
//        return ResponseEntity.ok();
//    }
}
