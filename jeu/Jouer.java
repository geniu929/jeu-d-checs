package jeu;



public class Jouer {

	static int a= 7-1;
	static int c= 5-1 ;
	static int x= 8-1;
	static int y= 5-1 ;
	
	public static void main(String[] args) {
		Damier plateau = new Damier();
		plateau.remplireDamier();
		/*Afficha*/
		
		//System.out.println(plateau.getCaseDamie(1,4).getPiece());
	
		
		//plateau.changerCase(a, c, x,y );
		
		plateau.changerCase(7, 4, 5, 3 );
		//plateau.changerCase(1, 3, 2, 2 );
		plateau.changerCase(1, 0, 3, 1 );
		//plateau.changerCase(0, 0, 1, 0 );
		plateau.afficheDamier();
		
		boolean b = Regles.coupPossible(plateau,0,0,5,0);
		plateau.changerCase(0, 0, 5, 0 );
		boolean h = Regles.estEchec(plateau,5,3);
		boolean bc = Regles.coupPossible(plateau,5,3,5,2);
		//boolean c = Regles.echecMat(plateau,3,3);
		//plateau.changerCase(a, c, x,y );
			
				System.out.print("\n" );
				System.out.print("\n" );
			//	plateau.afficheDamier();
				System.out.print(" bool " +b+" "+bc+" "+ h+"\n");

		System.out.print("\n" );
		System.out.print("\n" );
	//	plateau.afficheDamier();
		//System.out.print(" bool " +c+"\n");
		System.out.print("\n" );
		System.out.print("\n" );

		
}


}