package com.winners.isetch.fmeapi.Controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.winners.isetch.fmeapi.Entity.Commissioner;
import com.winners.isetch.fmeapi.Service.CommissionerService;
import com.winners.isetch.fmeapi.exceptionCommissioner.AddCommissionerException;
import com.winners.isetch.fmeapi.exceptionCommissioner.DeleteCommissionerException;
import com.winners.isetch.fmeapi.exceptionCommissioner.EditCommissionerException;
import com.winners.isetch.fmeapi.exceptionCommissioner.GetCommissionerByIdException;
import com.winners.isetch.fmeapi.exceptionCommissioner.GetListCommissionerException;

public class CommissionerControllerTest {

	CommissionerController commissionerController=new CommissionerController();
	CommissionerService commissionerService=mock(CommissionerService.class);

	List<Commissioner> listCom=new ArrayList<>();
	List<Commissioner> listCom2=new ArrayList<>();
	Commissioner c1=new Commissioner("firstName", "lastName", "phone", "natIdNum", "address", "mailAddress", 1.70, 70, "birthdate", "nationality", "photoUrl", "region", "city", "numpasseport", "comment", 1, 1);
	Commissioner c2=new Commissioner("firstName", "lastName", "phone", "natIdNum", "address", "mailAddress", 1.70, 70, "birthdate", "nationality", "photoUrl", "region", "city", "numpasseport", "comment", 2, 2);


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
	}

	@Test
	public void testGetCommissionerById() throws GetCommissionerByIdException {
		when(commissionerService.getCommissioner(c1.getId())).thenReturn(c1);
		assertEquals(c1,commissionerController.getCommissionerById(c1.getId()));
	}

	@Test
	public void testAddCommissioner() throws AddCommissionerException {
		when(commissionerService.addCommissioner(c1)).thenReturn(true);
		assertEquals(true,commissionerController.addCommissioner(c1));
		
	}

	@Test
	public void testEditCommissioner() throws EditCommissionerException {
		when(commissionerService.editCommissioner(c1,c1.getId())).thenReturn(true);
		assertEquals(true,commissionerController.editCommissioner(c1,c1.getId()));
	}

	@Test
	public void testDeleteCommissioner() throws DeleteCommissionerException {
		when(commissionerService.deleteCommissioner(c1.getId())).thenReturn(true);
		assertEquals(true,commissionerController.deleteCommissioner(c1.getId()));
	}
	
	

}
