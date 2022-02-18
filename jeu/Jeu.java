package jeu;

import graphic.graphic;
import java.util.ArrayList;

public class Jeu {

	protected Damier damier;

	protected Joueur joueurNoir;
	
	protected Joueur joueurBlanc;
	
	protected Joueur joueurCourant;
	
	protected ArrayList<Piece> prises;
	
	protected Piece pieceSelectionee;
	
	protected ArrayList<int[][]> historique;
	
	protected graphic fenetre;
	
	public Jeu() {
		damier = null;
		joueurNoir = null;
		joueurBlanc = null;
		joueurCourant = null;
		prises = null;
		pieceSelectionee = null;
		historique = null;
		fenetre = null;
	}
	
	public Jeu(graphic fenetre ,Joueur joueurBlanc ,Joueur joueurNoir ) {
		
		super();
		damier = new Damier();		
		joueurBlanc = new Joueur("Blanc");
		joueurNoir = new Joueur("Noir");
		joueurCourant = joueurBlanc;
		this.prises = new ArrayList<Piece>();
		this.fenetre = fenetre;
		damier.remplireDamier();	
	}/*
	public int tourJoueur(Joueur joueurBlanc,Joueur joueurNoir, ArrayList[] historique){
	//	if (historique.== true) {return 1;}
		else if (historique.([]))
	
}*/}
