/*Classe Controleur qui permet de faire le lien entre le modèle et la vue
 *Auteurs : Louis Marouard, Maxime Galmant, Evan Cnaepelnickx, Arthur Lecomte 
*/

package controleur;

import java.util.ArrayList;
import java.util.List;
import java.awt.Graphics;

import modele.LireFichier;
import modele.GroupIles;
import modele.Ile;

import vue.FrameAccueil;



public class Controleur
{
	private FrameAccueil 	frameAccueil;
	private LireFichier 	lf;
	private GroupIles 		gpIles;

	public Controleur() 
	{
		this.lf 			= new LireFichier("./data/data.txt");
		this.lf.lire();
		this.gpIles 		= this.lf.getGroupIles();

		this.frameAccueil 	= new FrameAccueil(this);
		

	}

	public static void main(String args[])
	{
		

		new Controleur();

	}
	public void Solo()
	{
		this.frameAccueil.Solo();
	}
	public void Multi()
	{
		this.frameAccueil.Solo();
	}
	public GroupIles getGroupIles()
	{
		return this.gpIles;
	}
}

