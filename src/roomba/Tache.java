package roomba;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Classe abstraite Tache
 * (Implemente TacheRonde)
 * : Cree une tache dans la piece
 * 
 * @see TacheRonde
 * @see Piece
 * 
 * @author Aurelien BEC - Julien MARTIN
 * @version 1.2
 */

public abstract class Tache
{
	protected int x;
	protected int y;
	protected Color color;
	protected boolean isClean;
	
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
	 * @return La tache est nettoyee ou non
	 */
	public boolean isClean(){return this.isClean;}

	/**
	 * Dessine les contours de la tache dans la fenetre graphique
	 * @param g La fenetre graphique
	 */
	public abstract void line(Graphics2D g);
	
	/**
	 * Remplit la tache dans la fenetre graphique
	 * @param g La fenetre graphique
	 */
	public abstract void fill(Graphics2D g);

	/**
	 * Nettoie la tache petit a petit
	 */
	public abstract void clean();
	
	/**
	 * Renvoie vrai ou faux s'il y a collision entre un cercle de rayon range et de centre x,y et la tache
	 * @param x La coordonnee x du centre
	 * @param y La coordonnee y du centre
	 * @param r le rayon dans lequel chercher une tache
	 * @return La presence ou non de tache dans le cercle x,y,range
	 */
	abstract boolean isTouch(int x, int y, double range);
}
