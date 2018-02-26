package UnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Checker.Board;
import Checker.Piece;
import Checker.Player;
import Checker.Position;

public class PieceTest {

	Board b = new Board();
	Position p;
	Position newp;
	Player p1 = new Player(1);
	Player p2 = new Player(2);
	Piece P1 = new Piece(b, p1);
	Piece P2 = new Piece(b, p2);
	
	@Test
	public void testDiffX() {
		P1.oldPosition = new Position(2,5);
		P1.newPosition = new Position(3,4);
		assertEquals(1, P1.diffX());
		P2.oldPosition = new Position(5,4);
		P2.newPosition = new Position(4,3);
		assertEquals(-1, P2.diffX());
		
	}

	@Test
	public void testDiffY() {
		P1.oldPosition = new Position(2,5);
		P1.newPosition = new Position(3,4);
		assertEquals(-1, P1.diffY());
		P2.oldPosition = new Position(5,4);
		P2.newPosition = new Position(4,3);
		assertEquals(-1, P2.diffY());
	}

	@Test
	public void testPiece() {
		assertEquals(0,P1.flag);
		assertEquals(0,P2.flag);
	}

	@Test
	public void testSelectOldPosition() {
		P1.selectOldPosition(p);
		assertEquals(-1, P1.flag);
		P2.selectOldPosition(p);
		assertEquals(-1, P2.flag);
	}
	
	@Test
	public void testIsValidOldPositionOnBoard() {
		P2.oldPosition = new Position(12,5);
		assertFalse("is on board",P2.isValidOldPosition(b, P2.oldPosition));
		P2.oldPosition = new Position(5,4);
		assertTrue("not on board",P2.isValidOldPosition(b, P2.oldPosition));
	}
	
	@Test
	public void testIsValidOldPositionRightPiece() {
		P1.oldPosition = new Position(2,5);
		assertTrue("not on board",P1.oldPosition.isOnBoard());
		assertEquals(1,b.getPiece(P1.oldPosition));
		P2.oldPosition = new Position(2,5);
		assertFalse(P2.isValidOldPosition(b, P2.oldPosition));
	}

	@Test
	public void testIsValidOldPosition1() {
		P1.oldPosition = new Position(2,5);
		assertTrue("not on board",P1.oldPosition.isOnBoard());
		assertEquals(1,b.getPiece(P1.oldPosition));
		assertTrue("not valid", P1.isValidOldPosition(b, P1.oldPosition));
		P1.oldPosition = new Position(0,1);
		assertTrue("not on board",P1.oldPosition.isOnBoard());
		assertEquals(1,b.getPiece(P1.oldPosition));
		assertFalse("valid", P1.isValidOldPosition(b, P1.oldPosition));
		b.board[1][0] = 0;
		P1.oldPosition = new Position(0,1);
		assertTrue("not on board",P1.oldPosition.isOnBoard());
		assertEquals(1,b.getPiece(P1.oldPosition));
		assertTrue("not valid", P1.isValidOldPosition(b, P1.oldPosition));
		P1.oldPosition = new Position(5,6);
		assertFalse("is on board",P1.isValidOldPosition(b, P1.oldPosition));
		b.board[6][3] = 1;
		P1.oldPosition = new Position(6,3);
		assertFalse("valid", P1.isValidOldPosition(b, P1.oldPosition));
		P1.oldPosition = new Position(0,7);
		assertFalse("is on board",P1.isValidOldPosition(b, P1.oldPosition));
		assertFalse("valid", P1.isValidOldPosition(b, P1.oldPosition));
		b.board[1][0] = 1;
		P1.oldPosition = new Position(1,0);
		assertTrue("not on board",P1.oldPosition.isOnBoard());
		assertEquals(1,b.getPiece(P1.oldPosition));
		assertFalse("valid", P1.isValidOldPosition(b, P1.oldPosition));
		b.board[4][1] = 1;
		P1.oldPosition = new Position(4,1);
		assertFalse("valid", P1.isValidOldPosition(b, P1.oldPosition));
		b.board[6][3] = 0;
		assertTrue("not valid", P1.isValidOldPosition(b, P1.oldPosition));
		b.board[4][7] = 1;
		P1.oldPosition = new Position(4,7);
		assertFalse("valid", P1.isValidOldPosition(b, P1.oldPosition));
		b.board[6][5] = 0;
		P1.oldPosition = new Position(4,7);
		assertTrue("not valid", P1.isValidOldPosition(b, P1.oldPosition));
	}

	@Test
	public void testIsValidOldPosition2() {
		b.board[4][1] = b.board[4][7] = 0;
		b.board[6][3] = b.board[6][5] = 2;
		P2.oldPosition = new Position(5,4);
		assertTrue("not on board",P2.oldPosition.isOnBoard());
		assertEquals(2,b.getPiece(P2.oldPosition));
		assertTrue("not valid", P2.isValidOldPosition(b, P2.oldPosition));
		P2.oldPosition = new Position(7,0);
		assertTrue("not on board",P2.oldPosition.isOnBoard());
		assertEquals(2,b.getPiece(P2.oldPosition));
		assertFalse("valid", P2.isValidOldPosition(b, P2.oldPosition));
		b.board[6][1] = 0;
		P2.oldPosition = new Position(7,0);
		assertTrue("not on board",P2.oldPosition.isOnBoard());
		assertEquals(2,b.getPiece(P2.oldPosition));
		assertTrue("not valid", P2.isValidOldPosition(b, P2.oldPosition));
		P2.oldPosition = new Position(6,7);
		assertTrue("not on board",P2.oldPosition.isOnBoard());
		assertEquals(2,b.getPiece(P2.oldPosition));
		assertFalse("valid", P2.isValidOldPosition(b, P2.oldPosition));
		b.board[6][1] = 2;
		b.board[3][2] = 2;
		P2.oldPosition = new Position(3,2);
		assertTrue("not on board",P2.oldPosition.isOnBoard());
		assertEquals(2,b.getPiece(P2.oldPosition));
		assertFalse("valid", P2.isValidOldPosition(b, P2.oldPosition));
		b.board[1][0] = 0;
		P2.oldPosition = new Position(3,2);
		assertTrue("not on board",P2.oldPosition.isOnBoard());
		assertEquals(2,b.getPiece(P2.oldPosition));
		assertTrue("not valid", P2.isValidOldPosition(b, P2.oldPosition));
		b.board[1][0] = 1;
		b.board[3][7] = 2;
		P2.oldPosition = new Position(3,7);
		assertTrue("not valid", P2.isValidOldPosition(b, P2.oldPosition));
		b.board[3][7] = 0;
		b.board[3][6] = 2;
		P2.oldPosition = new Position(3,6);
		assertFalse("valid", P2.isValidOldPosition(b, P2.oldPosition));
		b.board[2][1] = 2;
		b.board[0][3] = 0;
		P2.oldPosition = new Position(2,1);
		assertTrue("not valid", P2.isValidOldPosition(b, P2.oldPosition));
		
		
	}
	
	@Test
	public void testIsValidOldPositionKing() {
		b.board[4][0] = -1;
		P1.oldPosition = new Position(4,0);
		assertTrue("not valid", P1.isValidOldPosition(b, P1.oldPosition));
		b.board[7][3] = -2;
		P2.oldPosition = new Position(7,3);
		assertTrue("not valid", P2.isValidOldPosition(b, P2.oldPosition));
	}

	@Test
	public void testSelectNewPosition() {
		P1.selectNewPosition(newp);
		assertEquals(-2, P1.flag);
	}

}
