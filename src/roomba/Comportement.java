package roomba;
/**
 * Classe Abstraite Comportement
 * (Implemente ComportementAleatoire et ComportementFullClean)
 * : Decrit le comportement que doit avoir le roomba
 * 
 * @see ComportementAleatoire
 * @see ComportementFullClean
 * 
 * @author Aurelien BEC - Julien MARTIN
 * @version 1.1
 */

public abstract class Comportement 
{
	protected int busyTime;
	protected double[] vit;
	
	/**
	 * Constructeur Comportement
	 */
	public Comportement()
	{
		vit = new double[2];
		vit[0] = 0; vit[1] = 0;
		busyTime = 0;
	}
	
	/**
	 * Met a jour les vitesses a envoyer au roomba en fonction du comportement et des evenements recus
	 * @param event Evenement detecte qui correspond a une action precise et qui doit etre implementee
	 * @param param parametre facultatif qui peut etre necessaire a la reaction a l'evenement
	 * @param prevVit Les vitesses precedentes des moteurs
	 * @return Les vitesses a envoyer aux moteurs
	 * @see Moteur
	 */
	abstract double[] update(String event, double param, double[] prevVit);
	
	/**
	 * Decremente le temps avant la fin d'une action
	 */
	public void next(){ busyTime --;}
}
