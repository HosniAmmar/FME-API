package com.winners.isetch.fmeapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.winners.isetch.fmeapi.Entity.Referee;
import com.winners.isetch.fmeapi.Service.RefereeService;


@RestController
public class RefereeController {
	 static final String crossOriginUrl="http://localhost:4200";
	@Autowired
	private RefereeService refereeService;


        @RequestMapping("/referee")
        @CrossOrigin(origins = crossOriginUrl)
        public List<Referee> getAllReferees(){
           return refereeService.getReferees();
        }

        @RequestMapping("/referee/{id}")
        @CrossOrigin(origins = crossOriginUrl)
        public Referee getRefereeById(@PathVariable int id){
            return refereeService.getReferee(id);
        }

        @RequestMapping(method = RequestMethod.POST,value="/referee")
        @CrossOrigin(origins = crossOriginUrl)
        public void addReferee(@RequestBody Referee referee){
            refereeService.addReferee(referee);
        }
        @RequestMapping(method = RequestMethod.PUT,value="/referee/{id}")
        @CrossOrigin(origins = crossOriginUrl)
            public void editReferee(@RequestBody Referee referee,@PathVariable int id){
                refereeService.editReferee(referee,id);
            }
    @RequestMapping(method = RequestMethod.DELETE,value="/referee/{id}")
    @CrossOrigin(origins = crossOriginUrl)
    public void deleteReferee(@PathVariable int id){
        refereeService.deleteReferee(id);
    }
}
