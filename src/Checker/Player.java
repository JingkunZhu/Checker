package Checker;

public class Player {
	private int player;

	public Player(int i) {
		if (i == 1) {
			this.player = 1;
		} else {
			this.player = 2;
		}
	}

	public int getPlayer() {
		return this.player;
	}

	public void nextPlayer() { // ת����ң������1���������2��������������ѭ�������ִ��
		if (player == 1) {
			player = 2;
		} else {
			player = 1;
		}
	}
}
