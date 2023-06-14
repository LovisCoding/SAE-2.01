package vue;
import javax.swing.*;
import java.awt.*;

import controleur.Controleur;
import modele.Ile;

public class FrameMulti extends JFrame
{
	private Controleur ctrl;

	public FrameMulti(Controleur ctrl)
	{
		this.ctrl = ctrl;
		this.setTitle   ( "Jouer(MultiJoueur)" );
		this.setLocation(0, 0); // Localisation
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setBackground(new Color(184,212,228));


		this.setLayout(new BorderLayout());
		
		/*-------------------------*/
		/* Création des composants */
		/*-------------------------*/

		PanelIles 	pnlIles 	= new PanelIles(ctrl);
		PanelDroit pnlDroit 	= new PanelDroit(ctrl);

		/*-------------------------------*/
		/* Positionnement des composants */
		/*-------------------------------*/

		this.add(pnlIles,	BorderLayout.CENTER);
		this.add(pnlDroit, BorderLayout.EAST);
		

		/*-------------------------------*/
		/*         Finalisation          */
		/*-------------------------------*/
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Fermeture de la fenêtre
		this.setVisible( true );
	}
}