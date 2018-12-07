package com.winners.isetch.fmeapi.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.winners.isetch.fmeapi.Entity.Warning;
import com.winners.isetch.fmeapi.Repository.WarningRepository;
import com.winners.isetch.fmeapi.exceptionWarning.AddWarningException;
import com.winners.isetch.fmeapi.exceptionWarning.GetWarningByMatchException;
import com.winners.isetch.fmeapi.exceptionWarning.GetWarningByPlayerException;
import com.winners.isetch.fmeapi.exceptionWarning.GetWarningByPlayerInMatchException;



@Service
public class WarningService {

	@Autowired
	private WarningRepository warningRepository;


	public boolean isExiste(int id) {
		return warningRepository.existsById(id);
	}

	public List<Warning> getWarningsInMatch(int idMatch) throws GetWarningByMatchException {
		List<Warning> lw = null;
		List<Warning> lw2 = new ArrayList<Warning>();
		lw = (List<Warning>) warningRepository.findAll();
		if (lw != null && !lw.isEmpty()) {

			for (Warning w : lw) {
				if (w.getIdMatch() == idMatch) {
					lw2.add(w);
				}

			}
		}else
			throw new GetWarningByMatchException("Erreur : List vide ! ");


		return lw2;
	}

	public List<Warning> getWarningsByPlayer(int idPLayer) throws GetWarningByPlayerException {
		List<Warning> lw = null;
		List<Warning> lw2 = new ArrayList<Warning>();
		lw = (List<Warning>) warningRepository.findAll();
		if (lw != null && !lw.isEmpty()) {

			for (Warning w : lw) {
				if (w.getIdPlayer() == idPLayer) {
					lw2.add(w);
				}

			}
		}else
			throw new GetWarningByPlayerException("Erreur : List vide ! ");


		return lw2;
	}
	
	public List<Warning> getWarningsByPlayerInMatch(int idPLayer, int idMatch) throws GetWarningByPlayerInMatchException {
		List<Warning> lw = null;
		List<Warning> lw2 = new ArrayList<Warning>();
		lw = (List<Warning>) warningRepository.findAll();
		if (lw != null && !lw.isEmpty()) {

			for (Warning w : lw) {
				if (w.getIdPlayer() == idPLayer && w.getIdMatch() == idMatch) {
					lw2.add(w);
				}

			}
		}else
			throw new GetWarningByPlayerInMatchException("Erreur : List vide ! ");


		return lw2;
	}
	public boolean addWarning(Warning warning) throws AddWarningException {
		if (isExiste(warning.getId()))
				throw new AddWarningException("Erreur : existe dans la base ! ");

		else {
			warningRepository.save(warning);
			return true;
		}
	}

}
