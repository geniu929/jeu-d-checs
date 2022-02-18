	package jeu;
		
	public class Joueur {

		public String couleur;
		public boolean estHumain = true;
		
	public Joueur(){}
	
	public Joueur(String c){
	this.couleur = c;	
	}

	public String getCouleur() {
		return couleur;
	}
	
	public boolean testHuma(){
		return estHumain;
	}
	
	
	public void setcolor(String x){
		this.couleur= x;
	}
	
	public void setHumain(boolean x){
		this.estHumain= x;
	}
	
	}
