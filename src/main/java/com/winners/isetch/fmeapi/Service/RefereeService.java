package com.winners.isetch.fmeapi.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winners.isetch.fmeapi.Entity.Referee;
import com.winners.isetch.fmeapi.Repository.RefereeRepository;

@Service
public class RefereeService {
	
    @Autowired
    private RefereeRepository refereeRepository;

    public List<Referee> getReferees() {
        List<Referee> lp=new ArrayList<>();
        refereeRepository.findAll()
                .forEach(lp::add);
        return lp;
    }

    public Referee getReferee(int id){
       
        return refereeRepository.findById(id).get();

    }

    public void addReferee(Referee referee){
        refereeRepository.save(referee);
    }

    public void editReferee(Referee referee, int id) {

        refereeRepository.save(referee);
    }

    public void deleteReferee(int id) {

        refereeRepository.deleteById(id);
    }
}