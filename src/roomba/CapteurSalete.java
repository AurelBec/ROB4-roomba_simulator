package roomba;
import java.awt.Color;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import java.awt.Graphics2D;

/**
 * Classe CapteurSalete
 * (Herite de Capteur)
 * : Cree un capteur de salete sur le roomba
 * 
 * @see Capteur
 * 
 * @author Aurelien BEC - Julien MARTIN
 * @version 1.2
 */

public class CapteurSalete extends Capteur
{
	private double range;

	/**
	 * Constructeur CapteurSalete
	 * @see Roomba
	 * @param r La distance du capteur au centre du roomba
	 * @param theta L'angle positionnant le capteur sur le bord du roomba
	 */
	public CapteurSalete(int r, double theta)
	{
		super(r, theta);
		this.range = 5;
	}
	
	public double getRange() {return range;}
	
	/**
	 * Renvoie vrai ou faux selon si le capteur est actif ou non
	 * @param piece La piece dans laquelle le robot évolue
	 * @param roomba Le roomba dont on veut connaitre l'etat du capteur
	 * @return L'etat d'actvite du capteur
	 */
	boolean isActive(Piece piece, Roomba roomba)
	{	
		int x = roomba.getX() + (int) (this.r * cos(roomba.getTheta() + this.theta));
		int y = roomba.getY() + (int) (this.r * sin(roomba.getTheta() + this.theta));
	    if(piece.tacheIci(x, y, this.range))
	    {
			this.color = Color.green;
			return true;
		}
		else
		{
			this.color = roomba.getColor();
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
		g.fillOval(roomba.getX()-(int)range, roomba.getY()-(int)range, (int)(2*range), (int)(2*range));
		g.setColor(Color.black);
		g.drawOval(roomba.getX()-(int)range, roomba.getY()-(int)range, (int)(2*range), (int)(2*range));
	}		
}
