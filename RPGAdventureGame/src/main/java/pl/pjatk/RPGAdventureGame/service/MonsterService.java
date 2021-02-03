package pl.pjatk.RPGAdventureGame.service;

import org.springframework.stereotype.Service;
import pl.pjatk.RPGAdventureGame.factories.MonsterFactory;
import pl.pjatk.RPGAdventureGame.model.Player;
import pl.pjatk.RPGAdventureGame.model.monsters.Monster;
import pl.pjatk.RPGAdventureGame.repository.MonsterRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MonsterService {

    private MonsterRepository monsterRepository;

    public MonsterService(MonsterRepository monsterRepository) {
        this.monsterRepository = monsterRepository;
    }

    public List<Monster> findAll(){
        return monsterRepository.findAll();
    }

    public Optional<Monster> findByID(Integer id) {
        return monsterRepository.findById(id);
    }

    public Monster save(Monster monster) {
        return monsterRepository.save(monster);
    }

    public void delete(Integer id){
        monsterRepository.deleteById(id);
    }

}
