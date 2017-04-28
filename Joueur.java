
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
		} else {
			System.out.println("NOT IMPLEMENTED YET");
			return new Couple(-1, -1);
		}


	}

	public void sleep(int n){
		try {
			Thread.sleep(n*1000);	
		} catch(Exception e){
			System.err.println("Erreur Sleep");
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