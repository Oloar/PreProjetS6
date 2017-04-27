import java.util.Random;
import java.io.*;

public class Moteur implements Interface_Moteur {

	int [][]arrayWaffle;
	int whoStart;
	int arrayPlayer[];
	int height;
	int width;

	public Moteur(int height, int width, int player1, int player2){

		Random rand = new Random();
		this.whoStart = rand.nextInt(2)+1;

		this.arrayPlayer = new int[2];
		this.arrayPlayer[0] = player1;
		this.arrayPlayer[1] = player2;

		this.width = (int)Math.pow(2, width);
		this.height = (int)Math.pow(3, height);

		this.arrayWaffle = new int[this.height][this.width];

		// initialise le tableau à 0 de partout
		for(int i=0; i<this.height; i++){
			for(int j=0; j<this.width; j++){
				this.arrayWaffle[i][j] = 0;
			}
		}
	}


	public void eat(int i, int j){

	}

	public void save(String file){

	}

	public void undo(){

	}

	public void load(String file){

	}

	public void print_text(){

		System.out.println("Joueur 1 : "+this.arrayPlayer[0]);
		System.out.println("Joueur 2 : "+this.arrayPlayer[1]);
		System.out.println("Joueur "+this.whoStart+" a commencé");
		System.out.println("Hauteur : "+this.height+ " Largeur : "+this.width);
		for(int i=0; i<height; i++){
			for(int j=0; j<width; j++){
				System.out.print(this.arrayWaffle[i][j]);
			}
			System.out.println();
		}

	}

	public void update_graphic(){

	}

}