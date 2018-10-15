package com.winners.isetch.fmeapi.Repository;

import com.winners.isetch.fmeapi.Entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface TeamRepository extends JpaRepository<Team,Integer> {
}
