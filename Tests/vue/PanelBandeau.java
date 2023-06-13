package vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import controleur.Controleur;
/**
 * PanelBandeau
 */

public class PanelBandeau extends JPanel //implements ActionListener
{
	
	private Controleur 	ctrl;
	private JLabel 		lblIle1;
	private JLabel 		lblIle2;
	private JLabel      lblcouleur;

	public PanelBandeau(Controleur ctrl) 
	{
		this.ctrl = ctrl;

		/*-------------------------*/
		/* Création des composants */
		/*-------------------------*/

		this.lblIle1  = new JLabel("Ile 1 : ");
		this.lblIle2  = new JLabel("Ile 2 : ");

		/*-------------------------------*/
		/* positionnement des composants */
		/*-------------------------------*/

		this.add(lblIle1);
		this.add(lblIle2);


	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(this.ctrl.getJoueur().getCouleurJoueur());
		g.fillRect(800,0,30,30);

	}

	public void setIle1(String ile1)
	{
		this.lblIle1.setText("Ile 1 : " + ile1);
	}

	public void setIle2(String ile2)
	{
		this.lblIle2.setText("Ile 2 : " + ile2);
	}

	public void setCouleur(String couleur)
	{
		this.lblcouleur.setText("Couleur : " + couleur);
	}

	public void setLbl (String s)
	{
		this.lblIle1.setText(s);
	}

	
	

}