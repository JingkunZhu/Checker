package UnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Checker.Player;

public class PlayerTest {
	Player p1 = new Player(1);
	Player p2 = new Player(2);

	@Test
	public void testGetPlayer() {
		assertEquals(1, p1.getPlayer());
	}

	@Test
	public void testNextPlayer() {
		p1.nextPlayer();
		assertEquals(2, p1.flag);
		p2.nextPlayer();
		assertEquals(1, p2.flag);

	}

}
