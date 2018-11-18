package com.winners.isetch.fmeapi.Controller;

import com.winners.isetch.fmeapi.Entity.Player;
import com.winners.isetch.fmeapi.Service.PlayerService;
import com.winners.isetch.fmeapi.exception.exceptionPlayer.AddPlayerException;
import com.winners.isetch.fmeapi.exception.exceptionPlayer.DeleteAllException;
import com.winners.isetch.fmeapi.exception.exceptionPlayer.DeletePlayerException;
import com.winners.isetch.fmeapi.exception.exceptionPlayer.EditPlayerException;
import com.winners.isetch.fmeapi.exception.exceptionPlayer.GetListPlayerException;
import com.winners.isetch.fmeapi.exception.exceptionPlayer.GetPlayerByIdException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {
	static final String crossOriginUrl = "http://localhost:4200";

    @Autowired
    private PlayerService playerService;


    @RequestMapping("/player")	
    @CrossOrigin(origins = crossOriginUrl)
	public List<Player> getAllPlayers() {
		List<Player> lp=null;
		try {
			lp=playerService.getPlayers();
		} catch (GetListPlayerException e) {
			System.out.println(e.getMessage());
		}
		return lp;
		
	}

		@RequestMapping("/player/{id}")
		@CrossOrigin(origins = crossOriginUrl)
		public Player getPlayerById(@PathVariable int id){
		Player p=null;	
		try {
				p= playerService.getPlayer(id);
			} catch (GetPlayerByIdException e) {
				
				System.out.println(e.getMessage());
			}
		return p;
		
	}

		@RequestMapping(method = RequestMethod.POST,value="/player")
        @CrossOrigin(origins = crossOriginUrl)
		public void addPlayer(@RequestBody Player player){
		
		try {
			playerService.addPlayer(player);
		} catch (AddPlayerException e) {
			System.out.println(e.getMessage());
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/editPlayer")
	@CrossOrigin(origins = crossOriginUrl)
	public void editPlayer(@RequestBody Player player, @RequestParam int id) {
		try {
			playerService.editPlayer(player, id);
		} catch (EditPlayerException e) {
			System.out.println(e.getMessage());
		}
	}

	@RequestMapping(method = RequestMethod.DELETE,value="/player/{id}")
    @CrossOrigin(origins = crossOriginUrl)
	public void deletePlayer(@PathVariable int id) {
		try {
			playerService.deletePlayer(id);
		} catch (DeletePlayerException e) {
			System.out.println(e.getMessage());
		}
	}
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteAllPlayers")
	@CrossOrigin(origins = crossOriginUrl)
	public void deleteAllPlayers() {
		try {
			playerService.deleteAllPlayers();
		} catch (DeleteAllException e) {
			System.out.println(e.getMessage());
		}
	}

	public PlayerService getPlayerService() {
		return playerService;
	}

	public void setPlayerService(PlayerService playerService) {
		this.playerService = playerService;
	}

}