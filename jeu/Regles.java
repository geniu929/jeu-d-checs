package jeu;
import java.util.ArrayList;

public class Regles {
	
	static int cmp=0;
	
	
	/**
	 * Methode coupPion, envoye un boolean sur une mouvement
	 * @param Damier d
	 * @param int x
	 * @param int y
	 * @param int a
	 * @param int b
	 * return boolean
	 **/
	
	public static boolean coupPion(Damier d, int x, int y, int a, int b) {
		if(d.getCaseCouleur(x, y).equals("blanc")) {
			if(d.getCaseDamie(a,b).getPiece() == null && y==b && x+1==a){
				 return true;
				 }
			
			else if(d.getCaseDamie(a,b).getPiece() == null && y==b && x+2== a && x==1 && d.getCaseDamie(x+1,y).getPiece() == null){
				return true;}
			else if(d.getCaseDamie(a,b).getPiece() != null && d.getCaseCouleur(a , b).equals("noir")&&(x+1==a && (y-1==b||y+1==b))) {
				return true;}
			
		}
		
		else if(d.getCaseCouleur(x , y).equals("noir")) {
			if(d.getCaseDamie(a,b).getPiece() == null && y==b && x-1==a){
				return true;}
			else if(d.getCaseDamie(a,b).getPiece() == null && y==b && x-2==a && x==6 && d.getCaseDamie(x-1,y).getPiece() == null){
				return true;}
			else if(d.getCaseDamie(a,b).getPiece() != null && d.getCaseCouleur(a , b).equals("blanc")&&(x-1==a && (y-1==b||y+1==b))) {
				return true;}
			
		}
		
			return false;
	}

	/**
	 * Methode coupCavalie, envoye un boolean sur une mouvement
	 * @param Damier d
	 * @param int x
	 * @param int y
	 * @param int a
	 * @param int b
	 * return boolean
	 **/
	static boolean coupCavalier(Damier d, int x, int y, int a, int b) {

		if(d.getCaseCouleur(x , y).equals("blanc")) {
			if((d.getCaseDamie(a,b).getPiece() == null || d.getCaseCouleur(a , b).equals("noir"))&& (x+2==a && (y+1==b||y-1==b))||(x-2==a && (y+1==b||y-1==b))||((y+2==a && (x+1==b||x-1==b)))||(y-2==a && (x+1==b||x-1==b))){
				return true;}
			
		}
		
		else if(d.getCaseCouleur(x , y).equals("noir")) {
			if((d.getCaseDamie(a,b).getPiece() == null || d.getCaseCouleur(a , b).equals("blanc"))&& (x+2==a && (y+1==b||y-1==b))||(x-2==a && (y+1==b||y-1==b))||((y+2==a && (x+1==b||x-1==b)))||(y-2==a && (x+1==b||x-1==b))){
				return true;}
			
		}
	
		
		return false;
	}
	
