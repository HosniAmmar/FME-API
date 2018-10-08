package com.winners.isetch.fmeapi.Controller;

import com.winners.isetch.fmeapi.Entity.Player;
import com.winners.isetch.fmeapi.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;


        @RequestMapping("/player")
        public List<Player> getAllPlayers(){
           return playerService.getPlayers();
        }

        @RequestMapping("/player/{id}")
        public Player getPlayerById(@PathVariable int id){
            return playerService.getPlayer(id);
        }

        @RequestMapping(method = RequestMethod.POST,value="/player")
        public void addPlayer(@RequestBody Player player){
            playerService.addPlayer(player);
        }
        @RequestMapping(method = RequestMethod.PUT,value="/player/{id}")
            public void editPlayer(@RequestBody Player player,@PathVariable int id){
                playerService.editPlayer(player,id);
            }
    @RequestMapping(method = RequestMethod.DELETE,value="/player/{id}")
    public void deletePlayer(@PathVariable int id){
        playerService.deletePlayer(id);
    }
}
