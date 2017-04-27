class Waffle {
	private int [][]board;
	private int height, width;

	public Waffle(int h, int w) {
		this.width = (int)Math.pow(2, w);
		this.height = (int)Math.pow(3, h);
		board = new int[this.width][this.height];

		for (int row=0; row < this.width; row++) {
			for (int col=0; col < this.height; col++) {
				this.board[row][col] = 0;
			}
		}
	}

	public boolean isEatable(int row, int col) {
		return (this.board[row][col] == 0);
	}
	public eatCase(row, col, currentMove) {
		this.board[row][col] = currentMove;
	}
	
	public boolean isAWin() {
		return (this.board[0][0] == -1);
	}

}