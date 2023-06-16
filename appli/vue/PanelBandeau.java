/* Classe PanelBandeau qui permet d'afficher les informations sur les îles et la couleur du joueur courant
 *@author  Louis Marouard, Maxime Galmant, Evan Cnaepelnickx, Arthur Lecomte
*/

package vue;

import javax.swing.*;
import java.awt.*;

import controleur.Controleur;

public class PanelBandeau extends JPanel //implements ActionListener
{
	private static boolean lbl1 = true; //permet de passer de labelIle1 à labelIle2
	
	private Controleur  ctrl;
	private JLabel 		lblIle1;
	private JLabel 		lblIle2;
	private JLabel      lblCouleur;

	public PanelBandeau(Controleur ctrl) 
	{
		this.ctrl = ctrl;
		this.setLayout(new GridLayout(1,3));
		/*-------------------------*/
		/* Création des composants */
		/*-------------------------*/

		this.lblIle1  = new JLabel("Ile 1 : ");
		this.lblIle2  = new JLabel("Ile 2 : ");
		this.lblCouleur = new JLabel(" Couleur : ");

		/*-------------------------------*/
		/* positionnement des composants */
		/*-------------------------------*/

		this.add(this.lblCouleur);
		this.add(lblIle1);
		this.add(lblIle2);
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(this.ctrl.getJoueur().getCouleurJoueur());
		g.fillRect(100,0,25,30);
	}

	public void setIle1   (String ile1)    { this.lblIle1.setText("Ile 1 : " + ile1)         ;}
	public void setIle2   (String ile2)    { this.lblIle2.setText("Ile 2 : " + ile2)         ;}
	public void setCouleur(String couleur) { this.lblCouleur.setText("Couleur : " + couleur) ;}

	public void setLbl (String s)
	{
		if (lbl1 )
		{
			this.setIle2("");
			this.setIle1(s);
			lbl1=false;
		}
		
		else
		{
			if (!(s.equals(lblIle1.getText())))
			{
				this.setIle2(s);
				lbl1=true;
			}
		}
	}
}