	/**
	 * Methode coupCavalie, envoye un boolean sur une mouvement
	 * @param Damier d
	 * @param int x
	 * @param int y
	 * @param int a
	 * @param int b
	 * return boolean
	 **/
	public static boolean coupTour(Damier d, int x, int y, int a, int b) {
		

		if(d.getCaseCouleur(x , y).equals("blanc")) {
			if((d.getCaseDamie(a,b).getPiece() == null || d.getCaseCouleur(a, b).equals("noir")) && parcourH(d,x,y,a,b)==true){
				return true;}
			
		}
		
		else if(d.getCaseCouleur(x , y).equals("noir")) {
			if((d.getCaseDamie(a,b).getPiece() == null || d.getCaseCouleur(a, b).equals("blanc")) && parcourH(d,x,y,a,b)==true){
				return true;}
			
		}
	
	
		
		return false;
	}
	
	
	/**
	 * Methode coupFous, envoye un boolean sur une mouvement
	 * @param Damier d
	 * @param int x
	 * @param int y
	 * @param int a
	 * @param int b
	 * return boolean
	 **/
	static boolean coupFous(Damier d, int x, int y, int a, int b) {
		
		if(d.getCaseCouleur(x , y).equals("blanc")) {
			if((d.getCaseDamie(a,b).getPiece() == null || d.getCaseCouleur(a, b).equals("noir")) && parcourX(d,x,y,a,b)==true){
				return true;}
			
		}
		
		else if(d.getCaseCouleur(x , y).equals("noir")) {
			if((d.getCaseDamie(a,b).getPiece() == null || d.getCaseCouleur(a, b).equals("blanc")) && parcourX(d,x,y,a,b)==true){
				return true;}
			
		}
	
		
		return false;
		
	
	}
	
	
static boolean coupDame(Damier d, int x, int y, int a, int b) {
		
		if(d.getCaseCouleur(x , y).equals("blanc")&& coupFous(d,x,y,a,b) || parcourH(d,x,y,a,b) ) {
			System.out.println(coupFous(d,x,y,a,b) );
			System.out.println(coupTour(d,x,y,a,b) );
			
			 return true;
		}
		else if(d.getCaseCouleur(x , y).equals("blanc")&& coupFous(d,x,y,a,b) || parcourH(d,x,y,a,b) ) {
			System.out.println(coupFous(d,x,y,a,b) );
			System.out.println(coupTour(d,x,y,a,b) );
			
			 return true;
		}
		
	return false;
	
	}
	
	
	public static boolean coupRoi(Damier d, int x, int y, int a, int b) {
		
		if(d.getCaseCouleur(x , y).equals("blanc")) {
			if((d.getCaseDamie(a,b).getPiece() == null || d.getCaseCouleur(a, b).equals("noir"))&& (a<=x+1 && a>=x-1&&b<=y+1 && b>=y-1&&(x!=a||y!=b))) {
				
				d.changerCase(x, y, a, b);
				if(estEchec(d,a,b)) {
					d.changerCase(a, b, x, y);
					return false;
				}
				else {
					d.changerCase(a, b, x, y);
					return true;
				}
				
			}
				
				
				
		
		}
		
		else if(d.getCaseCouleur(x , y).equals("noir")) {
			System.out.println("aaaaaaaaa");
			if((d.getCaseDamie(a,b).getPiece() == null || d.getCaseCouleur(a, b).equals("blanc"))&& (a<=x+1 && a>=x-1&&b<=y+1 && b>=y-1&&(x!=a||y!=b))) {
				d.changerCase(x, y, a, b);
				if(estEchec(d,a,b)) {
					d.changerCase(a, b, x, y);
					return false;
				}
				else {
					d.changerCase(a, b, x, y);
					return true;
				}
			}
		
		}
		return false;
	}


	
	static boolean parcourX(Damier d, int x, int y, int a, int b) {
		// parcour \->
		cmp=1;
		if(x+1==a&&y+1==b)
			return true;
		else if(y<b && x<a && a-x==b-y) {
			for(int i=x+1, j=y+1; i<a && j<b;i++,j++) {
				if(d.getCaseDamie(i,j).getPiece() != null) {
					return false;
					}
				else
					cmp=0;
					continue;
			}
		}
		
		// parcour \<-
		if(x-1==a&&y-1==b)
			return true;
		else if(y>b && x>a && x-a== y-b) {
				for(int i=x-1, j=y-1; (i>=a && j>=b);i--,j--) {
						if(d.getCaseDamie(i,j).getPiece() != null ) {
							return false;
					}
						else
					cmp=0;
					continue;
				}
		}
		
		//parcour /->
		if(x-1==a&&y+1==b)
			return true;
		else if(y<b && x>a && x-a== b-y) {
			for(int i=x-1, j=y+1; i>a && j<b;i--,j++) {
				if(d.getCaseDamie(i,j).getPiece() != null ) {
					return false;
					}
				else
					cmp=0;
					continue;
			}
		}
		//parcour /<-
		if(x+1==a&&y-1==b)
			return true;
		else if(y>b && x<a && a-x== y-b) {
			for(int i=x+1, j=y-1; i<a && j>b;i++,j--) {
				if(d.getCaseDamie(i,j).getPiece() != null ) {
					return false;
					}
				else
					cmp=0;
					continue;
			}
		}
		
		
		
		if(cmp==1) {
			return false;}
		else 
			return true;
	}
	
	
	public static boolean parcourH(Damier d, int x, int y, int a, int b) {
		//parcour |->
		cmp=1;
		if(x+1==a&&b==y) {
			return true;}
		else if(y==b && x<a) {
			for(int i=x+1; i<a;i++) {
				
				if(d.getCaseDamie(i,y).getPiece() != null) {
					return false;
					}
				else
					cmp=0;
					continue;
			}
		
		}
		
		//parcour |<-
		if(x-1==a&&b==y) {
			return true;}
		else if(y==b && x>a) {
			for(int i=x-1; i>a;i--) {
				if(d.getCaseDamie(i,b).getPiece() != null) {
					return false;
					}
				else
					cmp=0;
					continue;
			}
		
		}
		//parcour _->
		if(y+1==a&&x==a) {
			return true;}
		else if(x==a && y<b) {
			for(int i=y+1; i<b;i++) {
				if(d.getCaseDamie(a,i).getPiece() != null) {
					return false;
					}
				else
					cmp=0;
					continue;
			}
		
		}
		
		//parcour _<-
		if(y-1==a && x==a) {
			return true;}
		else if(x==a && y>b) {

			for(int i=y-1; i>b;i--) {
				if(d.getCaseDamie(a,i).getPiece() != null) {
					return false;
					}
				else
					cmp=0;
					continue;
			}
		
		}
		
		//System.out.println(cmp);
		if(cmp==1) {
			return false;}
		else 
			return true;
	}

	
	public static void pass(Damier d, int a, int b, int x, int y){
		String e = d.getCaseDamie(a,b).getPiece().getNom();
		if (x==a && b==y) {
			System.out.print("erreur les memes coordonnees ");
		}
		switch (e){
		
		case "Pion": 			
			if (Regles.coupPion(d ,a, b, x, y) == false) {
				System.out.print("erreur du pion merci de reessayer ");
				}
			else{
				d.changerCase(a,b,x,y);
			};
			break;
		
		case "Dame": 			
			if (Regles.coupDame(d ,a, b, x, y) == false) {
				System.out.print("erreur du pion merci de reessayer ");
				}
			else{
				d.changerCase(a,b,x,y);
			};
			break;
		
		case "Tour": 			
			if (Regles.coupTour(d ,a, b, x, y) == false) {
				System.out.print("erreur du pion merci de reessayer ");
				}
			else{
				d.changerCase(a,b,x,y);
			};
			break;
		case "Roi": 			
			if (Regles.coupRoi(d ,a, b, x, y) == false) {
				System.out.print("erreur du pion merci de reessayer ");
				}
			else{
				d.changerCase(a,b,x,y);
			};
			break;
		
		case "Cavalier": 			
			if (Regles.coupCavalier(d ,a, b, x, y) == false) {
				System.out.print("erreur du pion merci de reessayer ");
				}
			else{
				d.changerCase(a,b,x,y);
			};
			break;
		}
		
	}
	
	
	
	
	
	
	
	
	public static boolean coupPossible(Damier d,int a, int b, int x, int y){
		String e = d.getCaseDamie(a,b).getPiece().getNom();
		
		if (x==a && b==y) {
			return false;
		}
		switch (e){
		
		case "Pion": 			
			if (coupPion(d ,a, b, x, y) == false) {
				return false;
				}
			else{
				System.out.print(" pion " + "\n");
				return true;
			}
			
			case "Dame": 			
			if (coupDame(d ,a, b, x, y) == false) {
				return false;
				}
			else{
				System.out.print(" dame " + "\n");
				return true;
			}
			case "Tour": 			
			if (coupTour(d ,a, b, x, y) == false) {
				return false;
				}
			else{
				System.out.print(" tour" + "\n");
				return true;
			}
			case "Roi": 			
			if (coupRoi(d ,a, b, x, y) == false) {
				return false;
				}
			else{
				System.out.print(" roi " + "\n");
				return true;
			}
		
		case "Cavalier": 			
			if (coupCavalier(d ,a, b, x, y) == false) {
				return false;
				}
			else{
				System.out.print(" cavalier " + "\n");
				
				return true;
			}
		}
		return false;
	
	}

	
	public static boolean estEchec(Damier d, int a, int b){
		ArrayList<Piece> atester = d.getPieces();
    	for(Piece pi : atester){

    		if ( pi!=null && pi.getCouleur()!= d.getCaseCouleur(a, b)) {
    			if(coupPossible(d,pi.getX(), pi.getY(), a, b) == true)
    			{
    				System.out.print("  " +pi.getX() + pi.getY()+ pi.getCouleur() +pi.getNom()+ "\n");
    				return true;
    
    			
	    		}
    		}	
    	

    	}
		return false;

    }
	
