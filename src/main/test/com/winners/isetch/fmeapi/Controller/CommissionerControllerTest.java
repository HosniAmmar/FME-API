package com.winners.isetch.fmeapi.Controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.winners.isetch.fmeapi.Entity.Commissioner;
import com.winners.isetch.fmeapi.Service.CommissionerService;
import com.winners.isetch.fmrapi.exceptionCommissioner.AddCommissionerException;
import com.winners.isetch.fmrapi.exceptionCommissioner.DeleteAllException;
import com.winners.isetch.fmrapi.exceptionCommissioner.DeleteCommissionerException;
import com.winners.isetch.fmrapi.exceptionCommissioner.EditCommissionerException;
import com.winners.isetch.fmrapi.exceptionCommissioner.GetCommissionerByIdException;
import com.winners.isetch.fmrapi.exceptionCommissioner.GetListCommissionerException;

public class CommissionerControllerTest {

	CommissionerController commissionerController=new CommissionerController();
	CommissionerService commissionerService=mock(CommissionerService.class);
	List<Commissioner> listCom=new ArrayList<>();
	List<Commissioner> listCom2=new ArrayList<>();
	Commissioner c1=new Commissioner(111, 124, "nom", "urlPhoto", "dateDeNaissance", "nationalite", "adresse","region",1141, 142525, 54545454, "mail",70,170,"commentaire");
	Commissioner c2=new Commissioner(222, 124, "nom", "urlPhoto", "dateDeNaissance", "nationalite", "adresse","region",1141, 142525, 54545454, "mail",70,170,"commentaire");
	@Before
	public void setUp(){
		commissionerController.setCommissionerService(commissionerService);
		listCom.add(c1);
		listCom.add(c2);
		listCom2.add(c1);
		listCom2.add(c2);
	}

	@Test
	public void testGetAllCommissioners() throws GetListCommissionerException {
		when(commissionerService.getCommissioners()).thenReturn(listCom);
		assertEquals(listCom2,commissionerController.getAllCommissioners());
		verify(commissionerService).getCommissioners();
	}

	@Test
	public void testGetCommissionerById() throws GetCommissionerByIdException {
		when(commissionerService.getCommissioner(c1.getId())).thenReturn(c1);
		assertEquals(c1,commissionerController.getCommissionerById(c1.getId()));
		verify(commissionerService).getCommissioner(c1.getId());
	}

	@Test
	public void testAddCommissioner() throws AddCommissionerException {
		commissionerController.addCommissioner(c1);
		verify(commissionerService).addCommissioner(c1);
	}

	@Test
	public void testEditCommissioner() throws EditCommissionerException {
		int id=333;
		commissionerController.editCommissioner(c1, id);
		verify(commissionerService).editCommissioner(c1, id);
	}

	@Test
	public void testDeleteCommissioner() throws DeleteCommissionerException {
		commissionerController.deleteCommissioner(c1.getId());
		verify(commissionerService).deleteCommissioner(c1.getId());
	}
	
	@Test
	public void testDeleteAllCommissioners() throws DeleteAllException {
		commissionerController.deleteAllCommissioners();
		verify(commissionerService).deleteAllCommissioners();
	}

}
