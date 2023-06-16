/* Classe PanelPioche qui permet de créer un panel contenant la pioche
 *@author Louis Marouard, Maxime Galmant, Evan Cnaepelnickx, Arthur Lecomte
*/

package vue;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import controleur.Controleur;

public class PanelPioche extends JPanel implements ActionListener
{

	private static final ImageIcon CarteDos  = new ImageIcon("./images/cartes/carte_dos.png");
	private static final ImageIcon CarteVide = new ImageIcon("./images/cartes/empty.png"	);

	private Controleur ctrl;
	private JPanel 	   panelPioche;
	private JButton    btnCarteDos;
	private JLabel 	   btnCarteFace;
	private String	   type;

	public PanelPioche(Controleur ctrl)
	{
		this.ctrl   = ctrl;
		panelPioche = new JPanel();
		panelPioche.setLayout(new FlowLayout());

		/*-------------------------*/
		/* Création des composants */
		/*-------------------------*/

		this.btnCarteDos  = new JButton(CarteDos);
		this.btnCarteFace = new JLabel(CarteVide);

		//Faire pour que le bouton soit comme un JLabel
		this.btnCarteDos.setBorderPainted    ( false );
		this.btnCarteDos.setContentAreaFilled( false );
		this.btnCarteDos.setOpaque           ( false );


		panelPioche.add(btnCarteDos );
		panelPioche.add(btnCarteFace);

		/*-------------------------------*/
		/* positionnement des composants */
		/*-------------------------------*/

		this.add(new JLabel("Pioche"));
		this.add(panelPioche);

		/*-------------------------------*/
		/* Finalisation                  */
		/*-------------------------------*/

		this.btnCarteDos.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == this.btnCarteDos)
		{
			boolean vide  = this.ctrl.getPioche().estVide();
			ImageIcon img = this.ctrl.getPioche().piocher();

			String s = "" + img;
			System.out.println("s : " + s);
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

				case "./images/cartes/carte_verte_p.png":
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

				case "./images/cartes/carte_verte_s.png":
					this.type = "Vert";
					break;

				case "./images/cartes/carte_rose_s.png":
					this.type = "Rose";
					break;

				case "./images/cartes/carte_jaune_s.png":
					this.type = "Jaune";
					break;

				default :
					this.type = "Erreur";
					break;
			}

			System.out.println("type : " + this.type);

			if (!vide) { this.btnCarteFace.setIcon(img) ;}

			if (this.ctrl.getPioche().estVide())
			{
				System.out.println("Pioche vide");
				this.btnCarteDos.setIcon(CarteVide);
				this.btnCarteDos.setEnabled(false);
				this.ctrl.getFrameAccueil().getFrameSolo().getPanelDroit().getPanelScore().affichageBoutonTour();
			}
		}
	}

	public String getTypeCouleur() { return this.type ;}

	public void nextRound()
	{
		this.btnCarteDos .setIcon   ( CarteDos  );
		this.btnCarteFace.setIcon   ( CarteVide );
		this.btnCarteDos .setEnabled( true      );

		this.ctrl.getPioche().reset           ();
		this.ctrl.getJoueur().changerCouleur  ();
		this.ctrl.getGraphe().reset           ();
		this.ctrl.getJoueur().setAJoue  ( true );
	}

	public void click() { this.btnCarteDos.doClick(); }
}