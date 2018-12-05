package com.winners.isetch.fmeapi.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.winners.isetch.fmeapi.Entity.Injury;

import com.winners.isetch.fmeapi.Repository.InjuryRepository;
import com.winners.isetch.fmeapi.exceptionInjury.AddInjuryException;
import com.winners.isetch.fmeapi.exceptionInjury.GetInjuryByMatchException;
import com.winners.isetch.fmeapi.exceptionInjury.GetInjuryByPlayerException;
import com.winners.isetch.fmeapi.exceptionInjury.GetInjuryByPlayerInMatchException;


@Service
public class InjuryService {

	@Autowired
	private InjuryRepository injuryRepository;


	public boolean isExiste(int id) {
		return injuryRepository.existsById(id);
	}

	public List<Injury> getInjurysInMatch(int idMatch) throws GetInjuryByMatchException {
		List<Injury> li = null;
		List<Injury> li2 = new ArrayList<Injury>();
		li = (List<Injury>) injuryRepository.findAll();
		if (li != null && !li.isEmpty()) {

			for (Injury i : li) {
				if (i.getIdMatch() == idMatch) {
					li2.add(i);
				}

			}
		}else
			throw new GetInjuryByMatchException("Erreur : List vide ! ");

		return li2;
	}

	public List<Injury> getInjurysByPlayer(int idPlayer) throws GetInjuryByPlayerException {
		List<Injury> li = null;
		List<Injury> li2 = new ArrayList<Injury>();
		li = (List<Injury>) injuryRepository.findAll();
		if (li != null && !li.isEmpty()) {

			for (Injury i : li) {
				if (i.getIdPlayer() == idPlayer) {
					li2.add(i);
				}

			}
		}else
			throw new GetInjuryByPlayerException("Erreur : List vide ! ");

		return li2;
	}
	public List<Injury> getInjurysByPlayerInMatch(int idPlayer,int idMatch) throws GetInjuryByPlayerInMatchException {
		List<Injury> li = null;
		List<Injury> li2 = new ArrayList<Injury>();
		li = (List<Injury>) injuryRepository.findAll();
		if (li != null && !li.isEmpty()) {

			for (Injury i : li) {
				if (i.getIdPlayer() == idPlayer && i.getIdMatch() == idMatch) {
					li2.add(i);
				}

			}
		}else
			throw new GetInjuryByPlayerInMatchException("Erreur : List vide ! ");

		return li2;
	}

	public Injury getInjury(int id) {
		if (isExiste(id))
			return injuryRepository.findById(id).get();
		else
			return null;

	}

	public boolean addInjury(Injury injury) throws AddInjuryException {
		if (isExiste(injury.getId()))
				throw new AddInjuryException("Erreur : existe dans la base ! ");
		else {
			injuryRepository.save(injury);
			return true;
		}
	}

}
