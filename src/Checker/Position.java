package Checker;

public class Position {
	private int x, y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean isOnBoard() { // 判断位置是否在棋盘上
		return (x >= 0 && x <= 7 && y >= 0 && y <= 7);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
