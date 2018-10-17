package com.winners.isetch.fmeapi.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.winners.isetch.fmeapi.Entity.Responsable;
import com.winners.isetch.fmeapi.Repository.ResponsableRepository;


@Service
public class ResponsableService {
	@Autowired
    private ResponsableRepository responsableRepository;
	
	 public List<Responsable> getResponsables() {
	        List<Responsable> lp=new ArrayList<>();
	        responsableRepository.findAll()
	                .forEach(lp::add);
	        return lp;
	    }

	    public Responsable getResponsable(int id){
	       
	        return responsableRepository.findById(id).get();

	    }

	    public void addResponsable(Responsable responsable){
	    	responsableRepository.save(responsable);
	    }

	    public void editResponsable(Responsable responsable, int id) {

	    	responsableRepository.save(responsable);
	    }

	    public void deleteResponsable(int id) {

	    	responsableRepository.deleteById(id);
	    }


}
