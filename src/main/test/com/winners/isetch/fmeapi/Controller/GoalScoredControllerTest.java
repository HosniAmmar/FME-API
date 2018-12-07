package com.winners.isetch.fmeapi.Controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.winners.isetch.fmeapi.Entity.GoalScored;
import com.winners.isetch.fmeapi.Service.GoalScoredService;
import com.winners.isetch.fmeapi.exceptionGoalScored.AddGoalScoredException;
import com.winners.isetch.fmeapi.exceptionGoalScored.GetGoalScoredByMatchException;
import com.winners.isetch.fmeapi.exceptionGoalScored.GetGoalScoredByPlayerException;
import com.winners.isetch.fmeapi.exceptionGoalScored.GetGoalScoredByPlayerInMatchException;

public class GoalScoredControllerTest {

	GoalScoredController goalScoredController=new GoalScoredController();
	GoalScoredService goalScoredService=mock(GoalScoredService.class);
	GoalScored g1=new GoalScored(1, 1, 1, "10");
	GoalScored g2=new GoalScored(2, 1, 1, "20");
	GoalScored g3=new GoalScored(3, 2, 1, "60") ;
	GoalScored g4=new GoalScored(4, 3, 5, "40") ;
	
	List<GoalScored> l1=new ArrayList<GoalScored>();
	List<GoalScored> l2=new ArrayList<GoalScored>();
	List<GoalScored> l3=new ArrayList<GoalScored>();
	@Before
	public void setUp() {
		goalScoredController.setGoalScoredService(goalScoredService);
		l1.add(g1);
		l1.add(g2);
		l2.add(g1);
		l2.add(g2);
		l2.add(g3);
		l3.add(g4);
	}

	@Test
	public void testGetGoalScoredsInMatch() throws GetGoalScoredByMatchException {
		when(goalScoredService.getGoalScoredsInMatch(1)).thenReturn(l2);
		assertEquals(l2,goalScoredController.getGoalScoredsInMatch(1));
	}

	@Test
	public void testGetGoalScoredsByPlayer() throws GetGoalScoredByPlayerException {
		when(goalScoredService.getGoalScoredsByPlayer(1)).thenReturn(l1);
		assertEquals(l1,goalScoredController.getGoalScoredsByPlayer(1));
	}

	@Test
	public void testGetGoalScoredsByPlayerInMatch() throws GetGoalScoredByPlayerInMatchException {
		when(goalScoredService.getGoalScoredsByPlayerInMatch(3, 5)).thenReturn(l3);
		assertEquals(l3,goalScoredController.getGoalScoredsByPlayerInMatch(3, 5));
	}

	@Test
	public void testAddGoalScored() throws AddGoalScoredException {
		when(goalScoredService.addGoalScored(g1)).thenReturn(true);
		assertEquals(true,goalScoredController.addGoalScored(g1));
	}

}
