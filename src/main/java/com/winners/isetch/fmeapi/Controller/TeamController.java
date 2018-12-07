package com.winners.isetch.fmeapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.winners.isetch.fmeapi.Entity.Player;
import com.winners.isetch.fmeapi.Entity.Team;
import com.winners.isetch.fmeapi.Service.TeamService;
import com.winners.isetch.fmeapi.exceptions.exceptionTeam.AddTeamException;
import com.winners.isetch.fmeapi.exceptions.exceptionTeam.DeleteAllException;
import com.winners.isetch.fmeapi.exceptions.exceptionTeam.DeleteTeamException;
import com.winners.isetch.fmeapi.exceptions.exceptionTeam.EditTeamException;
import com.winners.isetch.fmeapi.exceptions.exceptionTeam.GetListTeamException;
import com.winners.isetch.fmeapi.exceptions.exceptionTeam.GetTeamByIdException;


@RestController
public class TeamController {
	 static final String[] crossOriginUrl = {"http://localhost:4200", "http://localhost:8100"};
	
	@Autowired
    private TeamService teamService;
	
	
	
    @RequestMapping("/team")
	@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8100"})
	public List<Team> getAllTeams() {
		List<Team> lt=null;
		try {
			lt=teamService.getTeams();
		} catch (GetListTeamException e) {
			System.out.println(e.getMessage());
		}
		return lt;
		
	}

    @RequestMapping("/teamP/{id}")
  	@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8100"})
  	public List<Player> getTeamPlayers(int id) {
  		List<Player> lt=null;
  		
  			lt=teamService.getTeamPlayers(id);
  		
  		return lt;
  		
  	}
    
    @RequestMapping("/team/{id}")
	@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8100"})
	public Team getTeamById(@PathVariable int id) {
		Team tm=null;	
		try {
				tm= teamService.getTeam(id);
			} catch (GetTeamByIdException e) {
				
				System.out.println(e.getMessage());
			}
		return tm;
		
	}

    @RequestMapping(method = RequestMethod.POST,value="/team")
	@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8100"})
	public void addTeam(@RequestBody Team team) {
		
		try {
			teamService.addTeam(team);
		} catch (AddTeamException e) {
			System.out.println(e.getMessage());
		}
	}

    @RequestMapping(method = RequestMethod.PUT,value="/team/{id}")
	@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8100"})
	public void editTeam(@RequestBody Team team, @PathVariable int id) {
		try {
			teamService.editTeam(team, id);
		} catch (EditTeamException e) {
			System.out.println(e.getMessage());
		}
	}

    @RequestMapping(method = RequestMethod.DELETE,value="/team/{id}")
	@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8100"})
	public void deleteTeam(@PathVariable int id) {
		try {
			teamService.deleteTeam(id);
		} catch (DeleteTeamException e) {
			System.out.println(e.getMessage());
		}
	}
    
    
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteAllTeams")
	@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8100"})
	public void deleteAllTeams() {
		try {
			teamService.deleteAllTeams();
		} catch (DeleteAllException e) {
			System.out.println(e.getMessage());
		}
	}

	public TeamService getTeamService() {
		return teamService;
	}

	public void setTeamService(TeamService teamService) {
		this.teamService =teamService;
	}

	@RequestMapping(method = RequestMethod.GET,value="/team/name")
	@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8100"})
	public List<Team> getTeamByIdNameContaining(@RequestParam("name") String name) {
		return teamService.getTeamByNameContaining(name);
		//teamService.gettingString(name);
	}
}
