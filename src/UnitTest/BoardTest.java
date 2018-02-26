package UnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Checker.Board;
import Checker.Player;
import Checker.Position;

public class BoardTest {
	
	Board b = new Board();
	int [][] x = b.board;

	Player p1 = new Player(1);
	Player p2 = new Player(2);

	@Test
	public void testGetPiece() {
		Position p = new Position(2,5);
		assertEquals(1,b.getPiece(p));
	}

	@Test
	public void testUpdatedBoard() {
		Position oldPosition = new Position(2,0);
		Position newPosition= new Position(4,1);
		assertEquals(0,b.getPiece(oldPosition));
		b.updatedBoard(oldPosition,newPosition, p1);
		assertEquals(1,b.flag);
		b.board[7][1] = -1;
		oldPosition = new Position(7,1);
		newPosition= new Position(6,0);
		b.updatedBoard(oldPosition, newPosition, p1);
		assertEquals(-1,b.flag);
		b.board[0][2] = -2;
		oldPosition = new Position(0,2);
		newPosition= new Position(1,1);
		b.updatedBoard(oldPosition, newPosition, p2);
		assertEquals(-2,b.flag);
		
	}

	@Test
	public void testRemovePiece() {
		b.removePiece(2, 5);
		assertEquals(0,b.flag);
	}

	@Test
	public void testPrintBoard() {
		b.printBoard();
		assertEquals(5,b.flag);
	}

}
