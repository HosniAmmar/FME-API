package com.winners.isetch.fmeapi.Controller;

import com.winners.isetch.fmeapi.Entity.Team;
import com.winners.isetch.fmeapi.Service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {
    static final String crossOriginUrl="http://localhost:4200";
    @Autowired
    private TeamService teamService;


    @RequestMapping("/team")
    @CrossOrigin(origins = crossOriginUrl)
    public List<Team> getAllTeams(){

        return teamService.getTeams();
    }

    @RequestMapping("/team/{id}")
    @CrossOrigin(origins = crossOriginUrl)
    public Team getTeamById(@PathVariable int id){

        return teamService.getTeam(id);
    }

    @RequestMapping(method = RequestMethod.POST,value="/team")
    @CrossOrigin(origins = crossOriginUrl)
    public void addTeam(@RequestBody Team team){
        teamService.addTeam(team);
    }

    @RequestMapping(method = RequestMethod.PUT,value="/team/{id}")
    @CrossOrigin(origins = crossOriginUrl)
    public void editTeam(@RequestBody Team team,@PathVariable int id){
        teamService.editTeam(team,id);
    }

    @RequestMapping(method = RequestMethod.DELETE,value="/team/{id}")
    @CrossOrigin(origins = crossOriginUrl)
    public void deleteTeam(@PathVariable int id) {
        teamService.deleteTeam(id);
    }

}
