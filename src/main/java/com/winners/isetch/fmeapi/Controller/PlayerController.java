package com.winners.isetch.fmeapi.Controller;

import com.winners.isetch.fmeapi.Entity.Player;
import com.winners.isetch.fmeapi.Service.PlayerService;
import com.winners.isetch.fmeapi.exceptionPlayer.AddPlayerException;
import com.winners.isetch.fmeapi.exceptionPlayer.DeleteAllException;
import com.winners.isetch.fmeapi.exceptionPlayer.DeletePlayerException;
import com.winners.isetch.fmeapi.exceptionPlayer.EditPlayerException;
import com.winners.isetch.fmeapi.exceptionPlayer.GetListPlayerException;
import com.winners.isetch.fmeapi.exceptionPlayer.GetPlayerByIdException;

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
	public Player getPlayerById(@PathVariable int id) {
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
	public boolean addPlayer(@RequestBody Player player) {
		
		try {
			playerService.addPlayer(player);
			return true;
		} catch (AddPlayerException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

    @RequestMapping(method = RequestMethod.PUT,value="/player/{id}")
	@CrossOrigin(origins = crossOriginUrl)
	public boolean editPlayer(@RequestBody Player player, @PathVariable int id) {
		try {
			playerService.editPlayer(player, id);
			return true;
		} catch (EditPlayerException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

    @RequestMapping(method = RequestMethod.DELETE,value="/player/{id}")
	@CrossOrigin(origins = crossOriginUrl)
	public boolean deletePlayer(@PathVariable int id) {
		try {
			playerService.deletePlayer(id);
			return true;
		} catch (DeletePlayerException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteAllPlayers")
	@CrossOrigin(origins = crossOriginUrl)
	public boolean deleteAllPlayers() {
		try {
			playerService.deleteAllPlayers();
			return true;
		} catch (DeleteAllException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public PlayerService getPlayerService() {
		return playerService;
	}

	public void setPlayerService(PlayerService playerService) {
		this.playerService = playerService;
	}

}