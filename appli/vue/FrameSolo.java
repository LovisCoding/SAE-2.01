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

		this.setLayout(new BorderLayout());
		
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

	public PanelIles    getpanelIles()    { return this.panelIles    ;}
	public PanelBandeau getpanelBandeau() { return this.panelBandeau ;}
	public PanelDroit   getpanelDroit()   { return this.panelDroit   ;}
}