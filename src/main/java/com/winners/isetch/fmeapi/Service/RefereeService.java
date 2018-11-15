package com.winners.isetch.fmeapi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.winners.isetch.fmeapi.Entity.Referee;
import com.winners.isetch.fmeapi.Repository.RefereeRepository;
import com.winners.isetch.fmrapi.exceptionReferee.AddRefereeException;
import com.winners.isetch.fmrapi.exceptionReferee.DeleteAllException;
import com.winners.isetch.fmrapi.exceptionReferee.DeleteRefereeException;
import com.winners.isetch.fmrapi.exceptionReferee.EditRefereeException;
import com.winners.isetch.fmrapi.exceptionReferee.GetListRefereeException;
import com.winners.isetch.fmrapi.exceptionReferee.GetRefereeByIdException;


@Service
public class RefereeService {
	
    @Autowired
    private RefereeRepository refereeRepository;

    public boolean isExiste(int id) {
		return refereeRepository.existsById(id);
	}

	public List<Referee> getReferees() throws GetListRefereeException {
		List<Referee> lr =null;
		lr = (List<Referee>) refereeRepository.findAll();
		if (lr.isEmpty() || lr.equals(null))
			throw new GetListRefereeException("Erreur : Liste Referee est vide ");
		else 
			return lr;
		

	}

	public Referee getReferee(int id) throws GetRefereeByIdException {
			if(!isExiste(id))
				throw new GetRefereeByIdException("Erreur : ID incorrect !");
			else
		return refereeRepository.findById(id).get();

	}

	public void addReferee(Referee referee) throws AddRefereeException {
		if(isExiste(referee.getId()))
			throw new AddRefereeException("Erreur : ce Referee est existe dans la base !");
		else
			refereeRepository.save(referee);
	}

	public void editReferee(Referee referee, int id) throws EditRefereeException {
		if(!isExiste(id))
			throw new EditRefereeException("Erreur : ID incorrect !");
		else {
			refereeRepository.deleteById(id);
			refereeRepository.save(referee);
		}
		
	}

	public void deleteReferee(int id) throws DeleteRefereeException {
		if(!isExiste(id))
			throw new DeleteRefereeException("Erreur : ID incorrect");
		else
		refereeRepository.deleteById(id);
	}
	
	public void deleteAllReferees() throws DeleteAllException {
		if(refereeRepository.count()==0)
			throw new DeleteAllException("Erreur : il n'y a pas des Referee pour effacer !" );
		else
		refereeRepository.deleteAll();
	}

}