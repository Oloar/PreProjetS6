import java.io.*;

class Main_program {

	static public void main(String [] args){

		boolean affText = false, affGraph = false;
		int height, width;
		Moteur m;

		if(args.length < 1){
			System.out.println("Erreur syntaxe : java Main_program <Hauteur> <Largeur> <Mode>");
			System.out.println("Mode :");
			System.out.println("\t-g : version graphique");
			System.out.println("\t-t : version texte");
			System.out.println("\t-n : pas d\'affichage");
		} else {
			// height = Integer.parseInt(args[0]);
			// width = Integer.parseInt(args[1]);
			height = 2;
			width = 2;
			if(height < 0 || width < 0){
				System.out.println("Veuillez entrer des tailles de tableau positives");
			} else {

				if(containsOption("-t", args)){
					affText = true;
				}
				if(containsOption("-g", args)){
					affGraph = true;
				}

				m = new Moteur(height, width, 0, 3);

				System.out.println("Debut partie");

				m.game(affText, affGraph);

				System.out.println("Partie terminée");
			}
		}
	}



	static public boolean containsOption(String option, String [] args){
		for(int i=0; i<args.length; i++){
			if(args[i].equals(option)){
				return true;
			}
		}
		return false;
	}



}