package com.winners.isetch.fmeapi.Controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.winners.isetch.fmeapi.Entity.Player;
import com.winners.isetch.fmeapi.Service.PlayerService;
import com.winners.isetch.fmeapi.exceptionPlayer.AddPlayerException;
import com.winners.isetch.fmeapi.exceptionPlayer.DeleteAllException;
import com.winners.isetch.fmeapi.exceptionPlayer.DeletePlayerException;
import com.winners.isetch.fmeapi.exceptionPlayer.EditPlayerException;
import com.winners.isetch.fmeapi.exceptionPlayer.GetListPlayerException;
import com.winners.isetch.fmeapi.exceptionPlayer.GetPlayerByIdException;


public class PlayerControllerTest {

	PlayerController playerController = new PlayerController();
	PlayerService playerService =mock(PlayerService.class);
	List<Player> l=new ArrayList<>();
	List<Player> l2=new ArrayList<>();
	Player player=new Player("firstName", "lastName", "phone", "natIdNum", "address", "mailAddress", 1.70, 70, "birthdate", "nationality", "photoUrl", "region", "city", "numpasseport", "comment", 1, "licenseNumber", 1, 1, 1, "category");
	Player player2=new Player("firstName", "lastName", "phone", "natIdNum", "address", "mailAddress", 1.70, 70, "birthdate", "nationality", "photoUrl", "region", "city", "numpasseport", "comment", 2, "licenseNumber", 2, 2, 2, "category");
	
	@Before
	public void setUp() {
		playerController.setPlayerService(playerService);
		l.add(player);
		l.add(player2);
		l2.add(player);
		l2.add(player2);
	}

	@Test
	public void testGetAllPlayers() throws GetListPlayerException {
		when(playerService.getPlayers()).thenReturn(l);
		assertEquals(l2,playerController.getAllPlayers());
		verify(playerService).getPlayers();
	}

	@Test
	public void testGetPlayerById() throws GetPlayerByIdException {
		when(playerService.getPlayer(player.getId())).thenReturn(player);
		assertEquals(player,playerController.getPlayerById(player.getId()));
		verify(playerService).getPlayer(player.getId());
	}

	@Test
	public void testAddPlayer() throws AddPlayerException {
		playerController.addPlayer(player);
		verify(playerService).addPlayer(player);
		
	}

	@Test
	public void testEditPlayer() throws EditPlayerException {
		playerController.editPlayer(player, player.getId());
		verify(playerService).editPlayer(player, player.getId());
	}

	@Test
	public void testDeletePlayer() throws DeletePlayerException {
		playerController.deletePlayer(player.getId());
		verify(playerService).deletePlayer(player.getId());
	}

	@Test
	public void testSetPlayerService() throws DeleteAllException {
		playerController.deleteAllPlayers();
		verify(playerService).deleteAllPlayers();
		}

}
