package jeu;

public class Case {
	/*
	 * Piece contenu par la case
	 */
	private Piece piece;




	/*
	 * Constructeur parametre
	 * @param Prend en parametre la piece qu'il y aura sur la case
	 * @param Prend en parametre le boolean qui dit si la case est occupГ©
	 */
	public Case ( Piece  piece , boolean libre){
	this.piece= piece;

	} 
	
	public Case (){
	this.piece= null;
	}
	
	/**
	 * Methode set piece, met un objet Piece sur la case
	 * @param Piece placer
	 */
	
	public void setPiece (Piece piece){
	this.piece=piece;
	}
	
	/*
	 * Methode get piece, retourne la piece qui se trouve sur la case, ou null si la case est vide
	 * @return Piece sur la case
	 */
	
	public Piece getPiece(){
			return piece;	
	}
	
	
	

	}

