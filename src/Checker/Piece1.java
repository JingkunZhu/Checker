package Checker;

public class Piece1 extends Piece implements NewPositionValid {
	public Piece1(Board b, Player p) {
		super(b, p);
	}

	public boolean isValidPosition() { // ���¾�λ�õĹ�ϵ�ж���λ���Ƿ����
		if (newPosition.isOnBoard()) {
			if (board.getPiece(newPosition) == 0) {
				if ((diffX() == 1) && (Math.abs(diffY()) == 1)) {
					return true;
				} else if (((diffX() == 2) && (((diffY() == 2)
						&& (board.getPiece(new Position((oldPosition.getX() + 1), (oldPosition.getY() + 1))) == 2))
						|| ((diffY() == -2) && (board
								.getPiece(new Position((oldPosition.getX() + 1), (oldPosition.getY() - 1))) == 2))))) {
					board.removePiece((oldPosition.getX() + newPosition.getX()) / 2,
							(oldPosition.getY() + newPosition.getY()) / 2);
					return true;
				}
				else return false;
			}
			System.out.println("Wrong position...");
			return false;
		} else {
			System.out.println("Not on board...");
			return false;
		}
	}

	public boolean ifCouldContinue() { // �ж��Ƿ��ܹ�����������������������У�����������ѭ��ʵ�֣�
		if ((Math.abs(diffX()) == 2) && (Math.abs(diffY()) == 2)) {
			if ((((new Position((newPosition.getX() + 1), (newPosition.getY() + 1)).isOnBoard())
					&& (new Position((newPosition.getX() + 2), (newPosition.getY() + 2)).isOnBoard())
					&& (board.getPiece(new Position((newPosition.getX() + 1), (newPosition.getY() + 1))) == 2)
					&& (board.getPiece(new Position((newPosition.getX() + 2), (newPosition.getY() + 2))) == 0))
					|| ((new Position((newPosition.getX() + 1), (newPosition.getY() - 1)).isOnBoard())
							&& (new Position((newPosition.getX() + 2), (newPosition.getY() - 2)).isOnBoard())
							&& (board.getPiece(new Position((newPosition.getX() + 1), (newPosition.getY() - 1))) == 2)
							&& (board.getPiece(new Position((newPosition.getX() + 2), (newPosition.getY() - 2))) == 0)))) {
				return true;
			}
		}
		return false;
	}
}
