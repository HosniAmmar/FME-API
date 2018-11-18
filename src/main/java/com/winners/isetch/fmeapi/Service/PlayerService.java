package com.winners.isetch.fmeapi.Service;

import com.winners.isetch.fmeapi.Entity.Player;
import com.winners.isetch.fmeapi.Repository.PlayerRepository;
import com.winners.isetch.fmeapi.exception.exceptionPlayer.AddPlayerException;
import com.winners.isetch.fmeapi.exception.exceptionPlayer.DeleteAllException;
import com.winners.isetch.fmeapi.exception.exceptionPlayer.DeletePlayerException;
import com.winners.isetch.fmeapi.exception.exceptionPlayer.EditPlayerException;
import com.winners.isetch.fmeapi.exception.exceptionPlayer.GetListPlayerException;
import com.winners.isetch.fmeapi.exception.exceptionPlayer.GetPlayerByIdException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;



    public boolean isExiste(int id) {
		return playerRepository.existsById(id);
	}

	public List<Player> getPlayers() throws GetListPlayerException {
		List<Player> lp =null;
		lp = (List<Player>) playerRepository.findAll();
		if (lp.isEmpty() || lp.equals(null))
			throw new GetListPlayerException("Erreur : Liste Player est vide ");
		else 
			return lp;
		

	}

	public Player getPlayer(int id) throws GetPlayerByIdException {
			if(!isExiste(id))
				throw new GetPlayerByIdException("Erreur : ID incorrect !");
			else
		return playerRepository.findById(id).get();

	}

	public void addPlayer(Player player) throws AddPlayerException {
		if(isExiste(player.getId()))
			throw new AddPlayerException("Erreur : ce Player est existe dans la base !");
		else
			playerRepository.save(player);
	}

	public void editPlayer(Player player, int id) throws EditPlayerException {
		if(!isExiste(id))
			throw new EditPlayerException("Erreur : ID incorrect !");
		else {
			playerRepository.deleteById(id);
			playerRepository.save(player);
		}
		
	}

	public void deletePlayer(int id) throws DeletePlayerException {
		if(!isExiste(id))
			throw new DeletePlayerException("Erreur : ID incorrect");
		else
			playerRepository.deleteById(id);
	}
	
	public void deleteAllPlayers() throws DeleteAllException {
		if(playerRepository.count()==0)
			throw new DeleteAllException("Erreur : il n'y a pas des Players pour effacer !" );
		else
			playerRepository.deleteAll();
	}

}