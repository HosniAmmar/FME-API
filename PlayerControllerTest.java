package com.winners.isetch.fmeapi.Controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import com.winners.isetch.fmeapi.Entity.Player;
import com.winners.isetch.fmeapi.Service.PlayerService;

public class PlayerControllerTest {

	PlayerController playerController = new PlayerController();
	PlayerService playerService =mock(PlayerService.class);
	List<Player> l=new ArrayList<>();
	List<Player> l2=new ArrayList<>();
	Player player=new Player(111, "med", 55664455, 122);
	Player player2=new Player(222, "ali", 22554466, 211);
	@Before
	public void setUp() {
		playerController.setPlayerService(playerService);
		l.add(player);
		l.add(player2);
		l2.add(player);
		l2.add(player2);
	}

	@Test
	public void testGetAllPlayers() {
		when(playerService.getPlayers()).thenReturn(l);
		assertEquals(l2,playerController.getAllPlayers());
		verify(playerService).getPlayers();
	}

	@Test
	public void testGetPlayerById() {
		when(playerService.getPlayer(111)).thenReturn(player);
		assertEquals(player,playerController.getPlayerById(111));
		verify(playerService).getPlayer(111);
	}

	@Test
	public void testAddPlayer() {
		playerController.addPlayer(player);
		verify(playerService).addPlayer(player);
		
	}

	@Test
	public void testEditPlayer() {
		playerController.editPlayer(player, 111);
		verify(playerService).editPlayer(player, 111);
	}

	@Test
	public void testDeletePlayer() {
		playerController.deletePlayer(111);
		verify(playerService).deletePlayer(111);
	}

}
