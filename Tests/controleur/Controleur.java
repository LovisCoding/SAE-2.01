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
		this.graphe 		= new Graphe("graphe");
		this.lf 			= new LireFichier("./data/data.txt", this);
		this.lf.lire();
		this.pioche 		= new Pioche();
		this.joueur 		= new Joueur();
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

	public ImageIcon piocher()
	{
		return this.pioche.piocher();
	}
	public int taillePioche()
	{
		return this.pioche.taillePioche();
	}
	public boolean estVidePioche()
	{
		return this.pioche.estVide();
	}

	public Graphe getGraphe() 
	{
		return this.graphe;
	}

	public Joueur getJoueur() 
	{
		return this.joueur;
	}
	public FrameAccueil getFrameAccueil()
	{
		return this.frameAccueil;
	}

}

