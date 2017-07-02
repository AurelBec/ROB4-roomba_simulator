package roomba;
import java.util.Random;

/**
 * Classe ComportementAleatoire
 * (Herite de Comportement)
 * : Decrit un comportement "Aleatoire" du roomba
 * 
 * @see Comportement
 * 
 * @author Aurelien BEC - Julien MARTIN
 * @version 1.3
 */

public class ComportementAleatoire extends Comportement 
{	
	private boolean direction;
	Random r = new Random();
	
	/**
	 * Constructeur ComportementAleatoire
	 */
	public ComportementAleatoire()
	{
		super();
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
		if(this.busyTime > 0) return prevVit;
		
		if( event.equals("BUMP"))
		{
			this.busyTime = r.nextInt(31) + 50;

			if(param < 1e-20  && param > -1e-20)
				this.direction = r.nextBoolean();
			else if( param > 1e-20)
				this.direction = true;
			else if( param < -1e-20)
				this.direction = false;
			
			vit[0] = (this.direction)? 0.3 : -0.3;
			vit[1] = (this.direction)? -0.3 : 0.3;
		}
		else if( event.equals("DEFAULT") || event.equals("CLEAN"))
		{
			vit[0] = param;
			vit[1] = param;
		}
		
		return vit;
	}

}
