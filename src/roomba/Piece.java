package roomba;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

/**
 * Classe Piece
 * : Cree une piece contenant un roomba et des obstacles
 *
 * @see Roomba
 * @see Obstacle
 * @see Tache
 * @see Affichage
 * 
 * @author Aurelien BEC - Julien MARTIN
 * @version 1.5
 */

public class Piece 
{
	private int w;
	private int h;
	private int nb_obstacles;
	private int nb_taches;
	private ArrayList<Obstacle> obstacles;
	private ArrayList<Tache> taches;
	
	/**
	 * Constructeur Piece
	 * @param w La largeur de la piece
	 * @param h La hauteur de la piece
	 */
	public Piece( int w, int h)
	{
		Random r = new Random();

		this.w = w;
		this.h = h;
		this.nb_obstacles = r.nextInt(10) + 2;
		this.nb_taches = r.nextInt(10) + 1;
		this.obstacles = new ArrayList<Obstacle>();
		this.taches = new ArrayList<Tache>();
		
		for(int i = 0; i < this.nb_obstacles; ++i)
			switch(r.nextInt(2))
			{
				case 0:
					obstacles.add(new ObstacleRect(w, h));
					break;
				case 1:
					obstacles.add(new ObstacleRond(w, h));
					break;
				default: break;
			}
		
		for(int i = 0; i < this.nb_taches; ++i)
		{				
			boolean inObstacle;
			int x, y;
			
			do
			{
				inObstacle = false;
				x =  r.nextInt(w);
				y =  r.nextInt(h);
				
				for (Obstacle obstacle : obstacles)
				{
					if( obstacle.isTouch(x, y))
					{
						inObstacle = true;
						break;
					}
				}
			} while(inObstacle == true);
			
			taches.add(new TacheRonde(x, y));
		}
	}
	
	/**
	 * Getter W
	 * @return La largeur de la piece
	 */
	public double getW(){ return this.w;}
	
	/**
	 * Getter H
	 * @return La hauteur de la piece
	 */
	public double getH(){ return this.h;}

	/**
	 * Getter H
	 * @return La liste des obstacles
	 */

	//public ArrayList<Obstacle> getObstacles(){return this.obstacles;}
	//public ArrayList<Tache> getTaches(){return this.taches;}
	//public int nbObstacles(){return this.nb_obstacles;}
	//public int nbTaches(){return this.nb_taches;}
	
	/**
	 * Renvoie vrai ou faux s'il y a un obstacle au point x,y
	 * @param x La coordonnee x du point
	 * @param y La coordonnee y du point
	 * @return La presence ou non d'obstacle au point x,y
	 */
	public boolean obstacleIci(int x, int y)
	{
		if( x >= this.w || x <= 0 || y >= this.h || y <= 0)
			return true;

		for( Obstacle obstacle : this.obstacles)
			if(obstacle.isTouch(x, y))
				return true;

		return false;
	}
	
	/**
	 * Renvoie vrai ou faux s'il y a une tache a une distance range du point x,y
	 * @param x La coordonnee x du point
	 * @param y La coordonnee y du point
	 * @param r le rayon dans lequel chercher une tache
	 * @return La presence ou non de tache au point x,y
	 */
	public boolean tacheIci(int x, int y, double r)
	{
		for(Tache tache : this.taches)
		{
			if(tache.isTouch(x, y, r))
			{
				tache.clean();
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Dessine la piece dans la fenetre graphique
	 * @param g La fenetre graphique
	 */
	 public void draw(Graphics2D g)
	 {
		 for(int i = 0; i < taches.size(); ++i)
			 if(taches.get(i).isClean())
				 taches.remove(i);
		 
		 for(Tache tache : this.taches)
			 tache.line(g);
		 for(Tache tache : this.taches)
			 tache.fill(g);
		 
		 for(Obstacle obstacle : this.obstacles )
			obstacle.line(g);
		 for(Obstacle obstacle : this.obstacles )
			obstacle.fill(g);
		
		g.drawLine(0, 0, this.w, 0);
		g.drawLine(0, 0, 0, this.h);
		g.drawLine(0, this.h, this.w, this.h);
		g.drawLine(this.w, 0, this.w, this.h);
	 }
	 
	
}
