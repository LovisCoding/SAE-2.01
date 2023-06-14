package vue;

import javax.swing.*;
import javax.swing.plaf.synth.SynthScrollBarUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import controleur.Controleur;
/**
 * PanelPioche
 */

public class PanelPioche extends JPanel implements ActionListener
{
	
	private static final ImageIcon CarteDos  = new ImageIcon("./images/cartes/carte_dos.png");
	private static final ImageIcon CarteVide = new ImageIcon("./images/cartes/empty.png"	);
	
	private Controleur 	ctrl;
	private JPanel 		pnlPioche;
	private JButton 	btnCarteDos;
	private JLabel 		btnCarteFace;
	private String		type;

	public PanelPioche(Controleur ctrl)
	{
		this.ctrl = ctrl;
		pnlPioche = new JPanel();
		pnlPioche.setLayout(new FlowLayout());
		
		/*-------------------------*/
		/* Création des composants */
		/*-------------------------*/
		this.btnCarteDos  = new JButton(CarteDos);
		this.btnCarteFace = new JLabel(CarteVide);

		//Faire pour que le bouton soit comme un JLabel
		this.btnCarteDos.setBorderPainted( false );
		this.btnCarteDos.setContentAreaFilled( false );
		this.btnCarteDos.setOpaque(false);


		pnlPioche.add(btnCarteDos);
		pnlPioche.add(btnCarteFace);

		/*-------------------------------*/
		/* positionnement des composants */
		/*-------------------------------*/
		this.add(new JLabel("Pioche"));
		this.add(pnlPioche);

		/*-------------------------------*/
		/* Finalisation                  */
		/*-------------------------------*/
		this.btnCarteDos.addActionListener(this);

		
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == this.btnCarteDos)
		{
			boolean vide 	= this.ctrl.getPioche().estVide();
			ImageIcon img 	= this.ctrl.getPioche().piocher();
			if (!vide){this.btnCarteFace.setIcon(img);}
			if (this.ctrl.getPioche().estVide())
			{
				System.out.println("Pioche vide");
				this.btnCarteDos.setIcon(CarteVide);
				this.btnCarteDos.setEnabled(false);
				this.ctrl.getFrameAccueil().getFrameSolo().getPnlDroit().getPnlScore().affichageBoutonTour();
			}
			
			else
			{
				String s 	= "" + img;
				this.type = "";
				
				switch(s)
				{
					case "./images/cartes/carte_jaune_p.png": 
						this.type = "Jaune";
						break;

					case "./images/cartes/carte_joker_p.png": 
						this.type = "Joker";
						break;

					case "./images/cartes/carte_marron_p.png": 
						this.type = "Brun";
						break;

					case "./images/cartes/carte_vert_p.png":
						this.type = "Vert";
						break;

					case "./images/cartes/carte_rose_p.png":
						this.type = "Rose";
						break;
					

					case "./images/cartes/carte_joker_s.png": 
						this.type = "Joker";
						break;

					case "./images/cartes/carte_marron_s.png": 
						this.type = "Brun";
						break;

					case "./images/cartes/carte_vert_s.png":
						this.type = "Vert";
						break;
						
					case "./images/cartes/carte_rose_s.png":
						this.type = "Rose";
						break;
				}
			}
		}
	}

	public String getTypeCouleur()
	{
		return this.type;
	}
	public void nextRound()
	{
		this.btnCarteDos.setIcon(CarteDos);
		this.btnCarteFace.setIcon(CarteVide);
		this.btnCarteDos.setEnabled(true);
		this.ctrl.getPioche().reset();
		System.out.println("apres reset");
		System.out.println(this.ctrl.getJoueur().getRdmColor1());
		this.ctrl.getJoueur().changerCouleur();
		System.out.println(this.ctrl.getJoueur().getRdmColor1());

	}
}	