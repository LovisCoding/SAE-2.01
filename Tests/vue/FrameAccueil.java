/*Classe Frame initialisant la fenêtre de l'application contenant le PanelJoueur et le PanelGraphe
 *Auteurs : Louis Marouard, Maxime Galmant, Evan Cnaepelnickx, Arthur Lecomte
*/

package vue;

import controleur.Controleur;

import javax.swing.*;
import java.awt.*;

public class FrameAccueil extends JFrame
{
	Controleur    	ctrl;
	PanelAccueil 	pnlAccueil;
	PanelIles 		pnlSolo;

	public FrameAccueil(Controleur ctrl)
	{
		this.ctrl = ctrl;
		this.setTitle   ( "Jouer" );
		this.setLocation(500, 250 ); // Localisation
		this.setSize    (200, 200 ); // Taille

		this.setLayout(new FlowLayout());

		/*-------------------------*/
		/* Création des composants */
		/*-------------------------*/

		this.pnlAccueil = new PanelAccueil(ctrl);
	

		/*-------------------------------*/
		/* Positionnement des composants */
		/*-------------------------------*/

		this.add(pnlAccueil, BorderLayout.CENTER);

		/*-------------------------------*/
		/*         Finalisation          */
		/*-------------------------------*/
		this.pnlAccueil.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Fermeture de la fenêtre
		this.setVisible( true );
		
	}

	public void Solo()
	{
		
		new FrameSolo(this.ctrl);
		this.dispose();
	}

	public void Accueil()
	{
		new FrameAccueil(this.ctrl);
		
	}
}