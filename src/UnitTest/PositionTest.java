package UnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Checker.Position;

public class PositionTest {
	
	Position p;

	@Test
	public void testIsOnBoard() {
		p = new Position(2,5);
		assertTrue("not on board",p.isOnBoard() );
		p = new Position(-1,5);
		assertFalse("on board",p.isOnBoard() );
		p = new Position(1,9);
		assertFalse("on board",p.isOnBoard() );
		p = new Position(9,1);
		assertFalse("on board",p.isOnBoard() );
		p = new Position(5,-1);
		assertFalse("on board",p.isOnBoard() );
	
	}

	@Test
	public void testGetX() {
		p = new Position(2,5);
		assertEquals(2, p.getX());
	}

	@Test
	public void testGetY() {
		p = new Position(2,5);
		assertEquals(5, p.getY());
	}

}
