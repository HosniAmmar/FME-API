package com.winners.isetch.fmeapi.Controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.winners.isetch.fmeapi.Entity.Team;
import com.winners.isetch.fmeapi.Service.TeamService;
import com.winners.isetch.fmeapi.exceptionTeam.AddTeamException;
import com.winners.isetch.fmeapi.exceptionTeam.DeleteAllException;
import com.winners.isetch.fmeapi.exceptionTeam.DeleteTeamException;
import com.winners.isetch.fmeapi.exceptionTeam.EditTeamException;
import com.winners.isetch.fmeapi.exceptionTeam.GetListTeamException;
import com.winners.isetch.fmeapi.exceptionTeam.GetTeamByIdException;



public class TeamControllerTest {

	TeamController teamController=new TeamController();
	TeamService teamService=mock(TeamService.class);
	List<Team> listCom=new ArrayList<>();
	List<Team> listCom2=new ArrayList<>();
	Team t1=new Team("name", "logoUrl", "adress", "region", "creationDate", "presidentirstName", "presidentLastName", "presidentPhone","secretaryFirstName", "secretaryLastName", "secretaryPhone", "mail", "phone", "fax", "mainStadium", "mainStadiumLocation", "teamPhoto", "division");
	Team t2=new Team("name2", "logoUrl", "adress", "region", "creationDate", "presidentirstName", "presidentLastName", "presidentPhone","secretaryFirstName", "secretaryLastName", "secretaryPhone", "mail", "phone", "fax", "mainStadium", "mainStadiumLocation", "teamPhoto", "division");

	@Before
	public void setUp(){
		teamController.setTeamService(teamService);
		listCom.add(t1);
		listCom.add(t2);
		listCom2.add(t1);
		listCom2.add(t2);
	}

	@Test
	public void testGetAllTeams() throws GetListTeamException {
		when(teamService.getTeams()).thenReturn(listCom);
		assertEquals(listCom2,teamController.getAllTeams());
		verify(teamService).getTeams();
	}

	@Test
	public void testGetTeamById() throws GetTeamByIdException {
		when(teamService.getTeam(t1.getId())).thenReturn(t1);
		assertEquals(t1,teamController.getTeamById(t1.getId()));
		verify(teamService).getTeam(t1.getId());
	}

	@Test
	public void testAddTeam() throws AddTeamException {
		teamController.addTeam(t1);
		verify(teamService).addTeam(t1);
	}

	@Test
	public void testEditTeam() throws EditTeamException {
		teamController.editTeam(t1, t2.getId());
		verify(teamService).editTeam(t1, t2.getId());
	}

	@Test
	public void testDeleteTeam() throws DeleteTeamException {
		teamController.deleteTeam(t1.getId());
		verify(teamService).deleteTeam(t1.getId());
	}
	
	@Test
	public void testDeleteAllTeams() throws DeleteAllException {
		teamController.deleteAllTeams();
		verify(teamService).deleteAllTeams();
	}

}
