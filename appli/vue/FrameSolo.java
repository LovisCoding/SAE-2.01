package vue;
import javax.swing.*;
import java.awt.*;

import controleur.Controleur;
import modele.Ile;

public class FrameSolo extends JFrame
{
	private Controleur ctrl;

	private PanelBandeau	pnlBandeau;
	private PanelDroit 		pnlDroit;
	private PanelIles 		pnlIles;
	
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

		this.pnlIles 	= new PanelIles	  (ctrl);
		this.pnlDroit 	= new PanelDroit (ctrl);
		this.pnlBandeau	= new PanelBandeau(ctrl);

		/*-------------------------------*/
		/* Positionnement des composants */
		/*-------------------------------*/

		this.add(pnlIles,	 BorderLayout.CENTER);
		this.add(pnlDroit,  BorderLayout.EAST);
		this.add(pnlBandeau, BorderLayout.SOUTH);

		/*-------------------------------*/
		/*         Finalisation          */
		/*-------------------------------*/
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Fermeture de la fenêtre
		this.setVisible( true );
	}
	public String MajLbl(String s)
	{
		
		this.pnlBandeau.setLbl(s);
		return s;
	}

	public PanelIles getPnlIles()
	{
		return this.pnlIles;
	}
	public PanelBandeau getPnlBandeau()
	{
		return this.pnlBandeau;
	}

	public PanelDroit getPnlDroit()
	{
		return this.pnlDroit;
	}

}