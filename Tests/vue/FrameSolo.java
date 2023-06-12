package vue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;

import controleur.Controleur;

public class FrameSolo extends JFrame
{
	private Controleur ctrl;

	public FrameSolo(Controleur ctrl)
	{
		this.ctrl = ctrl;
		this.setTitle   ( "Jouer" );
		this.setLocation(0, 0); // Localisation
		this.setSize    (1200, 800); // Taille

		this.setLayout(new FlowLayout());

		/*-------------------------*/
		/* Création des composants */
		/*-------------------------*/

		PanelSolo pnlSolo = new PanelSolo(ctrl);

		/*-------------------------------*/
		/* Positionnement des composants */
		/*-------------------------------*/

		this.add(pnlSolo);

		/*-------------------------------*/
		/*         Finalisation          */
		/*-------------------------------*/
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Fermeture de la fenêtre
		this.setVisible( true );
	}
}