	/*
	public static boolean echecMat(Damier d, int a, int b) {
		
		if(a==0&&b>0&&b<7) {
			if(estEchec(d,a+1,b)==true&&
					estEchec(d,a+1,b+1)==true&&estEchec(d,a+1,b-1)==true&&
					estEchec(d,a,b+1)==true&&estEchec(d,a,b-1)==true) {
				return true;
			}
			
			else return false;
				
			
		}
		else if(a==7&&b>0&&b<7) {
			
			if(estEchec(d,a-1,b)==true&&
					estEchec(d,a-1,b+1)==true&&estEchec(d,a-1,b-1)==true&&
					estEchec(d,a,b+1)==true&&estEchec(d,a,b-1)==true) {
				return true;
			}
			else return false;
			
			
		}
		else if(b==7&&a>0&&a<7) {
			if(estEchec(d,a+1,b)==true&&estEchec(d,a-1,b)==true&&
					estEchec(d,a+1,b-1)==true&&
					estEchec(d,a-1,b-1)==true&&
					estEchec(d,a,b-1)==true) {
				return true;
			}
			else return false;
			
		}
		
		else if(b==0&&a>0&&a<7) {
			if(estEchec(d,a+1,b)==true&&estEchec(d,a-1,b)==true&&
					estEchec(d,a+1,b+1)==true&&
					estEchec(d,a-1,b+1)==true&&
					estEchec(d,a,b+1)==true) {
				return true;
			}
			else return false;
			
			
			
		}
		
		else if(b==0&&a==0) {
				if(estEchec(d,a+1,b)==true&&
						estEchec(d,a+1,b+1)==true&&
						estEchec(d,a,b+1)==true) {
					return true;
				}
				else return false;
				
			}
		else if(b==0&&a==7) {
			
			if(estEchec(d,a-1,b)==true&&
					estEchec(d,a-1,b+1)==true&&
					estEchec(d,a,b+1)==true) {
				return true;
			}
			else return false;
		}
		else if(b==7&&a==7) {
			
			if(estEchec(d,a-1,b)==true&&
					estEchec(d,a-1,b-1)==true&&
					estEchec(d,a,b-1)==true) {
				return true;
			}
			else return false;
		
		}
		else if(b==7&&a==0) {
			
			if(estEchec(d,a+1,b)==true&&
					estEchec(d,a+1,b-1)==true&&
					estEchec(d,a,b-1)==true) {
				return true;
			}
			else return false;
		}
		
			
		
		else if(a>0&&a<7&&b<7&&b>0) { 
			if(estEchec(d,a+1,b)==true&&estEchec(d,a-1,b)==true&&
				estEchec(d,a+1,b+1)==true&&estEchec(d,a+1,b-1)==true&&
				estEchec(d,a-1,b+1)==true&&estEchec(d,a-1,b-1)==true&&
				estEchec(d,a,b+1)==true&&estEchec(d,a,b-1)==true) {
				System.out.print("intra");
				return true;
			}
			else return false;
		}
		
		
		return false;	

	}
	
	*/
	/**
	 * Recherche les prerequis pour un coups
	 * @param p piece sur laquelle il faut rechercher les prerequis
	 * @param x deplacement de la piece en x
	 * @param y deplacement de la piece en y
	 * @return un code de la valeur de prerequis
	 */
	public int recherchePrerequis(Damier d,Piece p, int x, int y){
		int valeur = 1;
		if(p.getClass().equals(Pion.class)){
			ArrayList<Pion> pions = d.getPions(p.getCouleur());
			for(Pion a : pions){
				if(a != p){
					if(coupPossible(d,a.getX(),a.getY(),x, y)){
						if(a.getX() == p.getX()){
							valeur += 10;
						}
						if(a.getY() == p.getY()){
							valeur  += 100;
						}else{
							if(valeur %100 < 90) valeur += 10;
						}
					}
				}
			}
		}else if(p.getClass().equals(Tour.class)){
			ArrayList<Tour> tours = d.getTours(p.getCouleur());
			for(Tour a : tours){
				if(a != p){
					if(coupPossible(d,a.getX(),a.getY(),x, y)){
						if(a.getX() == p.getX()){
							valeur += 10;
						}
						if(a.getY() == p.getY()){
							valeur  += 100;
						}else{
							if(valeur %100 < 90) valeur += 10;
						}
					}
				}
			}
		}else if(p.getClass().equals(Cavalier.class)){
			ArrayList<Cavalier> cavaliers = d.getCavaliers(p.getCouleur());
			for(Cavalier a : cavaliers){
				if(a != p){
					if(coupPossible(d,a.getX(),a.getY(),x, y)){
						if(a.getX() == p.getX()){
							valeur += 10;
						}
						if(a.getY() == p.getY()){
							valeur  += 100;
						}else{
							if(valeur%100 < 90) valeur += 10;
						}
					}
				}
			}
		}else if(p.getClass().equals(Fous.class)){
			ArrayList<Fous> fous = d.getFous(p.getCouleur());
			for(Fous a : fous){
				if(a != p){
					if(coupPossible(d,a.getX(),a.getY(),x, y)){
						if(a.getX() == p.getX()){
							valeur += 10;
						}
						if(a.getY() == p.getY()){
							valeur  += 100;
						}else{
							if(valeur %100 < 90) valeur += 10;
						}
					}
				}
			}
		}else if(p.getClass().equals(Dame.class)){
			ArrayList<Dame> reines = d.getReines(p.getCouleur());
			for(Dame a : reines){
				if(a != p){
					if(coupPossible(d,a.getX(),a.getY(),x, y)){
						if(a.getX() == p.getX()){
							valeur += 10;
						}
						if(a.getY() == p.getY()){
							valeur  += 100;
						}else{
							if(valeur %100 < 90) valeur += 10;
						}
					}
				}
			}
		}
		
		return valeur;
	}
	
