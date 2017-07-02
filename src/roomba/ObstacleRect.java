package roomba;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

/**
 * Classe ObstacleRect
 * (Herite de Obstacle)
 * : Cree un obstacle rectangulaire dans la piece
 * 
 * @see Obstacle
 * @see Piece
 * 
 * @author Aurelien BEC - Julien MARTIN
 * @version 1.2
 */

public class ObstacleRect extends Obstacle
{
	private int w;
	private int h;
	
	/**
	 * Constructeur ObstacleRect
	 * @param w La largeur de la piece
	 * @param h La hauteur de la piece
	 */
	ObstacleRect(int w, int h)
	{
		this.x = new Random().nextInt(w);
		this.y = new Random().nextInt(h);
		this.w = new Random().nextInt(31) + 20;
		this.h = new Random().nextInt(31) + 20;
		this.color = new Color(139,69,19);
	}
	
	/**
	 * Dessine les contours de l'obstacle dans la fenetre graphique
	 * @param g La fenetre graphique
	 */
	public void line(Graphics2D g) 
	{
		 g.setColor(Color.black);
		 g.fillRect(this.x, this.y, this.w, this.h);
	}
	
	/**
	 * Remplit l'obstacle dans la fenetre graphique
	 * @param g La fenetre graphique
	 */
	public void fill(Graphics2D g) 
	{
		 g.setColor(this.color);
		 g.fillRect(this.x+1, this.y+1, this.w-2, this.h-2);
	}

	/**
	 * Renvoie vrai ou faux si l'obstacle est touche ou non
	 * @param x Coordonnee x du point a tester
	 * @param y Coordonne y du point a tester
	 * @return L'etat de la collision avec l'obstacle
	 */
	public boolean isTouch(int x, int y) 
	{
		return x >= this.x && x < this.x + w && y >= this.y && y < this.y + h;
	}

}
