package UnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Checker.Board;
import Checker.PieceKing1;
import Checker.Player;
import Checker.Position;

public class PieceKing1Test {
	Board b = new Board();
	Player p1 = new Player(1);
	Player p2 = new Player(2);	
	PieceKing1 pk1 = new PieceKing1(b, p1);

	@Test
	public void testIsValidPosition() {
		pk1.oldPosition = new Position(6,2);
		pk1.newPosition = new Position(9,4);
		assertFalse("on board", pk1.isValidPosition());
		pk1.newPosition = new Position(7,0);
		assertFalse("right pos", pk1.isValidPosition());
		pk1.newPosition = new Position(4,3);
		assertFalse("valid", pk1.isValidPosition());
		pk1.newPosition = new Position(5,0);
		assertFalse("valid", pk1.isValidPosition());
		pk1.newPosition = new Position(7,4);
		assertFalse("valid", pk1.isValidPosition());

		pk1.oldPosition = new Position(6,2);
		pk1.newPosition = new Position(7,3);
		assertTrue("not valid", pk1.isValidPosition());
		b.board[7][4] = 0;
		pk1.oldPosition = new Position(5,2);
		pk1.newPosition = new Position(7,4);
		assertTrue("not valid", pk1.isValidPosition());
		b.board[6][3] = 1;
		pk1.oldPosition = new Position(5,2);
		pk1.newPosition = new Position(7,4);
		assertFalse("valid", pk1.isValidPosition());
		b.board[6][3] = 2;
		pk1.oldPosition = new Position(4,1);
		pk1.newPosition = new Position(7,4);
		assertFalse("valid", pk1.isValidPosition());
		
	}

}
