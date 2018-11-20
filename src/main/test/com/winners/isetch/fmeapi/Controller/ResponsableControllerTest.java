package com.winners.isetch.fmeapi.Controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.winners.isetch.fmeapi.Entity.Responsable;
import com.winners.isetch.fmeapi.Service.ResponsableService;
import com.winners.isetch.fmeapi.exceptionResponsable.AddResponsableException;
import com.winners.isetch.fmeapi.exceptionResponsable.DeleteAllException;
import com.winners.isetch.fmeapi.exceptionResponsable.DeleteResponsableException;
import com.winners.isetch.fmeapi.exceptionResponsable.EditResponsableException;
import com.winners.isetch.fmeapi.exceptionResponsable.GetListResponsableException;
import com.winners.isetch.fmeapi.exceptionResponsable.GetResponsableByIdException;

public class ResponsableControllerTest {

	ResponsableController responsableController=new ResponsableController();
	ResponsableService responsableService=mock(ResponsableService.class);
	List<Responsable> listRsp=new ArrayList<>(); 
	List<Responsable> listRsp2=new ArrayList<>(); 
	Responsable	r1=new Responsable(1, "firstName", "lastName", "natIdNum", "adress", "birthdate", "phone", "mailAdress"," fonction", "nationality", "photoUrl");
	Responsable	r2=new Responsable(2, "firstName", "lastName", "natIdNum", "adress", "birthdate", "phone", "mailAdress"," fonction", "nationality", "photoUrl");

	@Before
	public void setUp()  {
		responsableController.setResponsableService(responsableService);
		listRsp.add(r1);
		listRsp.add(r2);
		listRsp2.add(r1);
		listRsp2.add(r2);
	}

	@Test
	public void testGetAllResponsable() throws GetListResponsableException {
		when(responsableService.getResponsables()).thenReturn(listRsp);
		assertEquals(listRsp2,responsableController.getAllResponsables());
		verify(responsableService).getResponsables();
	}

	@Test
	public void testGetResponsableById() throws GetResponsableByIdException {
		when(responsableService.getResponsable(r1.getId())).thenReturn(r1);
		assertEquals(r1,responsableController.getResponsableById(r1.getId()));
		verify(responsableService).getResponsable(r1.getId());
	}

	@Test
	public void testAddReferee() throws AddResponsableException {
		responsableController.addResponsable(r1);
		verify(responsableService).addResponsable(r1);
	}

	@Test
	public void testEditReferee() throws EditResponsableException {
		int id=333;
		responsableController.editResponsable(r1,id);
		verify(responsableService).editResponsable(r1, id);
	}

	@Test
	public void testDeleteResponsable() throws DeleteResponsableException {
		responsableController.deleteResponsable(r1.getId());
		verify(responsableService).deleteResponsable(r1.getId());
	}
	@Test
	public void testDeleteAllResponsables() throws DeleteAllException {
		responsableController.deleteAllResponsables();
		verify(responsableService).deleteAllResponsables();
	}

}
