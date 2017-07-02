package roomba;
import java.awt.Color;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import java.awt.Graphics2D;

/**
 * Classe CapteurContact
 * (Herite de Capteur)
 * : Cree un capteur de contact sur le roomba
 *
 * @see Capteur
 * 
 * @author Aurelien BEC - Julien MARTIN
 * @version 1.4
 */

public class CapteurContact extends Capteur
{
	/**
	 * Constructeur CapteurContact
	 * @see Roomba
	 * @param r La distance du capteur au centre du roomba
	 * @param theta L'angle positionnant le capteur sur le bord du roomba
	 */
	public CapteurContact(int r, double theta)
	{
		super(r, theta);
	}
	
	/**
	 * Renvoie vrai ou faux selon si le capteur est actif ou non
	 * @param piece La piece dans laquelle le robot evolue
	 * @param roomba Le roomba dont on veut connaitre l'etat du capteur
	 * @return L'etat d'actvite du capteur
	 */
	boolean isActive(Piece piece, Roomba roomba)
	{
		int x = roomba.getX() + (int) (this.r * cos(roomba.getTheta() + this.theta));
		int y = roomba.getY() + (int) (this.r * sin(roomba.getTheta() + this.theta));
		
		if(piece.obstacleIci(x, y))
		{
			this.color = Color.green;
			return true;
		}
		else
		{
			this.color = Color.blue;
			return false;
		}
	}
	
	/**
	 * Dessine le capteur dans la fenetre graphique
	 * @param g La fenetre graphique
	 * @param roomba Le robot a dessiner
	 */
	public void draw(Graphics2D g, Roomba roomba)
	{
		g.setColor(this.color);
		int x = (roomba.getX() + (int) (this.r * Math.cos(roomba.getTheta() + this.theta) /1.5) );
		int y = (roomba.getY() + (int) (this.r * Math.sin(roomba.getTheta() + this.theta) /1.5) );
		g.fillOval(x-9, y-9, 18, 18);		
	}
}
