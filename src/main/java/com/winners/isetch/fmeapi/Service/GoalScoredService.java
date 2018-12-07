package com.winners.isetch.fmeapi.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winners.isetch.fmeapi.Entity.GoalScored;

import com.winners.isetch.fmeapi.Repository.GoalScoredRepository;
import com.winners.isetch.fmeapi.exceptionGoalScored.AddGoalScoredException;
import com.winners.isetch.fmeapi.exceptionGoalScored.GetGoalScoredByMatchException;
import com.winners.isetch.fmeapi.exceptionGoalScored.GetGoalScoredByPlayerException;
import com.winners.isetch.fmeapi.exceptionGoalScored.GetGoalScoredByPlayerInMatchException;


@Service
public class GoalScoredService {

	@Autowired
	private GoalScoredRepository goalScoredRepository;


	public boolean isExiste(int id) {
		return goalScoredRepository.existsById(id);
	}

	public List<GoalScored> getGoalScoredsInMatch(int idMatch) throws GetGoalScoredByMatchException {
		List<GoalScored> lgs = null;
		List<GoalScored> lgs2 = new ArrayList<GoalScored>();
		lgs = (List<GoalScored>) goalScoredRepository.findAll();
		if (lgs != null && !lgs.isEmpty()) {

			for (GoalScored g : lgs) {
				if (g.getIdMatch() == idMatch) {
					lgs2.add(g);
				}

			}
		}else
			throw new GetGoalScoredByMatchException("Erreur : List vide ! ");

		return lgs2;
	}

	public List<GoalScored> getGoalScoredsByPlayer(int idPlayer) throws GetGoalScoredByPlayerException {
		List<GoalScored> lgs = null;
		List<GoalScored> lgs2 = new ArrayList<GoalScored>();
		lgs = (List<GoalScored>) goalScoredRepository.findAll();
		if (lgs != null && !lgs.isEmpty()) {

			for (GoalScored g : lgs) {
				if (g.getIdPlayer() == idPlayer) {
					lgs2.add(g);
				}

			}
		}else
			throw new GetGoalScoredByPlayerException("Erreur : List vide ! ");


		return lgs2;
	}

	public List<GoalScored> getGoalScoredsByPlayerInMatch(int idPlayer, int idMatch) throws GetGoalScoredByPlayerInMatchException {
		List<GoalScored> lgs = null;
		List<GoalScored> lgs2 = new ArrayList<GoalScored>();
		lgs = (List<GoalScored>) goalScoredRepository.findAll();
		if (lgs != null && !lgs.isEmpty()) {

			for (GoalScored g : lgs) {
				if (g.getIdMatch() == idMatch && g.getIdPlayer() == idPlayer) {
					lgs2.add(g);
				}

			}
		}else
			throw new GetGoalScoredByPlayerInMatchException("Erreur : List vide ! ");


		return lgs2;
	}

	public GoalScored getGoalScored(int id) {
		if (isExiste(id))
			return goalScoredRepository.findById(id).get();
		else
			return null;

	}

	public boolean addGoalScored(GoalScored goalScored) throws AddGoalScoredException {
		if (isExiste(goalScored.getId()))
				throw new AddGoalScoredException("Erreur : existe dans la base ! ");

		else {
			goalScoredRepository.save(goalScored);
			return true;
		}
	}

}