	/*
	public boolean echecEtMat(Damier d, int a, int b){
		//Recupere toutes les pieces de la couleur du roi
    	ArrayList<Piece> pieces = (d.getCaseCouleur(a, b).equals("blanc"))? d.getPiecesBlanches() : d.getPiecesNoires();
    	   
    
    	//On prend chaques pieces une a une
    	for(int i = 0; i < pieces.size(); i++){
    		//recupere toutes les cases ou peut aller la piece
    		ArrayList<Coordonnee> casesPossibles = pieces.get(i).casesPossibles(d);
    		
    		//on prend chaque coordonnee une a une
    		for(int j = 0; j < casesPossibles.size(); j++){
    			int valeurPrerequis = recherchePrerequis(d,pieces.get(i), casesPossibles.get(j).x, casesPossibles.get(j).y);
    			
    			//deplace la piece en la coordonnee
    			if(d.getCase(pieces.get(i).getX(), pieces.get(i).getY()).deplacer(casesPossibles.get(j).x, casesPossibles.get(j).y)){
    				CoupPGN coup = d.getJeu().getHistorique().getDernierCoup();
    				coup.setPrerequis(valeurPrerequis);
    				//s'il n'y a plus d'echec au roi, alors il y a pas echec et mat
    				if(!this.estEchec()){
    					coup.isEchec = true;
    					//on annule le coup que l'on vient de jouer
    					d.annulerDernierCoup(false);
    					return false;
    				}
    				//on annule le coup que l'on vient de jouer
    				d.annulerDernierCoup(false);
    			}
    		}
    	}
	}
	
	
	*/

	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

