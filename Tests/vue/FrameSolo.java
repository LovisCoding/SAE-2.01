package vue;
import javax.swing.*;
import java.awt.*;

import controleur.Controleur;
import modele.Ile;

public class FrameSolo extends JFrame
{
	private Controleur ctrl;

	public FrameSolo(Controleur ctrl)
	{
		this.ctrl = ctrl;
		this.setTitle   ( "Jouer" );
		this.setLocation(0, 0); // Localisation
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setBackground(new Color(184,212,228));


		this.setLayout(new BorderLayout());
		
		/*-------------------------*/
		/* Création des composants */
		/*-------------------------*/

		PanelIles 	pnlIles 	= new PanelIles(ctrl);
		PanelPioche pnlPioche 	= new PanelPioche(ctrl);

		/*-------------------------------*/
		/* Positionnement des composants */
		/*-------------------------------*/

		this.add(pnlIles,	BorderLayout.CENTER);
		this.add(pnlPioche, BorderLayout.EAST);

		/*-------------------------------*/
		/*         Finalisation          */
		/*-------------------------------*/
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Fermeture de la fenêtre
		this.setVisible( true );
	}
}