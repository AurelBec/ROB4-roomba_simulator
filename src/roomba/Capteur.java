package roomba;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Classe abstraite Capteur
 * (Implemente CapteurContact et CapteurSalete)
 *  : Cree un capteur sur le roomba
 *  
 * @see CapteurContact
 * @see CapteurSalete
 * 
 * @author Aurelien BEC - Julien MARTIN
 * @version 1.1
 */

public abstract class Capteur
{
	protected int r;
	protected double theta;
	protected Color color;
	
	/**
	 * Constructeur Capteur
	 * @see Roomba
	 * @param r La distance du capteur au centre du roomba
	 * @param theta L'angle positionnant le capteur sur le bord du roomba
	 */
	public Capteur(int r, double theta)
	{
		this.r = r;
		this.theta = theta;
		this.color = Color.blue;
	}

	/**
	 * Getter Rayon
	 * @return La distance du capteur au centre du roomba
	 */
	public int getR(){return this.r;}
	/**
	 * Getter Theta
	 * @return L'angle positionnant le capteur sur le bord du roomba
	 */
	public double getTheta(){return this.theta;}
	
	/**
	 * Renvoie vrai ou faux selon si le capteur est actif ou non
	 * @param piece La piece dans laquelle le robot évolue
	 * @param roomba Le roomba dont on veut connaitre l'etat du capteur
	 * @return L'etat d'actvite du capteur
	 */
	abstract boolean isActive(Piece piece, Roomba roomba);

	/**
	 * Dessine le capteur dans la fenetre graphique
	 * @param g La fenetre graphique
	 * @param roomba Le robot a dessiner
	 */
	public abstract void draw(Graphics2D g, Roomba roomba);
	
}
