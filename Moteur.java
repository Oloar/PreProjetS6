import java.util.Random;
import java.io.*;

public class Moteur implements Interface_Moteur {

	Waffle waffle;
	int whoStart;
	private Joueur arrayPlayer[];
	int currentMove;
	int currentPlayer;

	GameInterface gi;




	public Moteur(int height, int width, int player1, int player2, GameInterface g){

		Random rand = new Random();
		this.whoStart = rand.nextInt(2);
		this.currentPlayer = this.whoStart;
		this.currentMove = 0;

		this.gi = g;

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
				this.update_graphic();
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
			saveFile.println(this.arrayPlayer[0].getDifficulty());
			saveFile.println(this.arrayPlayer[1].getDifficulty());
			saveFile.println(this.whoStart);
			saveFile.println(this.waffle.getHeight());
			saveFile.println(this.waffle.getWidth());
			for(int i=0; i<this.waffle.getHeight(); i++){
				for(int j=0; j<this.waffle.getWidth(); j++){
					saveFile.print(this.waffle.getValue(i, j)+":");
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
					if(waffle.getValue(row, col) == currentMove ) {
						// Remet la case à zero
						waffle.revert(row, col);
					}
				}
			}
			// Décremente le compteur de coups
			currentMove --;
			currentPlayer = (currentPlayer+1) % 2; // remet le coup au Joueur precedent
			update_graphic(); 
			save("testSave.txt");
			// this.switchPlayers();
		} else {
			System.out.println("Rien à annuler");
		}
	}

	public boolean load(String filename){
		try {
            FileReader filereader = new FileReader(filename);
            BufferedReader br = new BufferedReader(filereader);
            String tempVar;
			int tempHeight, tempWidth, player1, player2, whoStarted;
			player1 = Integer.parseInt(br.readLine());
			player2 = Integer.parseInt(br.readLine());
			whoStarted = Integer.parseInt(br.readLine());
			tempHeight = Integer.parseInt(br.readLine());
			tempWidth = Integer.parseInt(br.readLine());		
			if (player1 >=0 && player2 >= 0 && tempHeight >= 0 && whoStarted >= 0 && tempWidth >= 0) { 
				int [][] tempWaffle = new int[tempHeight][tempWidth];
				for (int i=0; i<tempHeight; i++) {
					tempVar = br.readLine();
					if (!tempVar.matches("([0-9]+:)+")) return false;
					
					String [] moveValues = tempVar.split("[:]");
					for (int j=0; j<tempWidth; j++) {
						tempWaffle[i][j] = Integer.parseInt(moveValues[j]);
					}
				}
				Waffle w = new Waffle(tempHeight, tempWidth, tempWaffle);
				this.waffle = w;
	                	this.arrayPlayer[0] = new Joueur(1, player1, this.waffle); ;
				this.arrayPlayer[1] = new Joueur(2, player2, this.waffle);
	                	this.whoStart = whoStarted;
				
				//print_text();
			}
			else {
				return false;
			}
        }
        catch (Exception e) {
        	System.out.println(e);
        }
		return true;
	}

	public void print_text(){

		// System.out.println(this.arrayPlayer[0]);
		// System.out.println(this.arrayPlayer[1]);
		// System.out.println(this.arrayPlayer[this.whoStart]+" a commencé");
		if (waffle.getValue(0,0) == 0)
			System.out.println("\n\nC\'est au tour de "+this.arrayPlayer[this.currentPlayer]);
		else 
			System.out.println("Game is over.");
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
		gi.updateGame(this.getGauffre(), arrayPlayer[currentPlayer], currentMove);
	}

	/*public boolean isFinished(){
		return this.waffle.isAWin();
	}*/

	public Joueur endGame(){
		this.save("testSave.txt");
		
		System.out.println(arrayPlayer[currentPlayer]+" a gagn� !");

		return arrayPlayer[currentPlayer];
	}

	public void game(boolean affText, boolean affGraph){

		//int i, j;

		this.update_graphic();

		while(!this.waffle.isAWin()){
			if(affText){
				this.print_text();
			}
			
		}

		this.save("testSave.txt");
		System.out.println(arrayPlayer[currentPlayer]+" a gagné");

	}

	public int [][] getGauffre(){
		int height = waffle.getHeight();
		int width = waffle.getWidth();

		int [][] retu = new int[height][width];

		for(int i=0; i<height; i++){
			for(int j=0; j<width; j++){
				retu[i][j] = waffle.getValue(i, j);
			}
		}
		return retu;
	}

	public boolean isIA(){
		return (arrayPlayer[currentPlayer].getDifficulty() > 0);
	}

	public int getHeightWaffle(){
		return waffle.getHeight();
	}

	public int getWidthWaffle(){
		return waffle.getWidth();
	}

	public String getPlayer(){
		return arrayPlayer[currentPlayer].toString();
	}

	public Joueur getPlayerNumber(){
		return arrayPlayer[currentPlayer];
	}

}
