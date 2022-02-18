package jeu;
import java.util.ArrayList;


public class Damier {

	public Case  damier[][];		
	
	public Damier(){
	damier = new Case[8][8];
	for (int i=0; i<8; i++){
		for (int j=0; j<8; j++)
			damier[i][j]=new Case();
		}
	}

	
	

	public void changerCase(int x, int y, int x1, int y1){
		try{
		damier[x1][y1].setPiece(damier[x][y].getPiece());
		getCaseDamie(x1,y1).getPiece().setX(x1);
		getCaseDamie(x1,y1).getPiece().setY(y1);
		damier[x][y].setPiece(null);
		}
		catch(Exception e) {
			System.out.print(e.getMessage());
		}
		}

	public String getCaseCouleur(int x, int y) {
		if(damier[x][y].getPiece()==null)
			return "kaka";
		else
		return damier[x][y].getPiece().getCouleur();
		
	}

	public Case[][] getDamier(){
		return damier;
	
	}
	
	public Case getCaseDamie(int x, int y) {
		
		return damier[x][y];
	}
	
	public void setCase (int x, int y, Piece piece){
		Case pie = new Case();
		pie.setPiece(piece);
		damier[x][y] = 	pie;
	}
	
	
	public void remplireDamier(){
		
		int colonne = 7;
		
		for (String couleur = "noir" ; !couleur.equals("blanc"); couleur = "blanc", colonne = 0){
			//J'initialise tout mes pieces de la premieres rangee (tour, cavalier etc...)
			damier[colonne][0].setPiece(new Tour(couleur,colonne,0));
			damier[colonne][1].setPiece(new Cavalier(couleur,colonne,1));
			damier[colonne][2].setPiece(new Fous(couleur,colonne,2));
			damier[colonne][3].setPiece(new Dame(couleur,colonne,3));
			damier[colonne][4].setPiece(new Roi(couleur,colonne,4));
			damier[colonne][5].setPiece(new Fous(couleur,colonne,5));
			damier[colonne][6].setPiece(new Cavalier(couleur,colonne,6));
			damier[colonne][7].setPiece(new Tour(couleur,colonne,7));
			//Je change de ligne, dependament de la couleur que je suis en train de traeter.
			colonne += couleur.equals("noir") ? -1 : 1;
			//J'initialise tout mes pions.
			for (int ctr = 0; ctr <= 7; ctr++)
				damier[colonne][ctr].setPiece(new Pion(couleur,colonne,ctr));
		}
			
			colonne=0;
			
			for (String couleur = "blanc" ; !couleur.equals("noire"); couleur = "noire", colonne = 7){
				//Init toutes les pieces de la premiere rangeee (tour, cavalier etc...)
				damier[colonne][0].setPiece(new Tour(couleur,colonne,0));
				damier[colonne][1].setPiece(new Cavalier(couleur,colonne,1));
				damier[colonne][2].setPiece(new Fous(couleur,colonne,2));
				damier[colonne][4].setPiece(new Dame(couleur,colonne,4));
				damier[colonne][3].setPiece(new Roi(couleur,colonne,3));
				damier[colonne][5].setPiece(new Fous(couleur,colonne,5));
				damier[colonne][6].setPiece(new Cavalier(couleur,colonne,6));
				damier[colonne][7].setPiece(new Tour(couleur,colonne,7));
				
				//Je change de ligne, dependament de la couleur que je suis en train de traiter.
				colonne += couleur.equals("blanc") ? +1 : 1;
				//J'initialise tout mes pions.
				for (int ctr = 0; ctr <= 7; ctr++)
					damier[colonne][ctr].setPiece(new Pion(couleur,colonne,ctr));
		}
	
	}
	
	public void afficheDamier() {
		int i,j,h;
		
		for (h=0;h<8;h++) {
			System.out.print("    " + (h) +"   ");
		
		}	
		System.out.print("\n");
		System.out.print("\n");
		
		for (i=0;i<8;i++) {
			System.out.print("" + (i) +"   ");
			for(j=0;j<8;j++) {
				if(damier[i][j].getPiece()!= null) {
					
						System.out.print(""+ damier[i][j].getPiece().getNom().charAt(0) 
								+ (damier[i][j].getPiece().getCouleur().charAt(0)+"").toUpperCase() +"      ");		
				}
				else { 
				System.out.print(""+ damier[i][j].getPiece() +"    ");		
				}
			}	
			System.out.print("" + (i) +"");
			System.out.print("\n");
			System.out.print("\n");
		}
	
	
		
		for (h=0;h<8;h++) {
			System.out.print("    " + (h) +"   ");
			}
		
	}

	
	public ArrayList<Piece> getPieces(){
    	ArrayList<Piece> p = new ArrayList<Piece>();
    	for(int i=0; i<=7;i++){
    		for(int j=0; j<=7;j++){
    			if(getCaseDamie(i, j) != null){
    				p.add(getCaseDamie(i, j).getPiece());
    				//System.out.print(" bb " +getCaseDamie(i, j).getPiece()+ "\n");
    	    		
    			}
    		}
    	}
    	return p;
    }
	
