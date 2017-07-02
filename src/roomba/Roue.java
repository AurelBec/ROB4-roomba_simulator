package roomba;

import java.awt.Color;
import java.awt.Graphics2D;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.PI;

/**
 * Classe Roue
 * : Cree une roue sur le roomba
 * 
 * @see Roomba
 * @see Moteur
 * 
 * @author Aurelien BEC - Julien MARTIN
 * @version 1.0
 */

public class Roue
{
	private double rayon, theta;
	
	/**
	 * Constructeur Roue
	 * @param r Le rayon de la roue
	 * @param theta L'angle positionnant la roue sur le roomba
	 */
	public Roue(double r, double theta)
	{
		this.rayon = r;
		this.theta = theta;
	}
	
	/**
	 * Getter R
	 * @return Le rayon de la roue
	 */
	public double getR(){return this.rayon;}
	
	/**
	 * Dessine la roue dans la fenetre graphique
	 * @param g La fenetre graphique
	 * @param roomba Le robot a dessiner
	 */
	public void draw(Graphics2D g, Roomba roomba)
	{
		double x = roomba.getX();
		double y = roomba.getY();
		double t = roomba.getTheta() + theta;
		
		g.setColor(Color.black);
		
		for( double r = roomba.getD()/2-6, i = 0; i < 6; ++i, r += 0.5)
		{
			int x1 = (int) (6*cos(t)	+ x + r*cos(t+PI/2));
			int y1 = (int) (6*sin(t) 	+ y + r*sin(t+PI/2));
			int x2 = (int) (-6*cos(t)  	+ x + r*cos(t+PI/2));
			int y2 = (int) (-6*sin(t)	+ y + r*sin(t+PI/2));
			g.drawLine(x1, y1, x2, y2);
		}
	}
}
