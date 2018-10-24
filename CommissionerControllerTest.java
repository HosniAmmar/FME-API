package com.winners.isetch.fmeapi.Controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.winners.isetch.fmeapi.Entity.Commissioner;
import com.winners.isetch.fmeapi.Service.CommissionerService;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
public class CommissionerControllerTest {

	CommissionerController commissionerController=new CommissionerController();
	CommissionerService commissionerService=mock(CommissionerService.class);
	List<Commissioner> listCom=new ArrayList<>();
	List<Commissioner> listCom2=new ArrayList<>();
	Commissioner c1=new Commissioner(111,123, "med", "med", "122345678", "adress","16/06/1980","23665544","mailAdress",170,70, "nationality", "photoUrl");
	Commissioner c2=new Commissioner(222,213, "ali", "ali", "122346678", "adress","26/07/1982","24665544","mailAdress",175,75, "nationality", "photoUrl");
	@Before
	public void setUp(){
		commissionerController.setCommissionerService(commissionerService);
		listCom.add(c1);
		listCom.add(c2);
		listCom2.add(c1);
		listCom2.add(c2);
	}

	@Test
	public void testGetAllCommissioners() {
		when(commissionerService.getCommissioners()).thenReturn(listCom);
		assertEquals(listCom2,commissionerController.getAllCommissioners());
		verify(commissionerService).getCommissioners();
	}

	@Test
	public void testGetCommissionerById() {
		when(commissionerService.getCommissioner(c1.getId())).thenReturn(c1);
		assertEquals(c1,commissionerController.getCommissionerById(c1.getId()));
		verify(commissionerService).getCommissioner(c1.getId());
	}

	@Test
	public void testAddCommissioner() {
		commissionerController.addCommissioner(c1);
		verify(commissionerService).addCommissioner(c1);
	}

	@Test
	public void testEditCommissioner() {
		int id=333;
		commissionerController.editCommissioner(c1, id);
		verify(commissionerService).editCommissioner(c1, id);
	}

	@Test
	public void testDeleteCommissioner() {
		commissionerController.deleteCommissioner(c1.getId());
		verify(commissionerService).deleteCommissioner(c1.getId());
	}

}
