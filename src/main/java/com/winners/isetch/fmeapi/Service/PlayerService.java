package com.winners.isetch.fmeapi.Service;

import com.winners.isetch.fmeapi.Entity.Player;
import com.winners.isetch.fmeapi.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;



    public List<Player> getPlayers() {
        List<Player> lp=new ArrayList<>();
        playerRepository.findAll()
                .forEach(lp::add);
        return lp;
    }

    public Player getPlayer(int id){
       
        return playerRepository.findById(id).get();

    }
    public List<Player> getPlayersByTeamId(int id){
        return playerRepository.findByActualTeamId(id);

    }

    public void addPlayer(Player player){
        playerRepository.save(player);
    }

    public void editPlayer(Player player, int id) {

        playerRepository.save(player);
    }

    public void deletePlayer(int id) {

        playerRepository.deleteById(id);
    }
}
