import java.io.*;

class Waffle {
	private int [][]board;
	private int height, width;

	public Waffle(int h, int w) {
		this.width = (int)Math.pow(2, w);
		this.height = (int)Math.pow(3, h);
		board = new int[this.height][this.width];


		// Initialise la gauffre à 0
		for (int row=0; row < this.height; row++) {
			for (int col=0; col < this.width; col++) {
				this.board[row][col] = 0;
			}
		}
	}

	// Retourne vrai si la case est mangeable
	public boolean isEatable(int row, int col) {
		return (this.board[row][col] == 0);
	}

	// Mange une case mageable
	// Affecte à la case le numéro du coup (Gestion de l'historique)
	public eatCase(row, col, moveNb) {
		this.board[row][col] = moveNb;
	}

	// Verifie si un joueur à mangé la case empoisonnée
	public boolean isAWin() {
		return !isEatable(0, 0);
	}
}