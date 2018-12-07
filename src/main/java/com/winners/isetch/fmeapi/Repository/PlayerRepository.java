package com.winners.isetch.fmeapi.Repository;

import com.winners.isetch.fmeapi.Entity.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface PlayerRepository extends CrudRepository<Player,Integer> {
List<Player> getPlayerByActualTeamIdEquals(int id);
}