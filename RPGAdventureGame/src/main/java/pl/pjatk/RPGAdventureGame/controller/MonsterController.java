package pl.pjatk.RPGAdventureGame.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.RPGAdventureGame.factories.MonsterFactory;
import pl.pjatk.RPGAdventureGame.model.monsters.Monster;
import pl.pjatk.RPGAdventureGame.service.MonsterService;

import java.util.List;

@RestController
@RequestMapping("/monster")
public class MonsterController {

    private MonsterService monsterService;
    private MonsterFactory monsterFactory;

    public MonsterController(MonsterService monsterService, MonsterFactory monsterFactory) {
        this.monsterService = monsterService;
        this.monsterFactory = monsterFactory;
    }

    @GetMapping
    public ResponseEntity<List<Monster>> findAll() {
        return ResponseEntity.ok(monsterService.findAll());
    }

    @PostMapping("/{name}/{level}")
    public ResponseEntity<Monster> save(@PathVariable String name, @PathVariable Integer level) throws Exception {
        Monster monster = monsterFactory.monstFactory(name, level);
        return ResponseEntity.ok(monsterService.save(monster));
    }
}
