package com.winners.isetch.fmeapi.Controller;

import com.winners.isetch.fmeapi.Entity.Commissioner;
import com.winners.isetch.fmeapi.Service.CommissionerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommissionerController {

    @Autowired
    private CommissionerService commissionerService;


        @RequestMapping("/commissioner")
        public List<Commissioner> getAllCommissioners(){
           return commissionerService.getCommissioners();
        }

        @RequestMapping("/commissioner/{id}")
        public Commissioner getCommissionerById(@PathVariable int id){
            return commissionerService.getCommissioner(id);
        }

        @RequestMapping(method = RequestMethod.POST,value="/commissioner")
        public void addCommissioner(@RequestBody Commissioner player){
        	commissionerService.addCommissioner(player);
        }
        @RequestMapping(method = RequestMethod.PUT,value="/commissioner/{id}")
            public void editCommissioner(@RequestBody Commissioner player,@PathVariable int id){
        	commissionerService.editCommissioner(player,id);
            }
    @RequestMapping(method = RequestMethod.DELETE,value="/commissioner/{id}")
    public void deleteCommissioner(@PathVariable int id){
    	commissionerService.deleteCommissioner(id);
    }
}