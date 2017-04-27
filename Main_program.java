import java.io.*;

class Main_program {

	static public void main(String [] args){

		Moteur m = new Moteur(2,2,0,1);

		m.print_text();
		m.eat(5,4);
		m.print_text();	
	}



}