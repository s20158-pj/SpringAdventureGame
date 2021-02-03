package pl.pjatk.RPGAdventureGame.service;

import org.springframework.stereotype.Service;
import pl.pjatk.RPGAdventureGame.model.Player;
import pl.pjatk.RPGAdventureGame.repository.PlayerRepository;

import java.util.Optional;

@Service
public class MoveService {

    private PlayerRepository playerRepository;

    public MoveService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player move(Integer id, String direction) throws Exception {
        Optional<Player> movedPlayer = playerRepository.findById(id);
        direction = direction.toUpperCase();
        if (movedPlayer.isPresent()) {
            Player player = movedPlayer.get();
            switch (direction) {
                case "N":
                    player.setyCoor(player.getyCoor() - 1);
                    break;
                case "S":
                    player.setyCoor(player.getyCoor() + 1);
                    break;
                case "W":
                    player.setxCoor(player.getxCoor() - 1);
                    break;
                case "E":
                    player.setxCoor(player.getxCoor() + 1);
                    break;
                default:
                    throw new Exception("You should choose one of the available coordinates: N, S, W, E.");
            }
            return playerRepository.save(player);
        } else {
            return null;
        }

    }
}
