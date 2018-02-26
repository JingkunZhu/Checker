package UnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Checker.Board;
import Checker.PieceKing1;
import Checker.PieceKing2;
import Checker.Player;
import Checker.Position;

public class PieceKing2Test {
	Board b = new Board();
	Player p1 = new Player(1);
	Player p2 = new Player(2);	
	PieceKing2 pk2 = new PieceKing2(b, p2);

	@Test
	public void testIsValidPosition() {
		pk2.oldPosition = new Position(1,1);
		pk2.newPosition = new Position(0,9);
		assertFalse("on board", pk2.isValidPosition());
		pk2.newPosition = new Position(3,2);
		assertFalse("right pos", pk2.isValidPosition());
		pk2.newPosition = new Position(3,2);
		assertFalse("valid", pk2.isValidPosition());
		pk2.newPosition = new Position(0,3);
		assertFalse("valid", pk2.isValidPosition());
		pk2.oldPosition = new Position(3,3);
		pk2.newPosition = new Position(0,2);
		assertFalse("valid", pk2.isValidPosition());
		pk2.oldPosition = new Position(1,1);
		pk2.newPosition = new Position(0,2);
		assertTrue("not valid", pk2.isValidPosition());
		b.board[0][3] = 0;
		pk2.oldPosition = new Position(2,1);
		pk2.newPosition = new Position(0,3);
		assertTrue("not valid", pk2.isValidPosition());
		b.board[1][2] = 2;
		pk2.oldPosition = new Position(2,1);
		pk2.newPosition = new Position(0,3);
		assertFalse("valid", pk2.isValidPosition());
		b.board[1][2] = 1;
		pk2.oldPosition = new Position(3,0);
		pk2.newPosition = new Position(0,3);
		assertFalse("valid", pk2.isValidPosition());
		
	}

}
