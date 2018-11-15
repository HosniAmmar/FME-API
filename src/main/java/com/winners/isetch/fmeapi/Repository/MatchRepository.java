package com.winners.isetch.fmeapi.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.winners.isetch.fmeapi.Entity.Matchee;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface MatchRepository extends CrudRepository<Matchee,Integer> {

}
