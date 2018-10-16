package com.winners.isetch.fmeapi.Controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import com.winners.isetch.fmeapi.Entity.Referee;
import com.winners.isetch.fmeapi.Service.RefereeService;

public class RefereeControllerTest {

	RefereeController refereeController=new RefereeController();
	RefereeService refereeService=mock(RefereeService.class);
	List<Referee> l=new ArrayList<>();
	List<Referee> l2=new ArrayList<>();
	Referee referee = new Referee(111,"Med", 55221133, "tunis", "Med", 40);
	Referee referee2 = new Referee(222,"ali", 55221144, "tunis", "ali", 40);
	@Before
	public void setUp(){
		refereeController.setRefereeService(refereeService);
		l.add(referee);
		l.add(referee2);
		l2.add(referee);
		l2.add(referee2);
	}

	@Test
	public void testGetAllReferees() {
		when(refereeService.getReferees()).thenReturn(l);
		assertEquals(l2, refereeController.getAllReferees());
		verify(refereeService).getReferees();
	}

	@Test
	public void testGetRefereeById() {
		when(refereeService.getReferee(111)).thenReturn(referee);
		assertEquals(referee, refereeController.getRefereeById(111));
		verify(refereeService).getReferee(111);
	}

	@Test
	public void testAddReferee() {
		refereeController.addReferee(referee);
		verify(refereeService).addReferee(referee);
		
	}

	@Test
	public void testEditReferee() {
		refereeController.editReferee(referee,333);
		verify(refereeService).editReferee(referee, 333);
	}

	@Test
	public void testDeleteReferee() {
		refereeController.deleteReferee(111);
		verify(refereeService).deleteReferee(111);
	}

}
