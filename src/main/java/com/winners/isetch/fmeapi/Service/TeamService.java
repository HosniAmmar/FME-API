package com.winners.isetch.fmeapi.Service;

import com.winners.isetch.fmeapi.Entity.Team;
import com.winners.isetch.fmeapi.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public List<Team> getTeams() {
        List<Team> lt=new ArrayList<>();
        teamRepository.findAll()
                .forEach(lt::add);
        return lt;
    }

    public Team getTeam(int id){

        return teamRepository.findById(id).get();

    }

    public void addTeam(Team team){
        teamRepository.save(team);
    }

    public void editTeam(Team team, int id) {

        teamRepository.save(team);
    }

    public void deleteTeam(int id) {

        teamRepository.deleteById(id);
    }
}