	public ArrayList<Piece> getPiecesBlanches(){
		ArrayList<Piece> p = new ArrayList<Piece>();
    	for(int i=0; i<=7;i++){
    		for(int j=0; j<=7;j++){
    			if(getCaseDamie(i, j) != null && getCaseCouleur(i,j).equals("blanc")){
    				p.add(getCaseDamie(i, j).getPiece());
    				//System.out.print(" bb " +getCaseDamie(i, j).getPiece()+ "\n");
    	    		
    			}
    		}
    	}
    	return p;
	}
	
	
	public ArrayList<Piece> getPiecesNoires(){
		ArrayList<Piece> p = new ArrayList<Piece>();
    	for(int i=0; i<=7;i++){
    		for(int j=0; j<=7;j++){
    			if(getCaseDamie(i, j) != null && getCaseCouleur(i,j).equals("noir")){
    				p.add(getCaseDamie(i, j).getPiece());
    				//System.out.print(" bb " +getCaseDamie(i, j).getPiece()+ "\n");
    	    		
    			}
    		}
    	}
    	return p;
	}
	
	
	public ArrayList<Pion> getPions(String d) {
		ArrayList<Pion> p = new ArrayList<Pion>();
    	for(int i=0; i<=7;i++){
    		for(int j=0; j<=7;j++){
    			if(getCaseDamie(i, j).getPiece().getNom().equals("Pion") && getCaseCouleur(i,j).equals(d)){
    				Pion pi= new Pion(d,i,j);
    				p.add(pi);
    				//System.out.print(" bb " +getCaseDamie(i, j).getPiece()+ "\n");
    	    		
    			}
    		}
    	}
    	return p;
		
	}
	
	
	public ArrayList<Tour> getTours(String d) {
		ArrayList<Tour> p = new ArrayList<Tour>();
    	for(int i=0; i<=7;i++){
    		for(int j=0; j<=7;j++){
    			if(getCaseDamie(i, j).getPiece().getNom().equals("Tour") && getCaseCouleur(i,j).equals(d)){
    				Tour pi= new Tour(d,i,j);
    				p.add(pi);
    				//System.out.print(" bb " +getCaseDamie(i, j).getPiece()+ "\n");
    	    		
    			}
    		}
    	}
    	return p;
		
	}

	public ArrayList<Cavalier> getCavaliers(String d) {
		ArrayList<Cavalier> p = new ArrayList<Cavalier>();
    	for(int i=0; i<=7;i++){
    		for(int j=0; j<=7;j++){
    			if(getCaseDamie(i, j).getPiece().getNom().equals("Cavalier") && getCaseCouleur(i,j).equals(d)){
    				Cavalier pi= new Cavalier(d,i,j);
    				p.add(pi);
    				//System.out.print(" bb " +getCaseDamie(i, j).getPiece()+ "\n");
    	    		
    			}
    		}
    	}
    	return p;
		
	}
	
	public ArrayList<Fous> getFous(String d) {
		ArrayList<Fous> p = new ArrayList<Fous>();
    	for(int i=0; i<=7;i++){
    		for(int j=0; j<=7;j++){
    			if(getCaseDamie(i, j).getPiece().getNom().equals("Fous") && getCaseCouleur(i,j).equals(d)){
    				Fous pi= new Fous(d,i,j);
    				p.add(pi);
    				//System.out.print(" bb " +getCaseDamie(i, j).getPiece()+ "\n");
    	    		
    			}
    		}
    	}
    	return p;
		
	}
	
	
	public ArrayList<Dame> getReines(String d) {
		ArrayList<Dame> p = new ArrayList<Dame>();
    	for(int i=0; i<=7;i++){
    		for(int j=0; j<=7;j++){
    			if(getCaseDamie(i, j).getPiece().getNom().equals("Dame") && getCaseCouleur(i,j).equals(d)){
    				Dame pi= new Dame(d,i,j);
    				p.add(pi);
    				//System.out.print(" bb " +getCaseDamie(i, j).getPiece()+ "\n");
    	    		
    			}
    		}
    	}
    	return p;
		
	}
}


