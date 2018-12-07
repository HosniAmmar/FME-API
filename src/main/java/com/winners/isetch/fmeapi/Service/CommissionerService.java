package com.winners.isetch.fmeapi.Service;

import com.winners.isetch.fmeapi.Entity.Commissioner;
import com.winners.isetch.fmeapi.Repository.CommissionerRepository;
import com.winners.isetch.fmeapi.exceptions.exceptionCommissioner.AddCommissionerException;
import com.winners.isetch.fmeapi.exceptions.exceptionCommissioner.DeleteAllException;
import com.winners.isetch.fmeapi.exceptions.exceptionCommissioner.DeleteCommissionerException;
import com.winners.isetch.fmeapi.exceptions.exceptionCommissioner.EditCommissionerException;
import com.winners.isetch.fmeapi.exceptions.exceptionCommissioner.GetCommissionerByIdException;
import com.winners.isetch.fmeapi.exceptions.exceptionCommissioner.GetListCommissionerException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommissionerService {

    @Autowired
    private CommissionerRepository commissionerRepository;



    public boolean isExiste(int id) {
  		return commissionerRepository.existsById(id);
  	}

  	public List<Commissioner> getCommissioners() throws GetListCommissionerException {
  		List<Commissioner> lc =null;
  		lc = (List<Commissioner>)commissionerRepository.findAll();
  		if (lc.isEmpty() || lc.equals(null))
  			throw new GetListCommissionerException("Erreur : Liste Commissioner est vide ");
  		else 
  			return lc;
  		

  	}

  	public Commissioner getCommissioner(int id) throws GetCommissionerByIdException {
  			if(!isExiste(id))
  				throw new GetCommissionerByIdException("Erreur : ID incorrect !");
  			else
  		return commissionerRepository.findById(id).get();

  	}

  	public void addCommissioner(Commissioner commissioner) throws AddCommissionerException {
  		if(isExiste(commissioner.getId()))
  			throw new AddCommissionerException("Erreur : ce Commissioner est existe dans la base !");
  		else
  			commissionerRepository.save(commissioner);
  	}

  	public void editCommissioner(Commissioner commissioner, int id) throws EditCommissionerException {
  		if(!isExiste(id))
  			throw new EditCommissionerException("Erreur : ID incorrect !");
  		else {
  			commissionerRepository.deleteById(id);
  			commissionerRepository.save(commissioner);
  		}
  		
  	}

  	public void deleteCommissioner(int id) throws DeleteCommissionerException {
  		if(!isExiste(id))
  			throw new DeleteCommissionerException("Erreur : ID incorrect");
  		else
  			commissionerRepository.deleteById(id);
  	}
  	
  	public void deleteAllCommissioners() throws DeleteAllException {
  		if(commissionerRepository.count()==0)
  			throw new DeleteAllException("Erreur : il n'y a pas des Commissioners pour effacer !" );
  		else
  			commissionerRepository.deleteAll();
  	}

}