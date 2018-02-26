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
		if (oldPosition.isOnBoard()) { // 判断输入的位置是否在棋盘上
			if ((b.getPiece(p) == player.getPlayer()) || (b.getPiece(p) == -player.getPlayer())) { // 判断选择的棋子是否正确以及是否有棋子
				switch (b.getPiece(p)) { // 根据不同棋子判断选择的棋子是否能进行后续移动
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
					// 关于所选的king1能否移动的判断，省略……
					return true;
				case -2:
					// 关于所选的king2能否移动的判断，省略……
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
