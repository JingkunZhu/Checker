package Checker;

public class PieceKing1 extends Piece implements NewPositionValid {
	public PieceKing1(Board b, Player p) {
		super(b, p);
	}

	public boolean isValidPosition() {
		if (newPosition.isOnBoard()) {
			if (board.getPiece(newPosition) == 0) {
				if (Math.abs(diffX()) == Math.abs(diffY())) {
					int recordX = 8, recordY = 8;
					int opponentPiece = 0;
					int ownPiece = 0;
					int incrementX = diffX() / Math.abs(diffX());
					int incrementY = diffY() / Math.abs(diffY());
					for (int n = 1; n < Math.abs(diffX()); n++) {
						switch (board.getPiece(new Position(oldPosition.getX() + n * incrementX,
								oldPosition.getY() + n * incrementY))) {
						case 1:
						case -1:
							ownPiece++;
							break;
						case 2:
						case -2:
							opponentPiece++;
							recordX = oldPosition.getX() + n * incrementX;
							recordY = oldPosition.getY() + n * incrementY;
							break;
						default:
							break;
						}
					}
					if (ownPiece == 0 && opponentPiece == 0) { // 新位置和老位置之间不存在棋子则可以执行
						return true;
					} else if (ownPiece == 0 && opponentPiece == 1) { // 新位置和老位置之间存在对手棋子则吃掉该棋子
						board.removePiece(recordX, recordY);
						return true;
					}
				}
			}
			System.out.println("Wrong position...");
			return false;
		} else {
			System.out.println("Not on board...");
			return false;
		}
	}
}
