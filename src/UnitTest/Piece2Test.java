package UnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Checker.Board;
import Checker.Piece1;
import Checker.Piece2;
import Checker.Player;
import Checker.Position;

public class Piece2Test {
	Board b = new Board();
	Player p1 = new Player(1);
	Player p2 = new Player(2);	
	Piece2 P21 = new Piece2(b, p1);
	Piece2 P22 = new Piece2(b, p2);
	

	@Test
	public void testIsValidPositionOnBoard() {
		P22.oldPosition = new Position(5,2);
		P22.newPosition = new Position(9,1);
		assertFalse("on board",P22.isValidPosition());
		P22.newPosition = new Position(4,3);
		assertTrue("not on board",P22.isValidPosition());
	}
	@Test
	public void testIsValidPositionRightPosition() {
		P22.oldPosition = new Position(5,2);
		P22.newPosition = new Position(5,4);
		assertFalse("right pos",P22.isValidPosition());
	}


	@Test
	public void testIsValidPosition() {
		P22.oldPosition = new Position(5,2);
		P22.newPosition = new Position(4,3);
		assertTrue("not valid",P22.isValidPosition());
		P22.newPosition = new Position(4,2);
		assertFalse("valid",P22.isValidPosition());
		P22.newPosition = new Position(5,3);
		assertFalse("valid",P22.isValidPosition());
		P22.newPosition = new Position(3,5);
		assertFalse("valid",P22.isValidPosition());
		b.board[1][4] = 0;
		P22.oldPosition = new Position(3,2);
		P22.newPosition = new Position(1,4);
		assertTrue("not valid",P22.isValidPosition());
		b.board[2][3] = 0;
		P22.oldPosition = new Position(3,2);
		P22.newPosition = new Position(1,4);
		assertFalse("valid",P22.isValidPosition());
		b.board[1][4] = 1;
		b.board[1][0] = 0;
		P22.oldPosition = new Position(3,2);
		P22.newPosition = new Position(1,0);
		assertTrue("not valid",P22.isValidPosition());
		b.board[2][1] = 0;
		P22.oldPosition = new Position(3,2);
		P22.newPosition = new Position(1,0);
		assertFalse("valid",P22.isValidPosition());
		
	}

	@Test
	public void testIfCouldContinue() {
		P22.oldPosition = new Position(5,2);
		P22.newPosition = new Position(4,3);
		assertFalse("continue",P22.ifCouldContinue());
		P22.oldPosition = new Position(3,3);
		P22.newPosition = new Position(1,1);
		assertFalse("continue",P22.ifCouldContinue());
		P22.oldPosition = new Position(4,4);
		P22.newPosition = new Position(2,2);
		assertFalse("continue",P22.ifCouldContinue());
		P22.oldPosition = new Position(2,2);
		P22.newPosition = new Position(0,4);
		assertFalse("continue",P22.ifCouldContinue());
		P22.oldPosition = new Position(2,2);
		P22.newPosition = new Position(4,1);
		assertFalse("continue",P22.ifCouldContinue());
		P22.oldPosition = new Position(2,2);
		P22.newPosition = new Position(3,4);
		assertFalse("continue",P22.ifCouldContinue());
		b.board[2][1] = 2;
		P22.oldPosition = new Position(4,3);
		P22.newPosition = new Position(2,1);
		assertFalse("continue",P22.ifCouldContinue());
		b.board[0][3] = 0;
		P22.oldPosition = new Position(4,3);
		P22.newPosition = new Position(2,1);
		assertTrue("not continue",P22.ifCouldContinue());
		b.board[0][3] = 1;
		b.board[2][5] = 0;
		P22.oldPosition = new Position(4,3);
		P22.newPosition = new Position(2,5);
		assertFalse("continue",P22.ifCouldContinue());
		b.board[0][3] = 0;
		P22.oldPosition = new Position(4,3);
		P22.newPosition = new Position(2,5);
		assertTrue("not continue",P22.ifCouldContinue());
	}

}
