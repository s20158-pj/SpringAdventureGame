package pl.pjatk.RPGAdventureGame.service;

import org.springframework.stereotype.Service;
import pl.pjatk.RPGAdventureGame.model.Player;
import pl.pjatk.RPGAdventureGame.model.monsters.Monster;
import pl.pjatk.RPGAdventureGame.repository.MonsterRepository;
import pl.pjatk.RPGAdventureGame.repository.PlayerRepository;

@Service
public class AttackService {

    private PlayerRepository playerRepository;
    private MonsterRepository monsterRepository;

    public AttackService(PlayerRepository playerRepository, MonsterRepository monsterRepository) {
        this.playerRepository = playerRepository;
        this.monsterRepository = monsterRepository;
    }

    public void attack(Player player, Monster monster) {
        player.setHealth(player.getHealth() - monster.getAttack());
        monster.setHealth(monster.getHealth() - player.getAttack());
        if (player.getHealth() <= 0 ) {
            playerRepository.delete(player);
            monsterRepository.save(monster);
        } else if (monster.getHealth() <= 0 ){
            player.setExperience(monster.getExperience());
            player.setMoney(monster.getMoney());
            monsterRepository.delete(monster);
            playerRepository.save(player);
        } else {
            attack(player, monster);
        }
    }

}
