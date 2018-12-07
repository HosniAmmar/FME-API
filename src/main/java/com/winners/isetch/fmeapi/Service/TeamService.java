package com.winners.isetch.fmeapi.Service;

import com.winners.isetch.fmeapi.Entity.Player;
import com.winners.isetch.fmeapi.Entity.Team;
import com.winners.isetch.fmeapi.Repository.PlayerRepository;
import com.winners.isetch.fmeapi.Repository.TeamRepository;
import com.winners.isetch.fmeapi.exceptionTeam.AddTeamException;
import com.winners.isetch.fmeapi.exceptionTeam.DeleteAllException;
import com.winners.isetch.fmeapi.exceptionTeam.DeleteTeamException;
import com.winners.isetch.fmeapi.exceptionTeam.EditTeamException;
import com.winners.isetch.fmeapi.exceptionTeam.GetListTeamException;
import com.winners.isetch.fmeapi.exceptionTeam.GetTeamByIdException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService  {

    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private PlayerRepository playerRepository;


    public boolean isExiste(int id) {
		return teamRepository.existsById(id);
	}

	public List<Team> getTeams() throws GetListTeamException {
		List<Team> lt =null;
		lt = (List<Team>) teamRepository.findAll();
		if (lt.isEmpty() || lt.equals(null))
			throw new GetListTeamException("Erreur : Liste Team est vide ");
		else 
			return lt;
		
	}

	public Team getTeam(int id) throws GetTeamByIdException {
			if(!isExiste(id))
				throw new GetTeamByIdException("Erreur : ID incorrect !");
			else
		return teamRepository.findById(id).get();

	}

	public boolean addTeam(Team team) throws AddTeamException {
		if(isExiste(team.getId()))
			throw new AddTeamException("Erreur : ce Team est existe dans la base !");
		else
			teamRepository.save(team);
		return true;
	}

	public boolean editTeam(Team team, int id) throws EditTeamException {
		if(!isExiste(id))
			throw new EditTeamException("Erreur : ID incorrect !");
		else {
			teamRepository.deleteById(id);
			teamRepository.save(team);
			return true;
		}
		
	}

	public boolean deleteTeam(int id) throws DeleteTeamException {
		if(!isExiste(id))
			throw new DeleteTeamException("Erreur : ID incorrect");
		else
			teamRepository.deleteById(id);
		return true;
	}
	
	public List<Player>getTeamPlayers(int idEquipe){
		List<Player>lp=null;
		List<Player>lp2=new ArrayList<Player>();
		lp=(List<Player>)playerRepository.findAll();
		if(lp!=null && !lp.isEmpty()) {
			for(Player p : lp) {
				if(p.getActualTeamId()==idEquipe) {
					lp2.add(p);
				}
			}	
		}
		
		
		return lp2;
	}
	
	public void deleteAllTeams() throws DeleteAllException {
		if(teamRepository.count()==0)
			throw new DeleteAllException("Erreur : il n'y a pas des Teams pour effacer !" );
		else
			teamRepository.deleteAll();
	}

}