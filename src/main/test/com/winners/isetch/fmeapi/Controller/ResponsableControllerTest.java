package com.winners.isetch.fmeapi.Controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.winners.isetch.fmeapi.Entity.Responsable;
import com.winners.isetch.fmeapi.Service.ResponsableService;
import com.winners.isetch.fmeapi.exceptionResponsable.AddResponsableException;
import com.winners.isetch.fmeapi.exceptionResponsable.DeleteResponsableException;
import com.winners.isetch.fmeapi.exceptionResponsable.EditResponsableException;
import com.winners.isetch.fmeapi.exceptionResponsable.GetListResponsableException;
import com.winners.isetch.fmeapi.exceptionResponsable.GetResponsableByIdException;

public class ResponsableControllerTest {

	ResponsableController responsableController=new ResponsableController();
	ResponsableService responsableService=mock(ResponsableService.class);
	List<Responsable> listRsp=new ArrayList<>(); 
	List<Responsable> listRsp2=new ArrayList<>(); 
	Responsable	r1=new Responsable("firstName", "lastName", "phone", "natIdNum", "address", "mailAddress", 1.70, 70, "birthdate", "nationality", "photoUrl", "region", "city", "numpasseport", "comment", 1, "fonction", 1);
	Responsable	r2=new Responsable("firstName", "lastName", "phone", "natIdNum", "address", "mailAddress", 1.70, 70, "birthdate", "nationality", "photoUrl", "region", "city", "numpasseport", "comment", 2,"fonction",2 );

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
	}

	@Test
	public void testGetResponsableById() throws GetResponsableByIdException {
		when(responsableService.getResponsable(r1.getId())).thenReturn(r1);
		assertEquals(r1,responsableController.getResponsableById(r1.getId()));
	}

	@Test
	public void testAddReferee() throws AddResponsableException {
		when(responsableService.addResponsable(r1)).thenReturn(true);
		assertEquals(true,responsableController.addResponsable(r1));
	}

	@Test
	public void testEditReferee() throws EditResponsableException {
		when(responsableService.editResponsable(r1,r1.getId())).thenReturn(true);
		assertEquals(true,responsableController.editResponsable(r1,r1.getId()));
	}

	@Test
	public void testDeleteResponsable() throws DeleteResponsableException {
		when(responsableService.deleteResponsable(r1.getId())).thenReturn(true);
		assertEquals(true,responsableController.deleteResponsable(r1.getId()));
	}

}
