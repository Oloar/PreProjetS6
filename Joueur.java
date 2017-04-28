
import java.util.Scanner;
import java.util.Random;
import java.io.*;


public class Joueur {

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

			int i = rand.nextInt(waffle.getHeight());
			int j = rand.nextInt(waffle.getWidth());

			return new Couple(i, j);
		} else {
			System.out.println("NOT IMPLEMENT YET");
			return new Couple(-1, -1);
		}


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