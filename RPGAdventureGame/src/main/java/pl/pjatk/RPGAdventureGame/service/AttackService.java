package pl.pjatk.RPGAdventureGame.service;

import org.springframework.stereotype.Service;
import pl.pjatk.RPGAdventureGame.model.Player;
import pl.pjatk.RPGAdventureGame.model.monsters.Monster;
import pl.pjatk.RPGAdventureGame.repository.MonsterRepository;
import pl.pjatk.RPGAdventureGame.repository.PlayerRepository;

import java.util.Optional;

@Service
public class AttackService {

    private PlayerRepository playerRepository;
    private MonsterRepository monsterRepository;

    public AttackService(PlayerRepository playerRepository, MonsterRepository monsterRepository) {
        this.playerRepository = playerRepository;
        this.monsterRepository = monsterRepository;
    }

    public void attack(Integer player_id, Integer monster_id) {
        Optional<Player> attackingPlayer = playerRepository.findById(player_id);
        Optional<Monster> attackedMonster = monsterRepository.findById(monster_id);

        if (attackingPlayer.isPresent() && attackedMonster.isPresent()) {
            Player player = attackingPlayer.get();
            Monster monster = attackedMonster.get();

            player.setHealth(player.getHealth() - monster.getAttack());
            monster.setHealth(monster.getHealth() - player.getAttack());
            playerRepository.save(player);
            monsterRepository.save(monster);
            if (player.getHealth() <= 0 ) {
                playerRepository.delete(player);
                monsterRepository.delete(monster);
            } else if (monster.getHealth() <= 0 ){
                player.setExperience(monster.getExperience());
                player.setMoney(monster.getMoney());
                monsterRepository.delete(monster);
                playerRepository.save(player);
            } else {
                attack(player_id, monster_id);
            }
        }


    }

}
