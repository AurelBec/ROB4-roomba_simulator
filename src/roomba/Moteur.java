package roomba;

/**
 * Classe Moteur
 * : Cree un moteur sur le roomba
 * 
 * @see Roomba
 * @see Comportement
 * @see Roue
 * 
 * @author Aurelien BEC - Julien MARTIN
 * @version 1.0
 */

public class Moteur 
{
	private double vit;
	
	/**
	 * Constructeur Moteur
	 * @param v La vitesse du motor entre 0 et 1 m/s
	 */
	public Moteur( double v) { setV(v);}
	
	/**
	 * Getter V
	 * @return La vitesse du moteur entre 0 et 1 m/s
	 */
	public double getV(){return this.vit;}

	/**
	 * Setter V
	 * @param v La vitesse a attribuer entre 0 et 1 m/s
	 */
	public void setV(double v){this.vit = (v > 1) ? 1 : (v < 0) ? 0 : v;}
}
