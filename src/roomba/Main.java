package roomba;
import java.awt.Dimension;
import javax.swing.*;

/**
 * Classe Main
 * (Classe principale du projet)
 * : Contient le main() qui va generer l'interfce graphique et mettre a jour l'environnement
 * 
 * @see Roomba
 * @see Piece
 * @see Affichage
 * 
 * @author Aurelien BEC - Julien MARTIN
 * @version 1.2
 */

public class Main extends JPanel 
{
	private static final long serialVersionUID = 4648172894076113183L; // On evite un warning
	
	public static int w = 400, h = 400;

	/**
	 * Fonction Main
	 * @param args
	 */
	public static void main(String[] args) 
	{
		JFrame ma_fenetre = new JFrame("Projet JAVA - Simulateur Roomba");
	    Affichage simu = new Affichage(w, h);
	    simu.setPreferredSize(new Dimension(w, h));
	    ma_fenetre.setContentPane(simu);
	    ma_fenetre.pack();
	    ma_fenetre.setVisible(true);
	    
	    while(true)
	    {
	    	simu.getRoomba().move(simu.getPiece());
	    	simu.repaint();
	    	//m.text();
	    	
	    	try
	    	{
	    		Thread.sleep(5);
	    	}
	    	catch (Exception e)
	    	{}
	    }
	}

}
