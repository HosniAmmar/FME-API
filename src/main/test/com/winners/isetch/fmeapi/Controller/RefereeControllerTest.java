package com.winners.isetch.fmeapi.Controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.winners.isetch.fmeapi.Entity.Referee;
import com.winners.isetch.fmeapi.Service.RefereeService;
import com.winners.isetch.fmrapi.exceptionReferee.AddRefereeException;
import com.winners.isetch.fmrapi.exceptionReferee.DeleteAllException;
import com.winners.isetch.fmrapi.exceptionReferee.DeleteRefereeException;
import com.winners.isetch.fmrapi.exceptionReferee.EditRefereeException;
import com.winners.isetch.fmrapi.exceptionReferee.GetListRefereeException;
import com.winners.isetch.fmrapi.exceptionReferee.GetRefereeByIdException;

public class RefereeControllerTest {

	RefereeController refereeController=new RefereeController();
	RefereeService refereeService=mock(RefereeService.class);
	List<Referee> l=new ArrayList<>();
	List<Referee> l2=new ArrayList<>();
	Referee referee = new Referee(111, 123, "nom", "urlPhoto", "dateDeNaissance", "nationalite", "adresse", "region", 1, 1, 20202020, "mail", 70, 170, "commentaire");
	Referee referee2 = new Referee(222, 345, "nom", "urlPhoto", "dateDeNaissance", "nationalite", "adresse", "region", 2, 2, 22222222, "mail", 70, 170, "commentaire");
	@Before
	public void setUp(){
		refereeController.setRefereeService(refereeService);
		l.add(referee);
		l.add(referee2);
		l2.add(referee);
		l2.add(referee2);
	}

	@Test
	public void testGetAllReferees() throws GetListRefereeException {
		when(refereeService.getReferees()).thenReturn(l);
		assertEquals(l2, refereeController.getAllReferees());
		verify(refereeService).getReferees();
	}

	@Test
	public void testGetRefereeById() throws GetRefereeByIdException {
		when(refereeService.getReferee(111)).thenReturn(referee);
		assertEquals(referee, refereeController.getRefereeById(111));
		verify(refereeService).getReferee(111);
	}

	@Test
	public void testAddReferee() throws AddRefereeException {
		refereeController.addReferee(referee);
		verify(refereeService).addReferee(referee);
		
	}

	@Test
	public void testEditReferee() throws EditRefereeException {
		refereeController.editReferee(referee,333);
		verify(refereeService).editReferee(referee, 333);
	}

	@Test
	public void testDeleteReferee() throws DeleteRefereeException {
		refereeController.deleteReferee(111);
		verify(refereeService).deleteReferee(111);
	}
	
	@Test
	public void testDeleteAllReferees() throws DeleteAllException {
		refereeController.deleteAllReferees();
		verify(refereeService).deleteAllReferees();
	}

}
