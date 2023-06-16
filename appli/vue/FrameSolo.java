/*Classe Solo initialisant la fenêtre de l'application contenant le PanelJoueur et le PanelGraphe
 *@author Louis Marouard, Maxime Galmant, Evan Cnaepelnickx, Arthur Lecomte
*/

package vue;
import javax.swing.*;
import java.awt.*;

import controleur.Controleur;
import modele.Ile;

public class FrameSolo extends JFrame
{
	private Controleur ctrl;

	private PanelBandeau	panelBandeau;
	private PanelDroit 		panelDroit;
	private PanelIles 		panelIles;
	
	public FrameSolo(Controleur ctrl)
	{
		this.ctrl = ctrl;
		this.setTitle   ( "Jouer(Solo)" );
		this.setLocation(0, 0); // Localisation
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setBackground(new Color(184,212,228));

		this.setLayout(new BorderLayout(10,10));
		
		/*-------------------------*/
		/* Création des composants */
		/*-------------------------*/

		this.panelIles 	= new PanelIles	  (ctrl);
		this.panelDroit 	= new PanelDroit (ctrl);
		this.panelBandeau	= new PanelBandeau(ctrl);

		/*-------------------------------*/
		/* Positionnement des composants */
		/*-------------------------------*/

		this.add(panelIles,	 BorderLayout.CENTER);
		this.add(panelDroit,  BorderLayout.EAST);
		this.add(panelBandeau, BorderLayout.SOUTH);

		/*-------------------------------*/
		/*         Finalisation          */
		/*-------------------------------*/
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Fermeture de la fenêtre
		this.setVisible( true );
	}

	public String MajLbl(String s)
	{
		this.panelBandeau.setLbl(s);
		return s;
	}

	public PanelIles    getPanelIles   () { return this.panelIles    ;}
	public PanelBandeau getPanelBandeau() { return this.panelBandeau ;}
	public PanelDroit   getPanelDroit  () { return this.panelDroit   ;}
}