import java.io.*;

class Waffle {
	private int [][]board;
	private int height, width;

	public Waffle(int h, int w) {
		//this.width = (int)Math.pow(3, w);
		//this.height = (int)Math.pow(2, h);
		this.width = w;
		this.height = h;
		board = new int[this.height][this.width];


		// Initialise la gauffre à 0
		for (int row=0; row < this.height; row++) {
			for (int col=0; col < this.width; col++) {
				this.board[row][col] = 0;
			}
		}
	}

	public Waffle(int h, int w, int[][] tempBoard) {
		this.width = w;
		this.height = h;
		board = new int[this.height][this.width];
		board = tempBoard;


		// Initialise la gauffre à 0
		/*for (int row=0; row < this.height; row++) {
			for (int col=0; col < this.width; col++) {
				this.board[row][col] = 0;
			}
		}*/
	}

	// Renvoie la valeur de la case (row, col)
	public int getValue(int row, int col) {
		return this.board[row][col];
	}
	// Renvoie la hauteur de la gauffre
	public int getHeight() {
		return this.height;
	}
	// Renvoie la largeur de la gauffre (row, col)
	public int getWidth() {
		return this.width;
	}

	// Réinitialise une case (row, col)
	public void revert(int row, int col) {
		this.board[row][col] = 0;
	}

	// Retourne vrai si la case (row, col) est mangeable
	public boolean isEatable(int row, int col) {
		return (this.board[row][col] == 0);
	}

	// Mange une case mageable
	// Affecte à la case (row, col) le numéro du coup (Gestion de l'historique)
	public void eatCase(int row, int col, int moveNb) {
		this.board[row][col] = moveNb;
	}

	// Verifie si un joueur à mangé la case empoisonnée (0,0)
	public boolean isAWin() {
		return !isEatable(0, 0);
	}

	public boolean isInWaffle(int row, int col){
		return (row>=0 && col>=0 && row<this.height && col<this.width);
	}
}
