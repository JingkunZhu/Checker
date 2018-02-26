package Checker;

public class Piece {
	protected Position oldPosition;
	protected Position newPosition;
	protected Board board;
	protected Player player;

	protected int diffX() {
		return newPosition.getX() - oldPosition.getX();
	}

	protected int diffY() {
		return newPosition.getY() - oldPosition.getY();
	}

	public Piece(Board b, Player p) {
		this.board = b;
		this.player = p;
	}

	public void selectOldPosition(Position oldPosition) {
		this.oldPosition = oldPosition;
	}

	public boolean isValidOldPosition(Board b, Position p) {
		if (oldPosition.isOnBoard()) { // �ж������λ���Ƿ���������
			if ((b.getPiece(p) == player.getPlayer()) || (b.getPiece(p) == -player.getPlayer())) { // �ж�ѡ��������Ƿ���ȷ�Լ��Ƿ�������
				switch (b.getPiece(p)) { // ���ݲ�ͬ�����ж�ѡ��������Ƿ��ܽ��к����ƶ�
				case 1:
					if (((new Position(p.getX() + 1, p.getY() + 1).isOnBoard())
							&& (b.getPiece(new Position(p.getX() + 1, p.getY() + 1)) == 0))
							|| ((new Position(p.getX() + 1, p.getY() - 1).isOnBoard())
									&& (b.getPiece(new Position(p.getX() + 1, p.getY() - 1)) == 0))
							|| ((new Position(p.getX() + 1, p.getY() + 1).isOnBoard())
									&& (Math.abs(b.getPiece(new Position(p.getX() + 1, p.getY() + 1))) == 2)
									&& (new Position(p.getX() + 2, p.getY() + 2).isOnBoard())
									&& (b.getPiece(new Position(p.getX() + 2, p.getY() + 2)) == 0))
							|| ((new Position(p.getX() + 1, p.getY() - 1).isOnBoard())
									&& (Math.abs(b.getPiece(new Position(p.getX() + 1, p.getY() - 1))) == 2)
									&& (new Position(p.getX() + 2, p.getY() - 2).isOnBoard())
									&& (b.getPiece(new Position(p.getX() + 2, p.getY() - 2)) == 0))) {
						return true;
					} else {
						System.out.println("This piece could not be moved...");
						return false;
					}
				case 2:
					if (((new Position(p.getX() - 1, p.getY() + 1).isOnBoard())
							&& (b.getPiece(new Position(p.getX() - 1, p.getY() + 1)) == 0))
							|| ((new Position(p.getX() - 1, p.getY() - 1).isOnBoard())
									&& (b.getPiece(new Position(p.getX() - 1, p.getY() - 1)) == 0))
							|| ((new Position(p.getX() - 1, p.getY() + 1).isOnBoard())
									&& (Math.abs(b.getPiece(new Position(p.getX() - 1, p.getY() + 1))) == 1)
									&& (new Position(p.getX() - 2, p.getY() + 2).isOnBoard())
									&& (b.getPiece(new Position(p.getX() - 2, p.getY() + 2)) == 0))
							|| ((new Position(p.getX() - 1, p.getY() - 1).isOnBoard())
									&& (Math.abs(b.getPiece(new Position(p.getX() - 1, p.getY() - 1))) == 1)
									&& (new Position(p.getX() - 2, p.getY() - 2).isOnBoard())
									&& (b.getPiece(new Position(p.getX() - 2, p.getY() - 2)) == 0))) {
						return true;
					} else {
						System.out.println("This piece could not be moved...");
						return false;
					}
				case -1:
					// ������ѡ��king1�ܷ��ƶ����жϣ�ʡ�ԡ���
					return true;
				case -2:
					// ������ѡ��king2�ܷ��ƶ����жϣ�ʡ�ԡ���
					return true;
				default:
					return false;
				}
			} else {
				System.out.println("Not your piece...");
				return false;
			}
		} else {
			System.out.println("Not on board...");
			return false;
		}
	}

	public void selectNewPosition(Position newPosition) {
		this.newPosition = newPosition;
	}
}
