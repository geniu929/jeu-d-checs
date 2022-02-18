package jeu;

public class Test {

	static int a= 7-1;
	static int c= 5-1 ;
	static int x= 8-1;
	static int y= 5-1 ;
	
	public static void main(String[] args) {
		Damier plateau = new Damier();
		plateau.remplireDamier();
		plateau.afficheDamier();
		boolean b = Regles.coupPossible(plateau,1,4,0,1) ;
		
		
		System.out.print(b );
		System.out.print("\n" );

		
}


}