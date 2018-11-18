package com.winners.isetch.fmeapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.winners.isetch.fmeapi.Entity.Team;
import com.winners.isetch.fmeapi.Service.TeamService;
import com.winners.isetch.fmeapi.exception.exceptionTeam.AddTeamException;
import com.winners.isetch.fmeapi.exception.exceptionTeam.DeleteAllException;
import com.winners.isetch.fmeapi.exception.exceptionTeam.DeleteTeamException;
import com.winners.isetch.fmeapi.exception.exceptionTeam.EditTeamException;
import com.winners.isetch.fmeapi.exception.exceptionTeam.GetListTeamException;
import com.winners.isetch.fmeapi.exception.exceptionTeam.GetTeamByIdException;


@RestController
public class TeamController {
	static final String crossOriginUrl="http://localhost:4200";
	
	@Autowired
    private TeamService teamService;
	
	
	
	@RequestMapping("/teams")
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

	 @RequestMapping("/team/{id}")
	    @CrossOrigin(origins = crossOriginUrl)
	public Team getTeamById(@PathVariable int id){
		Team tm=null;	
		try {
				tm= teamService.getTeam(id);
			} catch (GetTeamByIdException e) {
				
				System.out.println(e.getMessage());
			}
		return tm;
		
	}

	@RequestMapping(method = RequestMethod.POST, value = "/team")
	@CrossOrigin(origins = crossOriginUrl)
	public void addTeam(@RequestBody Team team) {
		
		try {
			teamService.addTeam(team);
		} catch (AddTeamException e) {
			System.out.println(e.getMessage());
		}
	}

			@RequestMapping(method = RequestMethod.PUT,value="/team/{id}")
		    @CrossOrigin(origins = crossOriginUrl)
		public void editTeam(@RequestBody Team team,@PathVariable int id){
		try {
			teamService.editTeam(team, id);
		} catch (EditTeamException e) {
			System.out.println(e.getMessage());
		}
	}



	    @RequestMapping(method = RequestMethod.DELETE,value="/team/{id}")
	    @CrossOrigin(origins = crossOriginUrl)
	    public void deleteTeam(@PathVariable int id) {
		try {
			teamService.deleteTeam(id);
		} catch (DeleteTeamException e) {
			System.out.println(e.getMessage());
		}
	}
	 
	 
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteAllTeams")
	@CrossOrigin(origins = crossOriginUrl)
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
	
}
