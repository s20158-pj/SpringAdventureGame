package pl.pjatk.RPGAdventureGame.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.RPGAdventureGame.model.monsters.Monster;
import pl.pjatk.RPGAdventureGame.service.MonsterService;

import java.util.List;

@RestController
@RequestMapping("/monster")
public class MonsterController {

    private MonsterService monsterService;

    public MonsterController(MonsterService monsterService) {
        this.monsterService = monsterService;
    }

    @GetMapping
    public ResponseEntity<List<Monster>> findAll() {
        return ResponseEntity.ok(monsterService.findAll());
    }

    @PostMapping("/{name}/{level}")
    public ResponseEntity<Monster> save(@PathVariable String name, @PathVariable Integer level) throws Exception {
        return ResponseEntity.ok(monsterService.save(name, level));
    }
}
