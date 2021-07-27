package fatin.kazi.cdl.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PlayerService {

    @Autowired
    PlayerRepository playerRepo;

    public List<Player> listAllPlayer(){
        return (List<Player>) playerRepo.findAll();
    }
    public void savePlayer(Player player){
        playerRepo.save(player);
    }
}
