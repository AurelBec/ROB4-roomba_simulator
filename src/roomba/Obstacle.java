package roomba;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Classe abstraite Obstacle
 * (Implemente ObstacleRect et ObstacleRond)
 * : Cree un obstacle dans la piece
 * 
 * @see ObstacleRect
 * @see ObstacleRond
 * @see Piece
 * 
 * @author Aurelien BEC - Julien MARTIN
 * @version 1.3
 */

public abstract class Obstacle
{	
	protected int x;
	protected int y;	
	protected Color color;
	
	/**
	 * Getter X
	 * @return La coordonnee x de l'objet
	 */
	public int getX(){return this.x;}

	/**
	 * Getter Y
	 * @return La coordonnee y de l'objet
	 */
	public int getY(){return this.y;}

	/**
	 * Dessine les contours de l'obstacle dans la fenetre graphique
	 * @param g La fenetre graphique
	 */
	public abstract void line(Graphics2D g);

	/**
	 * Remplit l'obstacle dans la fenetre graphique
	 * @param g La fenetre graphique
	 */
	public abstract void fill(Graphics2D g);
	
	/**
	 * Renvoie vrai ou faux si l'obstacle est touche ou non
	 * @param x Coordonnee x du point a tester
	 * @param y Coordonne y du point a tester
	 * @return L'etat de la collision avec l'obstacle
	 */
	public abstract boolean isTouch( int x, int y);
	
}
