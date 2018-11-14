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
import com.winners.isetch.fmrapi.exceptionPlayer.AddPlayerException;
import com.winners.isetch.fmrapi.exceptionPlayer.DeleteAllException;
import com.winners.isetch.fmrapi.exceptionPlayer.DeletePlayerException;
import com.winners.isetch.fmrapi.exceptionPlayer.EditPlayerException;
import com.winners.isetch.fmrapi.exceptionPlayer.GetListPlayerException;
import com.winners.isetch.fmrapi.exceptionPlayer.GetPlayerByIdException;


public class PlayerControllerTest {

	PlayerController playerController = new PlayerController();
	PlayerService playerService =mock(PlayerService.class);
	List<Player> l=new ArrayList<>();
	List<Player> l2=new ArrayList<>();
	Player player=new Player(111,"111", "categorie", "nom", "prenom", "urlPhoto", "dateDaNaissance", "nationalite", "adresse",11111, 124556, "numTel", "email",170, 70, 100001, 10, "commentaire");
	Player player2=new Player(222,"222", "categorie", "nom", "prenom", "urlPhoto", "dateDaNaissance", "nationalite", "adresse",222222, 25494, "numTel", "email",170, 70, 200002, 10, "commentaire");
	
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
		when(playerService.getPlayer(111)).thenReturn(player);
		assertEquals(player,playerController.getPlayerById(111));
		verify(playerService).getPlayer(111);
	}

	@Test
	public void testAddPlayer() throws AddPlayerException {
		playerController.addPlayer(player);
		verify(playerService).addPlayer(player);
		
	}

	@Test
	public void testEditPlayer() throws EditPlayerException {
		playerController.editPlayer(player, 111);
		verify(playerService).editPlayer(player, 111);
	}

	@Test
	public void testDeletePlayer() throws DeletePlayerException {
		playerController.deletePlayer(111);
		verify(playerService).deletePlayer(111);
	}

	@Test
	public void testSetPlayerService() throws DeleteAllException {
		playerController.deleteAllPlayers();
		verify(playerService).deleteAllPlayers();
		}

}
