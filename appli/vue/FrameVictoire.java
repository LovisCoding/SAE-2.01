/* Classe FrameVictoire affichant une fenêtre de victoire
 *@author  Louis Marouard, Maxime Galmant, Evan Cnaepelnickx, Arthur Lecomte
*/

package vue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import controleur.Controleur;

public class FrameVictoire extends JFrame 
{
	Controleur  ctrl;
	JPanel      panelV;
	ImageIcon   img;

	public FrameVictoire(Controleur ctrl)
	{
		this.ctrl = ctrl;
		this.setTitle   ( "Victoire" );
		this.setLocation(200, 100); // Localisation
		this.setSize    (300, 400); // Taille

		this.setLayout(new FlowLayout());

		/*-------------------------*/
		/* Création des composants */
		/*-------------------------*/

		this.panelV = new JPanel();
		this.img    = new ImageIcon("./images/bravo.gif");

		/*-------------------------------*/
		/* Positionnement des composants */
		/*-------------------------------*/

		panelV.setLayout(new GridLayout(4,1));
		panelV.add(new JLabel("Vous avez gagné avec "+ this.ctrl.getJoueur().getPoints() + " points", JLabel.CENTER));
		panelV.add(new JLabel("Vous avez atteint le nombre de coups maximum !"));
		panelV.add(new JLabel("C.a.d : " + this.ctrl.getJoueur().getRdmColor1() + " coups rouge et : " + this.ctrl.getJoueur().getRdmColor2() + " bleus !"));
		panelV.add(new JLabel(this.img));

		this.add(panelV);

		/*-------------------------------*/
		/*         Finalisation          */
		/*-------------------------------*/

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Fermeture de la fenêtre
		this.setVisible( true );	
	}
}