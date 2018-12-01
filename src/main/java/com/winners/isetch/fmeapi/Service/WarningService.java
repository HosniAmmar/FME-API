package com.winners.isetch.fmeapi.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.winners.isetch.fmeapi.Entity.Warning;
import com.winners.isetch.fmeapi.Repository.WarningRepository;



@Service
public class WarningService {

	@Autowired
	private WarningRepository warningRepository;


	public boolean isExiste(int id) {
		return warningRepository.existsById(id);
	}

	public List<Warning> getWarningsInMatch(int idMatch) {
		List<Warning> lw = null;
		List<Warning> lw2 = new ArrayList<Warning>();
		lw = (List<Warning>) warningRepository.findAll();
		if (lw != null && !lw.isEmpty()) {

			for (Warning w : lw) {
				if (w.getIdMatch() == idMatch) {
					lw2.add(w);
				}

			}
		}

		return lw2;
	}

	public List<Warning> getWarningsByPlayer(int idPLayer) {
		List<Warning> lw = null;
		List<Warning> lw2 = new ArrayList<Warning>();
		lw = (List<Warning>) warningRepository.findAll();
		if (lw != null && !lw.isEmpty()) {

			for (Warning w : lw) {
				if (w.getIdPlayer() == idPLayer) {
					lw2.add(w);
				}

			}
		}

		return lw2;
	}
	
	public List<Warning> getWarningsByPlayerInMatch(int idPLayer, int idMatch) {
		List<Warning> lw = null;
		List<Warning> lw2 = new ArrayList<Warning>();
		lw = (List<Warning>) warningRepository.findAll();
		if (lw != null && !lw.isEmpty()) {

			for (Warning w : lw) {
				if (w.getIdPlayer() == idPLayer && w.getIdMatch() == idMatch) {
					lw2.add(w);
				}

			}
		}

		return lw2;
	}
	public boolean addWarning(Warning warning) {
		if (isExiste(warning.getId()))
			return false;
		else {
			warningRepository.save(warning);
			return true;
		}
	}

}
