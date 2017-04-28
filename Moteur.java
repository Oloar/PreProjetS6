import java.util.Random;
import java.io.*;
import java.util.Scanner;

public class Moteur implements Interface_Moteur {

	Waffle waffle;
	int whoStart;
	Joueur arrayPlayer[];
	int currentMove;
	int currentPlayer;



	public Moteur(int height, int width, int player1, int player2){

		Random rand = new Random();
		this.whoStart = rand.nextInt(2);
		this.currentPlayer = this.whoStart;
		this.currentMove = 0;

		this.waffle = new Waffle(height, width);

		this.arrayPlayer = new Joueur[2];
		this.arrayPlayer[0] = new Joueur(1, player1, this.waffle);
		this.arrayPlayer[1] = new Joueur(2, player2, this.waffle);

	}


	public boolean eat(int i, int j){

		boolean eaten = false;

		if(this.waffle.isInWaffle(i, j)){
			if(this.waffle.isEatable(i, j)){

				// Incremente le compteur de coups
				currentMove++;
				for(int row = i; row < waffle.getHeight(); row++) {
					for(int col = j; col < waffle.getWidth(); col++) {
						if(waffle.isEatable(row, col)) {
							waffle.eatCase(row, col, currentMove);
						}
					}
				}
				currentPlayer = (currentPlayer+1) % 2;
				update_graphic();
				eaten = true;
			} 
		} else {
			System.out.println("OutOfGauffreException");
		}

		return eaten;
	}

	public void save(String filename){
		try{
			PrintWriter saveFile = new PrintWriter(filename, "UTF-8");
			saveFile.println("Joueur 1 : "+this.arrayPlayer[0]);
			saveFile.println("Joueur 2 : "+this.arrayPlayer[1]);
			saveFile.println("Joueur "+this.whoStart+" a commencé");
			saveFile.println("Hauteur : "+this.waffle.getHeight()+ " Largeur : "+this.waffle.getWidth());
			for(int i=0; i<this.waffle.getHeight(); i++){
				for(int j=0; j<this.waffle.getWidth(); j++){
					saveFile.print(this.waffle.getValue(i, j));
				}
				saveFile.println();
			}
			saveFile.close();
		} catch (IOException e) {
			System.err.println("Err: Echec d'ouverture du fichier.");
		}
	}

	public void undo(){

		if(currentMove > 0){

			// Parcours toutes les cases du tableau
			for(int row = 0; row < waffle.getHeight(); row++) {
				for(int col = 0; col < waffle.getWidth(); col++) {
					// Si la case correspond au coup précédent
					if(waffle.getValue(row, col) == currentMove - 1) {
						// Remet la case à zero
						waffle.revert(row, col);
					}
				}
			}
			// Décremente le compteur de coups
			currentMove --;
			// this.switchPlayers();
		} else {
			System.out.println("Rien à annuler");
		}
	}

	public void load(String filename){

	}

	public void print_text(){

		// System.out.println(this.arrayPlayer[0]);
		// System.out.println(this.arrayPlayer[1]);
		// System.out.println(this.arrayPlayer[this.whoStart]+" a commencé");
		System.out.println("\n\nC\'est au tour de "+this.arrayPlayer[this.currentPlayer]);
		System.out.println("Hauteur : "+this.waffle.getHeight()+ " Largeur : "+this.waffle.getWidth());


		for(int i=0; i<this.waffle.getHeight(); i++){
			for(int j=0; j<this.waffle.getWidth(); j++){
				System.out.print(this.waffle.getValue(i, j));
			}
			System.out.println();
		}

	}

	public void update_graphic(){
		// appel a IHM
	}

	/*public boolean isFinished(){
		return this.waffle.isAWin();
	}*/

	public void game(boolean affText, boolean affGraph){

		int i, j;

		while(!this.waffle.isAWin()){
			if(affText){
				this.print_text();
			}
			if(affGraph){
				// not implemented
			}
			Couple c;

			do {
				c = arrayPlayer[currentPlayer].getCase();

			} while(!this.eat(c.i(), c.j()));
		}

		System.out.println(arrayPlayer[currentPlayer]+" a gagné");

	}

}
