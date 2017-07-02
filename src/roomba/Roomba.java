package roomba;
import java.awt.Color;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.PI;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * Classe Roomba
 * : Cree un roomba possedant plusieurs capteurs et moteurs et un comportement
 * 
 * @see Capteur
 * @see Moteur
 * @see Roue
 * @see Comportement
 * 
 * @author Aurelien BEC - Julien MARTIN
 * @version 1.4
 */

public class Roomba 
{
	private int r;
	private Color color;
	private double[] vit;
	private Comportement comportement;
	private Posture position; 
	private Moteur moteurDroit; 
	private Moteur moteurGauche;
	private Roue roueDroite; 
	private Roue roueGauche; 
	
	private ArrayList<CapteurContact> capteurContact;
	private CapteurSalete capteurSalete;
	
	/**
	 * Constructeur Roomba
	 * @param x La position x du roomba
	 * @param y La position y du roomba
	 */
	public Roomba(int x, int y)
	{
		this.r = 34 / 2;
		this.color = Color.lightGray;
		this.vit = new double[2];
		this.vit[0] = 0; this.vit[1] = 0;
		this.comportement = new ComportementAleatoire();
		
		this.position = new Posture(x, y, 0);
		this.moteurDroit = new Moteur(0);
		this.moteurGauche = new Moteur(0);
		this.roueDroite = new Roue(2, 0);
		this.roueGauche = new Roue(2, Math.PI);
		
		this.capteurContact = new ArrayList<CapteurContact>();
		this.capteurContact.add(new CapteurContact(r, 0.0));
		this.capteurContact.add(new CapteurContact(r, -PI/3.5));
		this.capteurContact.add(new CapteurContact(r, PI/3.5));
		
		this.capteurSalete = new CapteurSalete(0, 0);
	}

	public int getX() { return this.position.getX();}
	public int getY() { return this.position.getY();}
	public int getD() {return 2*r;}
	public Color getColor() {return this.color;}
	public double getTheta() { return this.position.getTheta(); }
	public Posture getPosition() {return position;}
	 
	/**
	 * Fait bouger le robot en fonction de son comportement
	 * @param p Piece dans laquelle se trouve le roomba
	 */
	public void move(Piece p)
	{
		vit = comportement.update("DEFAULT", 0.3, vit);
		
		for(CapteurContact capteur : capteurContact)
			if(capteur.isActive(p, this) )
			{
				vit = comportement.update("BUMP", capteur.getTheta(), vit);
				break;
			}
		
		if( capteurSalete.isActive(p, this))
			vit = comportement.update("CLEAN", 0, vit);
		
		moteurDroit.setV(vit[0]);
		moteurGauche.setV(vit[1]);
		position.move(moteurDroit.getV()*roueDroite.getR(), moteurGauche.getV()*roueGauche.getR(), getD());
		
		comportement.next();
	}

	/**
	 * Dessine le roomba dans la fenetre graphique
	 * @param g La fenetre graphique
	 */
	public void draw(Graphics2D g)
	{		 
		 for(CapteurContact capteur : capteurContact)
			 capteur.draw(g, this);
		 
		 g.setColor(this.color);
		 g.fillOval(getX() - r, getY() - r, 2*r, 2*r);
		 
		 g.setColor(Color.black);
		 g.drawLine(getX(), getY(), (int) (getX() + r * cos(getTheta())) , (int) (getY() + r * sin(getTheta())));
		 g.drawOval(getX() - r, getY() - r, 2*r, 2*r);

		 capteurSalete.draw(g, this);
		 roueGauche.draw(g, this);
		 roueDroite.draw(g, this);
	}	
}
