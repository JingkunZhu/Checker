package Checker;

import java.util.Scanner;

public class PlayingChecker {

	public static void main(String[] args) {
		int x, y;
		Position oldPosition, newPosition;
		Board board = new Board();
		Player player = new Player(1);
		Scanner s = new Scanner(System.in);
		Piece piece = new Piece(board, player);

		while (true) {
			board.printBoard();
			System.out.println("Turn of player no. " + player.getPlayer());
			loop: while (true) {
				System.out.print("Coordinate of piece to move.\nEnter X: ");
				x = s.nextInt();
				System.out.print("Enter Y: ");
				y = s.nextInt();
				oldPosition = new Position(x, y);
				piece.selectOldPosition(oldPosition);
				if (!piece.isValidOldPosition(board, oldPosition)) {
					continue loop;
				}
				switch (board.getPiece(oldPosition)) {
				case 1:
					piece = new Piece1(board, player);
					break loop;
				case 2:
					piece = new Piece2(board, player);
					break loop;
				case -1:
					piece = new PieceKing1(board, player);
					break loop;
				case -2:
					piece = new PieceKing2(board, player);
					break loop;
				}
			}
			while (true) {
				System.out.print("Coordinate of new position.\nEnter X: ");
				x = s.nextInt();
				System.out.print("Enter Y: ");
				y = s.nextInt();
				newPosition = new Position(x, y);
				piece.selectOldPosition(oldPosition);
				piece.selectNewPosition(newPosition);
				if (piece instanceof Piece1) {
					if (((Piece1) piece).isValidPosition()) {
						if (((Piece1) piece).ifCouldContinue()) {
							System.out.print("Continue move...\n");
							oldPosition = newPosition;
							continue;
						} else {
							break;
						}
					} else {
						continue;
					}
				}
				if (piece instanceof Piece2) {
					if (((Piece2) piece).isValidPosition()) {
						if (((Piece2) piece).ifCouldContinue()) {
							System.out.print("Continue move...\n");
							oldPosition = newPosition;
							continue;
						} else {
							break;
						}
					} else {
						continue;
					}
				}
				if (piece instanceof PieceKing1) {
					if (((PieceKing1) piece).isValidPosition()) {
						break;
					} else {
						continue;
					}
				}
				if (piece instanceof PieceKing2) {
					if (((PieceKing2) piece).isValidPosition()) {
						break;
					} else {
						continue;
					}
				}
			}
			board.updatedBoard(oldPosition, newPosition, player);
			player.nextPlayer();
		}
	}

}
