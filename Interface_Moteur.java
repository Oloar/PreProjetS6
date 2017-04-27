import java.io.*;
public interface Interface_Moteur {

	// fonction qui va manger (affecter un numéro aux case en bas a droite de i, j)
	public void eat(int i, int j);

	// crée un fichier contenant toutes les informations de la partie en cours
	// Type de joueurs
	// Qui a commencé
	// Taille du tableau A= B= (rappel largeur = 2^A et hauteur = 3^B)
	// Puis le tableau de la gauffre
	public void save(String file) throws IOException;

	// Charge une partie en fonction du contenu du fichier file 
	public void load(String file);

	// annule le dernier coup effectué
	public void undo();

	// Fonction de debug qui affiche les infos de la partie sur la sortie standard
	public void print_text();

	// mise a jour graphic (appel au IHM)
	public void update_graphic();

}
