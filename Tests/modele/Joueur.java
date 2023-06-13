/*Classe Joueur qui permet de créer un joueur avec une couleur et son nombre de coups
 *Auteurs : Louis Marouard, Maxime Galmant, Evan Cnaepelnickx, Arthur Lecomte
*/

package modele;
import java.awt.Color;

public class Joueur
{	

	private final static Color[] tabCoul = {Color.RED, Color.BLUE};
	private final static int rdmColor1 = (int) Math.random()*2;
	private final static int rdmColor2 = 1-rdmColor1;
	
	private Color 	couleurJoueur;
	private int 	points;

	public Joueur()
	{
		this.couleurJoueur =  tabCoul[rdmColor1];

		

		this.points        = 0;
	}
	
	public Color 	getCouleurJoueur()		  				{return this.couleurJoueur	     	;}
	public int   	getRdmColor1()						 	{return rdmColor1	     	 		;}
	public int   	getRdmColor2()						  	{return rdmColor2	    	 		;}
	public void 	setCouleurJoueur(Color couleurJoueur) 	{this.couleurJoueur = couleurJoueur	;}
	public int  	getPoints()			  	  			  	{return this.points		     	 	;}
	public void 	setPoints(int points)		   	   	 	{this.points = points		    	;}
	public void 	ajouterPoints(int points)			  	{this.points += points	    	 	;}
}
