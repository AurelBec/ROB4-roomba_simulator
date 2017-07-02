package roomba;

/**
 * Classe ComportementFullClean
 * (Herite de Comportement)
 * : Decrit un comportement "nettoyage complet" du roomba
 * 
 * @see Comportement
 * 
 * @author Aurelien BEC - Julien MARTIN
 * @version 1.0
 */

public class ComportementFullClean extends Comportement
{
	private double range;
	
	/**
	 * Constructeur ComportementFullClean
	 */
	public ComportementFullClean()
	{
		super();
		range = 1.0;
	}
	
	/**
	 * Met a jour les vitesses a envoyer au roomba en fonction du comportement et des evenements recus
	 * @param event Evenement detecte qui correspond a une action precise et qui doit etre implementee
	 * @param param parametre facultatif qui peut etre necessaire a la reaction a l'evenement 
	 * @param prevVit Les vitesses precedentes des moteurs
	 * @return Les vitesses a envoyer aux moteurs
	 * @see Moteur
	 */
	public double[] update(String event, double param, double[] prevVit)
	{
		vit[0] = 0 * range;
		vit[1] = 0 * range;
		
		return vit;
	}

}
