package com.winners.isetch.fmeapi.Service;

import com.winners.isetch.fmeapi.Entity.President;
import com.winners.isetch.fmeapi.Repository.PresidentRepository;
import com.winners.isetch.fmeapi.exceptionPresident.AddPresidentException;
import com.winners.isetch.fmeapi.exceptionPresident.DeleteAllException;
import com.winners.isetch.fmeapi.exceptionPresident.DeletePresidentException;
import com.winners.isetch.fmeapi.exceptionPresident.EditPresidentException;
import com.winners.isetch.fmeapi.exceptionPresident.GetListPresidentException;
import com.winners.isetch.fmeapi.exceptionPresident.GetPresidentByIdException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PresidentService {

	@Autowired
	private PresidentRepository presidentRepository;

	public PresidentRepository getPresidentRepository() {
		return presidentRepository;
	}

	public void setPresidentRepository(PresidentRepository presidentRepository) {
		this.presidentRepository = presidentRepository;
	}

	public boolean isExiste(int id) {
		return presidentRepository.existsById(id);
	}

	public List<President> getPresidents() throws GetListPresidentException {
		List<President> lp = null;
		lp = (List<President>) presidentRepository.findAll();
		if (lp.isEmpty() || lp.equals(null))
			throw new GetListPresidentException("Erreur : Liste President est vide ");
		else
			return lp;

	}

	public President getPresident(int id) throws GetPresidentByIdException {
		if (!isExiste(id))
			throw new GetPresidentByIdException("Erreur : ID incorrect !");
		else
			return presidentRepository.findById(id).get();

	}

	public void addPresident(President president) throws AddPresidentException {
		if (isExiste(president.getId()))
			throw new AddPresidentException("Erreur : ce President est existe dans la base !");
		else
			presidentRepository.save(president);
	}

	public void editPresident(President president, int id) throws EditPresidentException {
		if (!isExiste(id))
			throw new EditPresidentException("Erreur : ID incorrect !");
		else {
			presidentRepository.deleteById(id);
			presidentRepository.save(president);
		}

	}

	public void deletePresident(int id) throws DeletePresidentException {
		if (!isExiste(id))
			throw new DeletePresidentException("Erreur : ID incorrect");
		else
			presidentRepository.deleteById(id);
	}

	public void deleteAllPresidents() throws DeleteAllException {
		if (presidentRepository.count() == 0)
			throw new DeleteAllException("Erreur : il n'y a pas des Presidents pour effacer !");
		else
			presidentRepository.deleteAll();
	}

}