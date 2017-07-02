package roomba;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

/**
 * Classe ObstacleRond
 * (Herite de Obstacle)
 * : Cree un obstacle rond dans la piece
 * 
 * @see Obstacle
 * @see Piece
 * 
 * @author Aurelien BEC - Julien MARTIN
 * @version 1.2
 */

public class ObstacleRond extends Obstacle
{
	private int d;
	
	/**
	 * Constructeur ObstacleRond
	 * @param w La largeur de la piece
	 * @param h La hauteur de la piece
	 */
	ObstacleRond(int w, int h)
	{
		this.x = new Random().nextInt(w);
		this.y = new Random().nextInt(h);
		this.d = new Random().nextInt(31) + 20;
		this.color = new Color(139,69,19);
	}
	
	/**
	 * Dessine les contours de l'obstacle dans la fenetre graphique
	 * @param g La fenetre graphique
	 */
	public void line(Graphics2D g) 
	{
		 g.setColor(Color.black);
		 g.fillOval(this.x - this.d/2, this.y - this.d/2, this.d, this.d);
	}
	
	/**
	 * Remplit l'obstacle dans la fenetre graphique
	 * @param g La fenetre graphique
	 */
	public void fill(Graphics2D g) 
	{
		 g.setColor(this.color);
		 g.fillOval(this.x - this.d/2+1, this.y - this.d/2+1, this.d-2, this.d-2);
	}

	/**
	 * Renvoie vrai ou faux si l'obstacle est touche ou non
	 * @param x Coordonnee x du point a tester
	 * @param y Coordonne y du point a tester
	 * @return L'etat de la collision avec l'obstacle
	 */
	public boolean isTouch(int x, int y) 
	{
		return (this.x - x)*(this.x - x) + (this.y - y)*(this.y - y) <= d/2 * d/2;
	}

}
