package com.winners.isetch.fmeapi.Service;

import com.winners.isetch.fmeapi.Entity.Secretary;
import com.winners.isetch.fmeapi.Repository.SecretaryRepository;
import com.winners.isetch.fmeapi.exceptionSecretary.AddSecretaryException;
import com.winners.isetch.fmeapi.exceptionSecretary.DeleteAllException;
import com.winners.isetch.fmeapi.exceptionSecretary.DeleteSecretaryException;
import com.winners.isetch.fmeapi.exceptionSecretary.EditSecretaryException;
import com.winners.isetch.fmeapi.exceptionSecretary.GetListSecretaryException;
import com.winners.isetch.fmeapi.exceptionSecretary.GetSecretaryByIdException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecretaryService {

    @Autowired
    private SecretaryRepository secretaryRepository;



    public boolean isExiste(int id) {
		return secretaryRepository.existsById(id);
	}

	public List<Secretary> getSecretarys() throws GetListSecretaryException {
		List<Secretary> lp =null;
		lp = (List<Secretary>) secretaryRepository.findAll();
		if (lp.isEmpty() || lp.equals(null))
			throw new GetListSecretaryException("Erreur : Liste Secretary est vide ");
		else 
			return lp;
		

	}

	public Secretary getSecretary(int id) throws GetSecretaryByIdException {
			if(!isExiste(id))
				throw new GetSecretaryByIdException("Erreur : ID incorrect !");
			else
		return secretaryRepository.findById(id).get();

	}

	public boolean addSecretary(Secretary secretary) throws AddSecretaryException {
		if(isExiste(secretary.getId()))
			throw new AddSecretaryException("Erreur : cette Secretary est existe dans la base !");
		else
			secretaryRepository.save(secretary);
		return true;
	}

	public boolean editSecretary(Secretary secretary, int id) throws EditSecretaryException {
		if(!isExiste(id))
			throw new EditSecretaryException("Erreur : ID incorrect !");
		else {
			secretaryRepository.deleteById(id);
			secretaryRepository.save(secretary);
			return true;
		}
		
	}

	public boolean deleteSecretary(int id) throws DeleteSecretaryException {
		if(!isExiste(id))
			throw new DeleteSecretaryException("Erreur : ID incorrect");
		else
			secretaryRepository.deleteById(id);
		return true;
	}
	
	public void deleteAllSecretarys() throws DeleteAllException {
		if(secretaryRepository.count()==0)
			throw new DeleteAllException("Erreur : il n'y a pas des Secretaries pour effacer !" );
		else
			secretaryRepository.deleteAll();
	}

}