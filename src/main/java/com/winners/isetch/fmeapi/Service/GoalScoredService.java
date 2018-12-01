package com.winners.isetch.fmeapi.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winners.isetch.fmeapi.Entity.GoalScored;

import com.winners.isetch.fmeapi.Repository.GoalScoredRepository;


@Service
public class GoalScoredService {

	@Autowired
	private GoalScoredRepository goalScoredRepository;


	public boolean isExiste(int id) {
		return goalScoredRepository.existsById(id);
	}

	public List<GoalScored> getGoalScoredsInMatch(int idMatch) {
		List<GoalScored> lgs = null;
		List<GoalScored> lgs2 = new ArrayList<GoalScored>();
		lgs = (List<GoalScored>) goalScoredRepository.findAll();
		if (lgs != null && !lgs.isEmpty()) {

			for (GoalScored g : lgs) {
				if (g.getIdMatch() == idMatch) {
					lgs2.add(g);
				}

			}
		}

		return lgs2;
	}

	public List<GoalScored> getGoalScoredsByPlayer(int idPlayer) {
		List<GoalScored> lgs = null;
		List<GoalScored> lgs2 = new ArrayList<GoalScored>();
		lgs = (List<GoalScored>) goalScoredRepository.findAll();
		if (lgs != null && !lgs.isEmpty()) {

			for (GoalScored g : lgs) {
				if (g.getIdPlayer() == idPlayer) {
					lgs2.add(g);
				}

			}
		}

		return lgs2;
	}

	public List<GoalScored> getGoalScoredsByPlayerInMatch(int idPlayer, int idMatch) {
		List<GoalScored> lgs = null;
		List<GoalScored> lgs2 = new ArrayList<GoalScored>();
		lgs = (List<GoalScored>) goalScoredRepository.findAll();
		if (lgs != null && !lgs.isEmpty()) {

			for (GoalScored g : lgs) {
				if (g.getIdMatch() == idMatch && g.getIdPlayer() == idPlayer) {
					lgs2.add(g);
				}

			}
		}

		return lgs2;
	}

	public GoalScored getGoalScored(int id) {
		if (isExiste(id))
			return goalScoredRepository.findById(id).get();
		else
			return null;

	}

	public boolean addGoalScored(GoalScored goalScored) {
		if (isExiste(goalScored.getId()))
			return false;
		else {
			goalScoredRepository.save(goalScored);
			return true;
		}
	}

}
