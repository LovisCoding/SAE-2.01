/*Classe Controleur qui permet de faire le lien entre le modèle et la vue
 *@author : Louis Marouard, Maxime Galmant, Evan Cnaepelnickx, Arthur Lecomte 
*/

package controleur;

import java.util.List;
import modele.*;
import javax.swing.ImageIcon;
import vue.FrameAccueil;
import vue.ScriptScenario1;
import vue.ScriptScenario2;


public class Controleur
{
	private FrameAccueil 	frameAccueil;
	private LireFichier 	lf;
	private Graphe 			graphe;
	private Pioche 			pioche;
	private Joueur 			joueur;
	private Score 			score;
	private ScriptScenario1 scriptScenario1;
	private ScriptScenario2 scriptScenario2;

	private static boolean bScenario = false;

	public Controleur() 
	{
		this.joueur 		= new Joueur(this);
		this.graphe 		= new Graphe("graphe",this);
		this.lf 			= new LireFichier("./data/data.txt", this);
		this.lf.lire();
		this.pioche 		= new Pioche(this); 
		frameAccueil 		= new FrameAccueil(this);
		this.score 			= new Score(this);
		
		this.scriptScenario1 = null;
		this.scriptScenario2 = null;
	}

	public static void main(String args[])
	{
		Controleur ctrl = new Controleur();

		System.out.println("Nombre d'arete : " + ctrl.getGraphe().getEnsArete().size());
		System.out.println("Nombre d'ile : "   + ctrl.getGraphe().getEnsIle  ().size());
	}
	
	public void Solo()					  { frameAccueil.Solo () ;}
	public void Multi()					  { frameAccueil.Multi() ;}
	public void Test()					  { frameAccueil.Test () ;}
	public Graphe getGraphe()			  { return this.graphe        ;}
	public Joueur getJoueur()			  { return this.joueur        ;}
	public Pioche getPioche()			  { return this.pioche        ;}
	public FrameAccueil getFrameAccueil() { return this.frameAccueil  ;}
	public Score getScore()				  { return this.score         ;}

	public void setScenario()
	{
		bScenario = true;
		this.scriptScenario1 = new ScriptScenario1(this);
	}

	public ScriptScenario1 getScriptScenario1(){return this.scriptScenario1;}

	public void setScenario2()
	{
		bScenario = true;
		this.scriptScenario2 = new ScriptScenario2(this);
	}
	
	public ScriptScenario2 getScriptScenario2(){return this.scriptScenario2;}
}