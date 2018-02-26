package Checker;

public class Board {
	private int[][] board;

	public Board(int[][] board) {
		this.board = board;
	}

	public Board() {
		int[][] x = { { 0, 1, 0, 1, 0, 1, 0, 1 }, { 1, 0, 1, 0, 1, 0, 1, 0 }, { 0, 1, 0, 1, 0, 1, 0, 1 },
				{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 2, 0, 2, 0, 2, 0, 2, 0 },
				{ 0, 2, 0, 2, 0, 2, 0, 2 }, { 2, 0, 2, 0, 2, 0, 2, 0 } };
		this.board = x;
	}

	public int getPiece(Position position) {
		return board[position.getX()][position.getY()];
	}

	public void updatedBoard(Position oldPosition, Position newPosition, Player player) { // �������̣�����λ�ñ�0����λ�ñ�����Ӷ�Ӧ����
		if (this.board[oldPosition.getX()][oldPosition.getY()] == -1) {
			this.board[newPosition.getX()][newPosition.getY()] = -1;
		} else if (this.board[oldPosition.getX()][oldPosition.getY()] == -2) {
			this.board[newPosition.getX()][newPosition.getY()] = -2;
		} else {
			this.board[newPosition.getX()][newPosition.getY()] = player.getPlayer();
		}
		this.board[oldPosition.getX()][oldPosition.getY()] = 0;

		for (int j = 0; j <= 7; j++) { // ÿ��ѭ���߽�鿴�Ƿ���������
			if (board[0][j] == 2) {
				board[0][j] = -2;
			}
		}
		for (int j = 0; j <= 7; j++) {
			if (board[7][j] == 1) {
				board[7][j] = -1;
			}
		}
	}

	public void removePiece(int x, int y) { // �����ɾ������������
		this.board[x][y] = 0;
	}

	public void printBoard() { // ��ӡ����
		System.out.print("X\\Y 0 1 2 3 4 5 6 7   \n");
		System.out.print("   +----------------+ \n");
		for (int i = 0; i <= 7; i++) {
			System.out.print(i + "  |");
			for (int j = 0; j <= 7; j++) {
				if (board[i][j] == 0) {
					System.out.print("  ");
				} else {
					System.out.print(board[i][j] + " ");
				}

			}
			System.out.print("| " + i);
			System.out.print("\n");
		}
		System.out.print("   +----------------+ \n");
		System.out.println("    0 1 2 3 4 5 6 7   \n");
	}
}
