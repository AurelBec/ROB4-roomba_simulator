package roomba;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

/**
 * Classe TacheRonde
 * (Herite de Tache)
 * : Cree une tache ronde dans la piece
 * 
 * @see Tache
 * @see Piece
 * 
 * @author Aurelien BEC - Julien MARTIN
 * @version 1.3
 */

public class TacheRonde extends Tache
{
	private int r;
	
	/**
	 * Constructeur TacheRonde
	 * @param x La coordonnee x de la tache
	 * @param y La coordonnee y de la tache
	 */
	public TacheRonde(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.color = Color.white;
		this.r = new Random().nextInt(11) + 10;
		this.isClean = false;
	}
	
	/**
	 * Getter D
	 * @return Le diametre de la tache
	 */
	public int getR(){return this.r;}
	
	/**
	 * Nettoie la tache petit a petit
	 */
	public void clean()
	{
		this.r = (r>0) ? r-1 : 0;
		this.isClean = (r <= 0);
	}
	
	/**
	 * Renvoie vrai ou faux s'il y a collision entre un cercle de rayon range et de centre x,y et la tache
	 * @param x La coordonnee x du centre
	 * @param y La coordonnee y du centre
	 * @param range le rayon dans lequel chercher une tache
	 * @return La presence ou non de tache dans le cercle x,y,range
	 */
	public boolean isTouch(int x, int y, double range)
	{
		return (this.x - x)*(this.x - x) + (this.y - y)*(this.y - y) < (r + range) * (r + range);
	}
	
	/**
	 * Dessine les contours de la tache dans la fenetre graphique
	 * @param g La fenetre graphique
	 */
	public void line(Graphics2D g) 
	{
		 g.setColor(Color.black);
		 g.fillOval(getX() - r, getY() - r, r*2, r*2);
	}
	
	/**
	 * Remplit la tache dans la fenetre graphique
	 * @param g La fenetre graphique
	 */
	public void fill(Graphics2D g) 
	{
		 g.setColor(this.color);
		 g.fillOval(getX() - r + 1, getY() - r + 1, 2*r-2, 2*r-2);
	}
}
