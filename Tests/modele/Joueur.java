/*Classe Joueur qui permet de créer un joueur avec une couleur et son nombre de coups
 *Auteurs : Louis Marouard, Maxime Galmant, Evan Cnaepelnickx, Arthur Lecomte
*/

package modele;
import java.awt.Color;

import controleur.Controleur;

public class Joueur
{	
	private final 	static Color[] 	tabCoul 	= {Color.RED, Color.BLUE};
	private  		static int 		rdmColor1 	= (int) (Math.random()*2);
	private final 	static int 		rdmColor2 	= 1-rdmColor1;

	private Controleur 	ctrl;
	private boolean 	changementCouleur;	
	private Color 		couleurJoueur;
	private int 		points;

	public Joueur(Controleur ctrl)
	{
		this.ctrl = ctrl;
		System.out.println("rdm :" + rdmColor1);
		this.couleurJoueur =  tabCoul[rdmColor1];
		this.points        = 0;
	}
	
	public Color 	getCouleurJoueur()		  				{return this.couleurJoueur	     	;}
	public int   	getRdmColor1()						 	{return rdmColor1	     	 		;}
	public int   	getRdmColor2()						  	{return rdmColor2	    	 		;}
	public boolean 	getChangementCouleur()					{return changementCouleur			;}
	public void 	setCouleurJoueur(Color couleurJoueur) 	{this.couleurJoueur = couleurJoueur	;}
	public int  	getPoints()			  	  			  	{return this.points		     	 	;}
	public void 	setPoints(int points)		   	   	 	{this.points = points		    	;}
	public void 	setChangementCouleur()			  	  	{this.changementCouleur = false		;}
	public void 	ajouterPoints(int points)			  	{this.points += points	    	 	;}
	public void 	changerCouleur()						
	{
		this.couleurJoueur 		= tabCoul[rdmColor2];
		this.changementCouleur 	= true;
		this.ctrl.getFrameAccueil().getFrameSolo().getPnlBandeau().repaint();
	}


}
