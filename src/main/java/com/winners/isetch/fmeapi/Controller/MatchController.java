package com.winners.isetch.fmeapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.winners.isetch.fmeapi.Entity.Matchee;
import com.winners.isetch.fmeapi.Service.MatchService;

@RestController
public class MatchController {

	 static final String crossOriginUrl="http://localhost:4200";
		@Autowired
		private MatchService matchService;
		
		@RequestMapping("/matchs")
        @CrossOrigin(origins = crossOriginUrl)
        public List<Matchee> getAllmatchs(){
           return matchService.getmatchs();
        }

        @RequestMapping("/match/{id}")
        @CrossOrigin(origins = crossOriginUrl)
        public Matchee getmatchById(@PathVariable int id){
            return matchService.getmatch(id);
        }

        @RequestMapping(method = RequestMethod.POST,value="/match")
        @CrossOrigin(origins = crossOriginUrl)
        public void addmatch(@RequestBody Matchee match){
            matchService.addmatch(match);
        }
        @RequestMapping(method = RequestMethod.PUT,value="/match/{id}")
        @CrossOrigin(origins = crossOriginUrl)
            public void editmatch(@RequestBody Matchee match,@PathVariable int id){
                matchService.editmatch(match,id);
            }
    @RequestMapping(method = RequestMethod.DELETE,value="/match/{id}")
    @CrossOrigin(origins = crossOriginUrl)
    public void deletematch(@PathVariable int id){
        matchService.deletematch(id);
    }
}
