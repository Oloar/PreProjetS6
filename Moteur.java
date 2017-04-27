import java.util.Random;
import java.io.*;

public class Moteur implements Interface_Moteur {

	Waffle waffle;
	int whoStart;
	int arrayPlayer[];
	int currentMove;



	public Moteur(int height, int width, int player1, int player2){

		Random rand = new Random();
		this.whoStart = rand.nextInt(2)+1;
		this.currentMove = 0;

		this.arrayPlayer = new int[2];
		this.arrayPlayer[0] = player1;
		this.arrayPlayer[1] = player2;

		this.waffle = new Waffle(height, width);
	}


	public void eat(int i, int j){

		if(this.waffle.isInWaffle(i, j)){
			// Incremente le compteur de coups
			currentMove++;
			for(int row = i; row < waffle.getHeight(); row++) {
				for(int col = j; col < waffle.getWidth(); col++) {
					if(waffle.isEatable(row, col)) {
						waffle.eatCase(row, col, currentMove);
					}
				}
			}
			update_graphic();
		} else {
			System.out.println("OutOfGauffreException");
		}
	}

	public void save(String file){

	}

	public void undo(){
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
	}

	public void load(String file){

	}

	public void print_text(){

		System.out.println("Joueur 1 : "+this.arrayPlayer[0]);
		System.out.println("Joueur 2 : "+this.arrayPlayer[1]);
		System.out.println("Joueur "+this.whoStart+" a commencé");
		System.out.println("Hauteur : "+this.waffle.getHeight()+ " Largeur : "+this.waffle.getWidth());
		for(int i=0; i<this.waffle.getHeight(); i++){
			for(int j=0; j<this.waffle.getWidth(); j++){
				System.out.print(this.waffle.getValue(i, j));
			}
			System.out.println();
		}

	}

	public void update_graphic(){
		for (int i = 0; i < waffle.getHeight(); i++) {
			for (int j=0; j < waffle.getWidth(); j++) {
				if (waffle.getValue(i, j) > 0) {
					// on rend la case invisible
				}
			}
			
		}
	}

}
