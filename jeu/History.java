package jeu;
import java.util.ArrayList;

public class History {

	Joueur joueurNoir;
	Joueur joueurBlanc;
	public ArrayList <String> history;

	public void setHistory(Joueur j,String cord ) {
		if (history.isEmpty()== true && j.getCouleur().equals("Blanc")) {
				history.add(cord);
		}else if (history.isEmpty()== false ){
			history.add(cord);
		}
	}
	
	public boolean debut() {
		if (history.isEmpty()!= true  ) return 	false;
		else {return 	true;}
	}
	
	
}