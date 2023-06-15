/*Classe Score qui permet de calculer le score du Joueur
 *Auteurs : Louis Marouard, Maxime Galmant, Evan Cnaepelnickx, Arthur Lecomte
*/

package modele;

import controleur.*;

public class Score
{
	private static int nbRegion;
	private static int nbRegionMax;
	private static int bonus;
	private static int scoreLigneActuelle;
	private static int scoreLigne1;
	private static int scoreFinal;

	private static boolean tour1 = true;


	private Controleur ctrl;

	public Score(Controleur ctrl)
	{
		this.ctrl = ctrl;
		
	}
	
	public void ajouterRegion()
	{
		nbRegion ++;
		maj();
		
	}
	public void ajouterRegionMax()
	{
		nbRegionMax ++;
		maj();
	}

	public void ajouterBonus( )
	{
		bonus ++;
		maj();
	}

	public void maj ()
	{
		
		scoreLigneActuelle = nbRegion*nbRegionMax;
		if (tour1)
		{
		scoreLigne1 = scoreLigneActuelle;
		scoreFinal = scoreLigneActuelle;
		}
		else
		 {
			scoreFinal = scoreLigne1 +scoreLigneActuelle;
		 }

		this.ctrl.getFrameAccueil().getFrameSolo().getPnlDroit().getPnlScore().maj(""+nbRegion,""+nbRegionMax,""+bonus,""+scoreLigneActuelle,""+scoreFinal);
		
	}

	public void prochainTour()
	{
		nbRegion = 0;
		nbRegionMax = 0;
		scoreLigneActuelle =0;

	}
}