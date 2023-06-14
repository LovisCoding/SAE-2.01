/*Classe Controleur qui permet de faire le lien entre le modèle et la vue
 *Auteurs : Louis Marouard, Maxime Galmant, Evan Cnaepelnickx, Arthur Lecomte 
*/

package controleur;

import java.util.List;

import modele.*;

import javax.swing.ImageIcon;

import vue.FrameAccueil;


public class Controleur
{
	private FrameAccueil 	frameAccueil;
	private LireFichier 	lf;
	private Graphe 			graphe;
	private Pioche 			pioche;
	private Joueur 			joueur;
	private String 			lblBandeau;
	
	public Controleur() 
	{
		this.joueur 		= new Joueur(this);
		this.graphe 		= new Graphe("graphe",this);
		this.lf 			= new LireFichier("./data/data.txt", this);
		this.lf.lire();
		this.pioche 		= new Pioche();
		this.frameAccueil 	= new FrameAccueil(this);
		this.lblBandeau = "";
	}

	public static void main(String args[])
	{
		Controleur ctrl = new Controleur();

		System.out.println("Nombre d'arete : " + ctrl.getGraphe().getEnsArete().size());
		System.out.println("Nombre d'ile : " + ctrl.getGraphe().getEnsIle().size());
	}
	
	public void Solo()
	{
		this.frameAccueil.Solo();
	}

	public void Multi()
	{
		this.frameAccueil.Multi();
	}

	public Graphe getGraphe() 
	{
		return this.graphe;
	}

	public Joueur getJoueur() 
	{
		return this.joueur;
	}
	public Pioche getPioche()
	{
		return this.pioche;
	}

	public FrameAccueil getFrameAccueil()
	{
		return this.frameAccueil;
	}

}

