package com.winners.isetch.fmeapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.winners.isetch.fmeapi.Entity.Player;
import com.winners.isetch.fmeapi.Entity.Team;
import com.winners.isetch.fmeapi.Service.TeamService;
import com.winners.isetch.fmeapi.exceptionTeam.AddTeamException;
import com.winners.isetch.fmeapi.exceptionTeam.DeleteAllException;
import com.winners.isetch.fmeapi.exceptionTeam.DeleteTeamException;
import com.winners.isetch.fmeapi.exceptionTeam.EditTeamException;
import com.winners.isetch.fmeapi.exceptionTeam.GetListTeamException;
import com.winners.isetch.fmeapi.exceptionTeam.GetTeamByIdException;


@RestController
public class TeamController {
	static final String crossOriginUrl="http://localhost:4200";
	
	@Autowired
    private TeamService teamService;
	
	
	
    @RequestMapping("/team")
	@CrossOrigin(origins = crossOriginUrl)
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
  	@CrossOrigin(origins = crossOriginUrl)
  	public List<Player> getTeamPlayers(int id) {
  		List<Player> lt=null;
  		
  			lt=teamService.getTeamPlayers(id);
  		
  		return lt;
  		
  	}
    
    @RequestMapping("/team/{id}")
	@CrossOrigin(origins = crossOriginUrl)
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
	@CrossOrigin(origins = crossOriginUrl)
	public boolean addTeam(@RequestBody Team team) {
		
		try {
			teamService.addTeam(team);
			return true;
		} catch (AddTeamException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

    @RequestMapping(method = RequestMethod.PUT,value="/team/{id}")
	@CrossOrigin(origins = crossOriginUrl)
	public boolean editTeam(@RequestBody Team team, @PathVariable int id) {
		try {
			teamService.editTeam(team, id);
			return true;
		} catch (EditTeamException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

    @RequestMapping(method = RequestMethod.DELETE,value="/team/{id}")
	@CrossOrigin(origins = crossOriginUrl)
	public boolean deleteTeam(@PathVariable int id) {
		try {
			teamService.deleteTeam(id);
			return true;
		} catch (DeleteTeamException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
    
    
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteAllTeams")
	@CrossOrigin(origins = crossOriginUrl)
	public boolean deleteAllTeams() {
		try {
			teamService.deleteAllTeams();
			return true;
		} catch (DeleteAllException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public TeamService getTeamService() {
		return teamService;
	}

	public void setTeamService(TeamService teamService) {
		this.teamService =teamService;
	}
	
}
