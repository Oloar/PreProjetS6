
import java.util.Scanner;
import java.util.Random;
import java.io.*;
import java.lang.Exception;


public class Joueur{

	final int HUMAN = 0;
	final int EASY = 1;
	final int MEDIUM = 2;
	final int HARD = 3;

	private int difficulty;
	private int number;
	Waffle waffle;

	public Joueur(int n, int d, Waffle w){

		this.number = n;
		if(d < 0 && d > 3){
			this.difficulty = 0;
		} else {
			this.difficulty = d;
		}
		this.waffle = w;
	}

	public Couple getCase(){

		if(this.difficulty == HUMAN){

			Scanner sc = new Scanner(System.in);

			return new Couple(sc.nextInt(), sc.nextInt());
		} else if(this.difficulty == EASY){

			Random rand = new Random();

			int imax = 0;
			int jmax = 0;

			while(jmax < waffle.getWidth() && this.waffle.getValue(0, jmax) == 0){jmax++;}
			while(imax < waffle.getHeight() && this.waffle.getValue(imax, 0) == 0){imax++;}

			int i = rand.nextInt(imax);
			int j = rand.nextInt(jmax);

			sleep(1);

			System.out.println("DEBUG IA EASY {"+i+", "+j+"}");
			return new Couple(i, j);
		} else if(this.difficulty == MEDIUM){

			Random rand = new Random();

			int imax = 0;
			int jmax = 0;
			int i;
			int j;

			while(jmax < waffle.getWidth() && this.waffle.getValue(0, jmax) == 0){jmax++;}
			while(imax < waffle.getHeight() && this.waffle.getValue(imax, 0) == 0){imax++;}

			if(imax == 1 && jmax > 1){
				i = 0;
				j = 1;
			} else if(jmax == 1 && imax > 1){
				i = 1;
				j = 0;
			} else {
				i = rand.nextInt(imax);
				j = rand.nextInt(jmax);
			}

			sleep(1);

			System.out.println("DEBUG IA MEDIUM {"+i+", "+j+"}");
			return new Couple(i, j);


		}
		else if (this.difficulty == HARD) {
			return this.iaHard();
		}
		else {
			System.out.println("NOT IMPLEMENTED YET");
			return new Couple(-1, -1);
		}


	}

	private int min(int i, int j) {
		if(i < j) {
			return i;
		}
		return j;
	}

	private int max(int i, int j) {
		if(i < j) {
			return i;
		}
		return j;
	} 

	private int countFreeCaseLine(int c) {
		int col = 0;

		while (col < this.waffle.getWidth() && this.waffle.getValue(c, col) == 0) {
			col++;
		}
		return col - c;
	}

	private int countFreeCaseCol(int c) {
		int row = c;

		while (row < this.waffle.getHeight() && this.waffle.getValue(row, c) == 0) {
			row++;
		}
		return row - c;
	}

	private Couple iaHard() {
		Random rand = new Random();
		int imin = this.waffle.getHeight();
		int jmin = this.waffle.getWidth();
		int i, j;
		int coord,
			nbCaseCol,
			nbCaseline;

		// Determine la case pivot
		for (i = 0; i < this.waffle.getHeight(); i++) {
			for (j = 0; j < this.waffle.getWidth(); j++) { // While
				if(this.waffle.getValue(i, j) != 0){
					if (i < imin) {
						imin = i;
					}
					if (j < jmin) {
						jmin = j;
					}
				}
			}
		}
		if (imin != 0 && jmin != 0) {
			 imin --;
			 jmin --;
		}

		// Case pivot (coord, coord)
		coord = min(max(imin, jmin), min((this.waffle.getHeight() - 1), (this.waffle.getWidth() - 1)));
		nbCaseCol = countFreeCaseCol(coord);
		nbCaseline = countFreeCaseLine(coord);

		// Si le pivot n'est pas le poison, l'IA equilibre
		if (coord > 0) {
			if (nbCaseline > nbCaseCol) {
				return new Couple(coord, coord + nbCaseCol); // On equilibre la situation
			}
			else if (nbCaseline < nbCaseCol) {
				return new Couple(coord + nbCaseline, coord); // On equilibre la situation
			}
			else {
				// Sinon on prend le pivot
				if (nbCaseline == 0) {
					return new Couple((coord-1), (coord-1));
				}
				else {
					return new Couple(coord, coord);
				}
			}
		}
		else {
			if (nbCaseline > nbCaseCol) {
				return new Couple(coord, coord + nbCaseCol); // On equilibre la situation
			}
			else if (nbCaseline < nbCaseCol) {
				return new Couple(coord + nbCaseline, coord); // On equilibre la situation
			}
			else { // nbCaseCol == nbCaseline
				if (rand.nextInt(2) == 0) { // Joue dans la colonne
					return new Couple(coord, coord + nbCaseline - 1);
				}
				else { // Joue dans la ligne
					return new Couple(coord + nbCaseCol - 1, coord);
				}
			}
		}
	}

	public void sleep(int n){
		try {
			Thread.sleep(n*1000);	
		} catch(Exception e){
			System.err.println("Erreur Sleep");
		}
	}

	public int getDifficulty() {
		return this.difficulty;
	}

	public String toString(){

		String retu = "";

		if(this.difficulty == HUMAN){
			retu += "Joueur "+this.number;
		} else {
			retu += "IA";
		}
		return retu;
	}



}

/*

X000
0333
0321
0321

*/