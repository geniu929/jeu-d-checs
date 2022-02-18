package graphic;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import jeu.Damier;
import jeu.Joueur; 
public class graphic extends JFrame implements MouseListener, MouseMotionListener {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
  JLayeredPane layeredPane;
  JPanel chessBoard;
  JLabel chessPiece;
  int xAdjustment;
  int yAdjustment;
  public Damier plateau;
  Joueur joueurBlanc;
 
  public graphic(Damier plateau){
  Dimension boardSize = new Dimension(600, 600);
  this.plateau=plateau;
  //  Use a Layered Pane for this this application
  layeredPane = new JLayeredPane();
  getContentPane().add(layeredPane);
  layeredPane.setPreferredSize(boardSize);
  layeredPane.addMouseListener(this);
  layeredPane.addMouseMotionListener(this);

  //Add a chess board to the Layered Pane 
 
  chessBoard = new JPanel();
  layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
  chessBoard.setLayout( new GridLayout(8, 8) );
  chessBoard.setPreferredSize( boardSize );
  chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);
 
  for (int i = 0; i < 64; i++) {
  JPanel square = new JPanel( new BorderLayout() );
  chessBoard.add( square );
 
  int row = (i / 8) % 2;
  if (row == 0)
  square.setBackground( i % 2 == 0 ? Color.gray : Color.white );
  else
  square.setBackground( i % 2 == 0 ? Color.white : Color.gray);
  }
 
  //Add a few pieces to the board
  
  int h=0;
  for (int s=0; s<8;s++ ) {
		for (int a = 0; a < 8 ;a ++ ) {
			if ((plateau.damier[s][a].getPiece())== null) h++;
		else if(plateau.damier[s][a].getPiece() != null){
	JLabel piece = new JLabel( new ImageIcon("/C:/Users/Eugen/Desktop/java proj/image/"+(plateau.damier[s][a].getPiece().getNom().charAt(0))+ ""+ ((plateau.damier[s][a].getPiece().getCouleur().charAt(0)+"").toUpperCase())+".png") );
	JPanel panel = (JPanel)chessBoard.getComponent(h);
	panel.add(piece);
	h++;
			}
		} 
	
	}

  }
 
  public void mousePressed(MouseEvent e){
 /* chessPiece = null;
  Component c =  chessBoard.findComponentAt(e.getX(), e.getY());
  
  if (c instanceof JPanel) 
	((JComponent) c).setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));
  	for(int i=0;i<=7;i++) {
	  for(int j=0;j<=7;j++) {
	//	  if(Regles.(plateau,e.getY()/75,e.getX()/75,i,j)) {
			 System.out.println(plateau.getCaseDamie(i, j).getPiece().getNom());
			 ((JComponent) chessBoard.findComponentAt(i*75, j*75)).setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));
		  }
			 
	  }  }
  //System.out.println("y=>"+e.getY()/75+"/--/ x=>"+e.getX()/75);
  Point parentLocation = c.getParent().getLocation();
  xAdjustment = parentLocation.x - e.getX();
  yAdjustment = parentLocation.y - e.getY();
  chessPiece = (JLabel)c;
  chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
  chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
 // layeredPane.add(chessPiece, JLayeredPane.DRAG_LAYER);*/
  }
 
  //Move the chess piece around
  
  public void mouseDragged(MouseEvent me) {
/*  if (chessPiece == null) return;

  	 chessPiece.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
  */
  }
 
  //Drop the chess piece back onto the chess board
  /*if (Regles.coupPossible(plateau, (e.getX())/75, (e.getY())/75, (c.getX())/75, c.getY()/75))
	  {
	  Regles.pass(plateau, e.getX()/75, e.getY()/75, c.getX()/75, c.getY()/75);
 */
  
  public void mouseReleased(MouseEvent e) {
 /* if(chessPiece == null) return;
  int x,y;
  x=e.getX()/75;
  y=e.getY()/75;
  chessPiece.setVisible(false);
  Component c =  chessBoard.findComponentAt(e.getX(), e.getY());

  if (c instanceof JLabel && Regles.coupPossible(plateau,x, y, e.getX()/75,e.getY()/75) ){
  
	  Container parent = c.getParent();
	  parent.remove(0);
	  parent.add( chessPiece );
  }
  else {
  Container parent = (Container)c;
  parent.add( chessPiece );
  }
	  
  chessPiece.setVisible(true);
  */}
 
  public void mouseClicked(MouseEvent e) {
	 System.out.println("Clicked"+e.getY()/75); 

  
  }
  public void mouseMoved(MouseEvent e) {
 }
  public void mouseEntered(MouseEvent e){
  
  }
  public void mouseExited(MouseEvent e) {
  
  }
 
  public static void main(String[] args) {
	  Damier plateau = new Damier();
	  plateau.remplireDamier();
  JFrame frame = new graphic(plateau);
  frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE );
  frame.pack();
  frame.setResizable(true);
  frame.setLocationRelativeTo( null );
  frame.setVisible(true);
 }
}