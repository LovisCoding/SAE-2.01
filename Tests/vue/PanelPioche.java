package vue;

import javax.swing.*;
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
			boolean vide 	= this.ctrl.estVidePioche();
			ImageIcon img 	= this.ctrl.piocher();
			if (!vide){this.btnCarteFace.setIcon(img);}
			if (this.ctrl.estVidePioche())
			{
				System.out.println("Pioche vide");
				this.btnCarteDos.setIcon(CarteVide);
				this.btnCarteDos.setEnabled(false);
			}
			
			else
			{
				String s 	= "" + img;
				String type = "";
				
				switch(s)
				{
					case "./images/cartes/carte_jaune_p.png": 
						type = "jaune";
						break;

					case "./images/cartes/carte_joker_p.png": 
						type = "joker";
						break;

					case "./images/cartes/carte_marron_p.png": 
						type = "marron";
						break;

					case "./images/cartes/carte_vert_p.png":
						type = "vert";
						break;

					case "./images/cartes/carte_rose_p.png":
						type = "rose";
						break;

					case "./images/cartes/carte_jaune_s.png": 
						type = "jaune";
						break;

					case "./images/cartes/carte_joker_s.png": 
						type = "joker";
						break;

					case "./images/cartes/carte_marron_s.png": 
						type = "marron";
						break;

					case "./images/cartes/carte_vert_s.png":
						type = "vert";
						break;
						
					case "./images/cartes/carte_rose_s.png":
						type = "rose";
						break;
				}
			}
		}
	}
}