package com.winners.isetch.fmeapi.Controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import com.winners.isetch.fmeapi.Entity.Responsable;
import com.winners.isetch.fmeapi.Service.ResponsableService;

public class ResponsableControllerTest {

	ResponsableController responsableController=new ResponsableController();
	ResponsableService responsableService=mock(ResponsableService.class);
	List<Responsable> listRsp=new ArrayList<>(); 
	List<Responsable> listRsp2=new ArrayList<>(); 
	Responsable r1=new Responsable(111,"med","med","123456789","adresse","14/02/1984","22112211","abc@gmail.com","abcd","tn","sdfdf");
	Responsable r2=new Responsable(222,"ali","ali","123456789","adresse","15/05/1979","22112211","abc@gmail.com","abcd","tn","sdfdf");

	@Before
	public void setUp()  {
		responsableController.setResponsableService(responsableService);
		listRsp.add(r1);
		listRsp.add(r2);
		listRsp2.add(r1);
		listRsp2.add(r2);
	}

	@Test
	public void testGetAllResponsable() {
		when(responsableService.getResponsables()).thenReturn(listRsp);
		assertEquals(listRsp2,responsableController.getAllResponsable());
		verify(responsableService).getResponsables();
	}

	@Test
	public void testGetResponsableById() {
		when(responsableService.getResponsable(r1.getId())).thenReturn(r1);
		assertEquals(r1,responsableController.getResponsableById(r1.getId()));
		verify(responsableService).getResponsable(r1.getId());
	}

	@Test
	public void testAddReferee() {
		responsableController.addResponsable(r1);
		verify(responsableService).addResponsable(r1);
	}

	@Test
	public void testEditReferee() {
		int id=333;
		responsableController.editResponsable(r1,id);
		verify(responsableService).editResponsable(r1, id);
	}

	@Test
	public void testDeleteResponsable() {
		responsableController.deleteResponsable(r1.getId());
		verify(responsableService).deleteResponsable(r1.getId());
	}

}
