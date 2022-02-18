package jeu;
import java.util.ArrayList;

public abstract class Piece {
	
	private String nom;
	private String couleur;
	protected int x,y;
	
	
	/** 
	 * Constructeur de la classe Piece
	 * @param Prend en parametre la couleur du piece
	 * @param Prend en parametre la nom du piece
	 */
	
	public Piece (String nom, String couleur, int x, int y){
	this.couleur= couleur;
	this.nom = nom;
	this.x=x;
	this.y=y;
	}
	
	
	/*
	 * Methode getCouleur, sert a returne la couleur de la piece
	 */
	public String getCouleur(){	
	return couleur;
	}
	

	/*
	 * Methode getNom, sert a returne le nom de la piece
	 */
	public String getNom(){
	return nom;
	}
	
	public int getX(){
	return this.x;
	}
	
	public int getY(){
	return this.y;
	}

	public void setX(int x) {
		this.x=x;
	}
	
	public void setY(int y) {
		this.y=y;
	}
	
	public ArrayList<Coordonnee> casesPossibles(Damier d){
		ArrayList<Coordonnee> p = new ArrayList<Coordonnee>();
    	for(int i=0; i<=7;i++){
    		for(int j=0; j<=7;j++){
    			if(Regles.coupPossible(d,x,y,i,j)){
    				Coordonnee cor= new Coordonnee(i,j);
    				p.add(cor);
    				//System.out.print(" bb " +getCaseDamie(i, j).getPiece()+ "\n");
    	    		
    			}
    		}
    	}
    	return p;
	
	}
	
	
	
	
	
	
}
