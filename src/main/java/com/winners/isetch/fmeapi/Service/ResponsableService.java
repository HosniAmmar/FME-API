package com.winners.isetch.fmeapi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.winners.isetch.fmeapi.Entity.Responsable;
import com.winners.isetch.fmeapi.Repository.ResponsableRepository;
import com.winners.isetch.fmeapi.exception.exceptionResponsable.DeleteAllException;
import com.winners.isetch.fmeapi.exception.exceptionResponsable.AddResponsableException;
import com.winners.isetch.fmeapi.exception.exceptionResponsable.DeleteResponsableException;
import com.winners.isetch.fmeapi.exception.exceptionResponsable.EditResponsableException;
import com.winners.isetch.fmeapi.exception.exceptionResponsable.GetListResponsableException;
import com.winners.isetch.fmeapi.exception.exceptionResponsable.GetResponsableByIdException;


@Service
public class ResponsableService {
	@Autowired
    private ResponsableRepository responsableRepository;
	
	 public boolean isExiste(int id) {
			return responsableRepository.existsById(id);
		}

		public List<Responsable> getResponsables() throws GetListResponsableException {
			List<Responsable> lrs =null;
			lrs = (List<Responsable>) responsableRepository.findAll();
			if (lrs.isEmpty() || lrs.equals(null))
				throw new GetListResponsableException("Erreur : Liste Responsable est vide ");
			else 
				return lrs;
			

		}

		public Responsable getResponsable(int id) throws GetResponsableByIdException {
				if(!isExiste(id))
					throw new GetResponsableByIdException("Erreur : ID incorrect !");
				else
			return responsableRepository.findById(id).get();

		}

		public void addResponsable(Responsable responsable) throws AddResponsableException {
			if(isExiste(responsable.getId()))
				throw new AddResponsableException("Erreur : ce Responsable est existe dans la base !");
			else
				responsableRepository.save(responsable);
		}

		public void editResponsable(Responsable responsable, int id) throws EditResponsableException {
			if(!isExiste(id))
				throw new EditResponsableException("Erreur : ID incorrect !");
			else {
				responsableRepository.deleteById(id);
				responsableRepository.save(responsable);
			}
			
		}

		public void deleteResponsable(int id) throws DeleteResponsableException {
			if(!isExiste(id))
				throw new DeleteResponsableException("Erreur : ID incorrect");
			else
			responsableRepository.deleteById(id);
		}
		
		public void deleteAllResponsables() throws DeleteAllException {
			if(responsableRepository.count()==0)
				throw new DeleteAllException("Erreur : il n'y a pas des Responsables pour effacer !" );
			else
			responsableRepository.deleteAll();
		}

}
