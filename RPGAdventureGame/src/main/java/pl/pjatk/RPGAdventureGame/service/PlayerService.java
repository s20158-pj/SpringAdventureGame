package pl.pjatk.RPGAdventureGame.service;

import org.springframework.stereotype.Service;
import pl.pjatk.RPGAdventureGame.model.Player;
import pl.pjatk.RPGAdventureGame.repository.PlayerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> findAll(){
        return playerRepository.findAll();
    }

    public Optional<Player> findByID(Integer id) {
        return playerRepository.findById(id);
    }

    public Player save(Player player) {
        return playerRepository.save(player);
    }

    public void delete(Integer id){
        playerRepository.deleteById(id);
    }

    public Player update(Integer id, Player updatedPlayer) {
        updatedPlayer.setId(id);
        return playerRepository.save(updatedPlayer);
    }

    public Player rest(Integer id) {
        Optional<Player> restedPlayer = playerRepository.findById(id);
        if (restedPlayer.isPresent()) {
            Player player = restedPlayer.get();
            player.setHealth(player.getHealth() + 50);
            return playerRepository.save(player);
        } else {
            return null;
        }

    }

}
