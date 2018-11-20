package com.winners.isetch.fmeapi.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winners.isetch.fmeapi.Entity.Matchee;
import com.winners.isetch.fmeapi.Repository.MatchRepository;
import com.winners.isetch.fmeapi.exceptionMatch.AddMatchException;
import com.winners.isetch.fmeapi.exceptionMatch.DeleteAllException;
import com.winners.isetch.fmeapi.exceptionMatch.DeleteMatchException;
import com.winners.isetch.fmeapi.exceptionMatch.EditMatchException;
import com.winners.isetch.fmeapi.exceptionMatch.GetListMatchException;
import com.winners.isetch.fmeapi.exceptionMatch.GetMatchByIdException;

@Service
public class MatchService {

	@Autowired
	private MatchRepository matchRepository;

	public boolean isExiste(int id) {
		return matchRepository.existsById(id);
	}

	public List<Matchee> getmatchs() throws GetListMatchException {
		List<Matchee> lm = null;
		lm = (List<Matchee>) matchRepository.findAll();
		if (lm.isEmpty() || lm.equals(null))
			throw new GetListMatchException("Erreur : Liste Match est vide ");
		else 
			return lm;
		

	}

	public Matchee getmatch(int id) throws GetMatchByIdException {
			if(!isExiste(id))
				throw new GetMatchByIdException("Erreur : ID incorrect !");
			else
		return matchRepository.findById(id).get();

	}

	public void addmatch(Matchee match) throws AddMatchException {
		if(isExiste(match.getId()))
			throw new AddMatchException("Erreur : ce match est existe dans la base !");
		else
		matchRepository.save(match);
	}

	public void editmatch(Matchee match, int id) throws EditMatchException {
		if(!isExiste(id))
			throw new EditMatchException("Erreur : ID incorrect !");
		else {
			matchRepository.deleteById(id);
			matchRepository.save(match);
		}
		
	}

	public void deletematch(int id) throws DeleteMatchException {
		if(!isExiste(id))
			throw new DeleteMatchException("Erreur : ID incorrect");
		else
		matchRepository.deleteById(id);
	}
	
	public void deleteAllmatchs() throws DeleteAllException {
		if(matchRepository.count()==0)
			throw new DeleteAllException("Erreur : il n'y a pas des matches pour effacer !" );
		else
		matchRepository.deleteAll();
	}

}
