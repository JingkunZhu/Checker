package UnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Checker.Board;
import Checker.Piece1;
import Checker.Player;
import Checker.Position;

public class Piece1Test {
	Board b = new Board();
	Player p1 = new Player(1);
	Player p2 = new Player(2);	
	Piece1 P11 = new Piece1(b, p1);
	Piece1 P12 = new Piece1(b, p2);

	@Test
	public void testIsValidPositionOnBoard() {
		P11.oldPosition = new Position(2,5);
		P11.newPosition = new Position(-1,5);
		assertFalse("on board",P11.isValidPosition());
		P11.newPosition = new Position(3,4);
		assertTrue("not on board",P11.isValidPosition());
	}
	
	@Test
	public void testIsValidPositionRightPosition() {
		P11.oldPosition = new Position(2,5);
		P11.newPosition = new Position(1,2);
		assertFalse("right pos",P11.isValidPosition());
	}

	@Test
	public void testIsValidPosition() {
		P11.oldPosition = new Position(2,5);
		P11.newPosition = new Position(3,4);
		assertTrue("not on board", P11.newPosition.isOnBoard());
		assertTrue("not valid",P11.isValidPosition());
		P11.newPosition = new Position(2,4);
		assertFalse("valid",P11.isValidPosition());
		P11.newPosition = new Position(3,5);
		assertFalse("valid",P11.isValidPosition());
		P11.oldPosition = new Position(3,3);
		P11.newPosition = new Position(5,5);
		assertFalse("valid",P11.isValidPosition());
		P11.newPosition = new Position(5,1);
		assertFalse("valid",P11.isValidPosition());
		b.board[4][3] = 1;
		b.board[6][5] = 0;
		P11.oldPosition = new Position(4,3);
		P11.newPosition = new Position(6,5);
		assertTrue("not valid",P11.isValidPosition());
		b.board[6][5] = 2;
		b.board[6][1] = 0;
		P11.oldPosition = new Position(4,3);
		P11.newPosition = new Position(6,1);
		assertTrue("not valid",P11.isValidPosition());
		
		
	}

	@Test
	public void testIfCouldContinue() {
		P11.oldPosition = new Position(5,3);
		P11.newPosition = new Position(7,1);
		assertFalse("continue",P11.ifCouldContinue());
		P11.oldPosition = new Position(4,3);
		P11.newPosition = new Position(6,1);
		assertFalse("continue",P11.ifCouldContinue());
		P11.oldPosition = new Position(4,3);
		P11.newPosition = new Position(3,1);
		assertFalse("continue",P11.ifCouldContinue());
		P11.oldPosition = new Position(4,3);
		P11.newPosition = new Position(2,1);
		assertFalse("continue",P11.ifCouldContinue());
		P11.oldPosition = new Position(3,2);
		P11.newPosition = new Position(5,3);
		assertFalse("continue",P11.ifCouldContinue());	
		P11.oldPosition = new Position(3,2);
		P11.newPosition = new Position(5,4);
		assertFalse("continue",P11.ifCouldContinue());	
		b.board[4][3] = 2;
		b.board[7][6] = 0;
		P11.oldPosition = new Position(3,2);
		P11.newPosition = new Position(5,4);
		assertTrue("not continue",P11.ifCouldContinue());
		b.board[6][1] = 0;
		P11.oldPosition = new Position(3,4);
		P11.newPosition = new Position(5,2);
		assertFalse("continue",P11.ifCouldContinue());
		b.board[6][1] = 2;
		b.board[7][0] = 0;
		assertTrue("not continue",P11.ifCouldContinue());
	}

}
