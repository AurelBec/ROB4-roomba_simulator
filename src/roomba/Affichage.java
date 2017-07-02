package roomba;
import java.awt.*;
import javax.swing.*;

/**
 * Classe Affichage : Gere l'affichage graphique du projet
 * 
 * @see Roomba
 * @see Piece
 * 
 * @author Aurelien BEC - Julien MARTIN
 * @version 1.3
 */

public class Affichage extends JPanel
{
	private static final long serialVersionUID = -8770845828133571044L; //On evite un warning
	private Piece piece;
	private Roomba roomba;

	/**
	 * Constructeur Affichage
	 */
	 public Affichage( int w, int h)
	 {
	   this.roomba = new Roomba(w/2, h/2);
	   
	   do
	   {
		   this.piece = new Piece(w, h);
	   } while( piece.obstacleIci(w/2, h/2) );

	   setBackground(Color.white);
	   setOpaque(true);
	 }
	 
	 /**
	  * Getter Piece
	  * @return La piece dans laquelle se deplace le roomba
	  */
	 public Piece getPiece(){return this.piece;}
	 
	 /**
	  * Getter Roomba
	  * @return Le roomba de la simulation
	  */
	 public Roomba getRoomba(){return this.roomba;}	 
	 
	 /**
	  * Propose un affichage visuel des elements de la piece
	  * Appelee a chaque pas de temps
	  * @param g La fenetre dans laquelle dessiner
	  */
	 public void paint(Graphics g) 
	 {
		 super.paint(g); 
		 Graphics2D g2 = (Graphics2D) g;
		 this.piece.draw(g2); 
		 this.roomba.draw(g2);
		 g2.dispose();
	 }
	 
	 /**
	  * Propose un affichage textuel du projet et des déplacements du roomba
	  * Appelee a chaque pas de temps
	  */
	 public void text()
	 {
		 this.roomba.getPosition().toString();
	 }
}
