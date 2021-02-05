package pl.pjatk.RPGAdventureGame.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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

    @PutMapping("/{player_id}/{monster_id}")
    public ResponseEntity<Void> attack(@PathVariable Integer player_id, @PathVariable Integer monster_id) {
        attackService.attack(player_id, monster_id);
        return ResponseEntity.ok().build();
    }
}
