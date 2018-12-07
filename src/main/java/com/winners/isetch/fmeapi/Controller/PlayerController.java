package com.winners.isetch.fmeapi.Controller;

import com.winners.isetch.fmeapi.Entity.Player;
import com.winners.isetch.fmeapi.Service.PlayerService;
import com.winners.isetch.fmeapi.exceptions.exceptionPlayer.AddPlayerException;
import com.winners.isetch.fmeapi.exceptions.exceptionPlayer.DeleteAllException;
import com.winners.isetch.fmeapi.exceptions.exceptionPlayer.DeletePlayerException;
import com.winners.isetch.fmeapi.exceptions.exceptionPlayer.EditPlayerException;
import com.winners.isetch.fmeapi.exceptions.exceptionPlayer.GetListPlayerException;
import com.winners.isetch.fmeapi.exceptions.exceptionPlayer.GetPlayerByIdException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {
	//static final String crossOriginUrl = "http://localhost:8100";
	static final String crossOriginUrl = "http://localhost:4200";

    @Autowired
    private PlayerService playerService;


    @RequestMapping("/player")
	@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8100"})
	public List<Player> getAllPlayers() {
		List<Player> lp=null;
		try {
			lp=playerService.getPlayers();
		} catch (GetListPlayerException e) {
			System.out.println(e.getMessage());
		}
		return lp;
		
	}
	@RequestMapping("/player/team/{id}")
	@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8100"})
	public List<Player> getPlayersByTeamId(@PathVariable int id) throws GetListPlayerException {
		List<Player> lp=null;

			lp=playerService.getPlayersByTeamId(id);

		return lp;

	}

    @RequestMapping("/player/{id}")
	@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8100"})
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
	@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8100"})
	public void addPlayer(@RequestBody Player player) {
		
		try {
			playerService.addPlayer(player);
		} catch (AddPlayerException e) {
			System.out.println(e.getMessage());
		}
	}

    @RequestMapping(method = RequestMethod.PUT,value="/player/{id}")
	@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8100"})
	public void editPlayer(@RequestBody Player player, @PathVariable int id) {
		try {
			playerService.editPlayer(player, id);
		} catch (EditPlayerException e) {
			System.out.println(e.getMessage());
		}
	}

    @RequestMapping(method = RequestMethod.DELETE,value="/player/{id}")
	@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8100"})
	public void deletePlayer(@PathVariable int id) {
		try {
			playerService.deletePlayer(id);
		} catch (DeletePlayerException e) {
			System.out.println(e.getMessage());
		}
	}
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteAllPlayers")
	@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8100"})
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