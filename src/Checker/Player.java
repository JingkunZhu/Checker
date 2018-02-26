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

	public void nextPlayer() { // 转换玩家，即玩家1结束后玩家2操作，在主函数循环的最后执行
		if (player == 1) {
			player = 2;
		} else {
			player = 1;
		}
	}
}
