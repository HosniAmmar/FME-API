package com.winners.isetch.fmeapi.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.winners.isetch.fmeapi.Entity.Injury;

import com.winners.isetch.fmeapi.Repository.InjuryRepository;


@Service
public class InjuryService {

	@Autowired
	private InjuryRepository injuryRepository;


	public boolean isExiste(int id) {
		return injuryRepository.existsById(id);
	}

	public List<Injury> getInjurysInMatch(int idMatch) {
		List<Injury> li = null;
		List<Injury> li2 = new ArrayList<Injury>();
		li = (List<Injury>) injuryRepository.findAll();
		if (li != null && !li.isEmpty()) {

			for (Injury i : li) {
				if (i.getIdMatch() == idMatch) {
					li2.add(i);
				}

			}
		}

		return li2;
	}

	public List<Injury> getInjurysByPlayer(int idPlayer) {
		List<Injury> li = null;
		List<Injury> li2 = new ArrayList<Injury>();
		li = (List<Injury>) injuryRepository.findAll();
		if (li != null && !li.isEmpty()) {

			for (Injury i : li) {
				if (i.getIdPlayer() == idPlayer) {
					li2.add(i);
				}

			}
		}

		return li2;
	}
	public List<Injury> getInjurysByPlayerInMatch(int idPlayer,int idMatch) {
		List<Injury> li = null;
		List<Injury> li2 = new ArrayList<Injury>();
		li = (List<Injury>) injuryRepository.findAll();
		if (li != null && !li.isEmpty()) {

			for (Injury i : li) {
				if (i.getIdPlayer() == idPlayer && i.getIdMatch() == idMatch) {
					li2.add(i);
				}

			}
		}

		return li2;
	}

	public Injury getInjury(int id) {
		if (isExiste(id))
			return injuryRepository.findById(id).get();
		else
			return null;

	}

	public boolean addInjury(Injury injury) {
		if (isExiste(injury.getId()))
			return false;
		else {
			injuryRepository.save(injury);
			return true;
		}
	}

}
