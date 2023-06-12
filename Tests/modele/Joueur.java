/*Classe Joueur qui permet de créer un joueur avec une couleur et son nombre de coups
 *Auteurs : Louis Marouard, Maxime Galmant, Evan Cnaepelnickx, Arthur Lecomte
*/

package modele;
import java.awt.Color;

public class Joueur
{
	private static int nbCoupsColor1 = 0;
	private static int nbCoupsColor2 = 0;
	
	private Color 	couleurJoueur;
	private int 	rdmColor1;
	private int 	rdmColor2;
	private int 	points;

	public Joueur()
	{
		this.couleurJoueur =  new Color   (255,51,51);

		this.rdmColor1     =(int) (Math.random() * 6) + 5;
		this.rdmColor2     =(int) (Math.random() * 6) + 5;
		this.points        = 0;
	}
	
	public Color getCouleurJoueur() 				  {return this.couleurJoueur	     ;}
	public int   getRdmColor1()						  {return this.rdmColor1	     	 ;}
	public int   getRdmColor2()						  {return this.rdmColor2	    	 ;}
	public int   getNbCoupsColor1()		  	  		  {return Joueur.nbCoupsColor1	     ;}
	public int   getNbCoupsColor2()		  	  		  {return Joueur.nbCoupsColor2       ;}
	public int   ajouterCoupColor1()		 		  {return Joueur.nbCoupsColor1++     ;}
	public int   ajouterCoupColor2()		  		  {return Joueur.nbCoupsColor2++     ;}
	public void setCouleurJoueur(Color couleurJoueur) {this.couleurJoueur = couleurJoueur;}
	public int  getPoints()			  	  			  {return this.points		     	 ;}
	public void setPoints(int points)		   	   	  {this.points = points		    	 ;}
	public void ajouterPoints(int points)			  {this.points += points	    	 ;}
}
