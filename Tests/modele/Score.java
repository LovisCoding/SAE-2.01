/*Classe Score qui permet de calculer le score du Joueur
 *Auteurs : Louis Marouard, Maxime Galmant, Evan Cnaepelnickx, Arthur Lecomte
*/

package modele;

import controleur.*;

import java.util.List;
import java.util.ArrayList;

public class Score
{
	private static int nbRegion;
	private static int nbRegionMax;
	private static int bonus;
	private static int scoreLigneActuelle;
	private static int scoreLigne1;
	private static int scoreFinal;

	private boolean verif = false; 	

	private static boolean tour1 = true;

	private Controleur ctrl;

	public Score(Controleur ctrl) { this.ctrl = ctrl; }
	
	public void ajouterRegion()
	{
		nbRegion ++;
		maj();
	}

	public void ajouterRegionMax()
	{
		nbRegionMax = 0;

		List<String> NomIlesVisites = new ArrayList<String>();

		int EfTera=0;
		int EmTera=0;
	 	int HelTera=0;
		int KhaTera=0;
		int TehTera=0;
		
		for (Ile ile : this.ctrl.getGraphe().getEnsIlesVisite())
		{
			for(String s : NomIlesVisites)
			{
				if(!ile.getNom().equals(s))
				{
					int g = ile.getGroupIles();

					switch (g)
					{
						case 1:
							TehTera++;
							break;
						case 2:
							KhaTera++;
							break;
						case 3:
							HelTera++;
							break;
						case 4:
							EmTera++;
							break;
						case 5:
							EfTera++;
							break;
					}
				}
			}
			System.out.println("Iles visitées :  "  + ile.getNom());
			NomIlesVisites.add(ile.getNom());
		}
		int max = 0;

		if(TehTera < KhaTera)	{max = KhaTera;}
		else					{max = TehTera;}
		if(max < HelTera)		{max = HelTera;}
		if(max < EmTera)		{max = EmTera ;}
		if(max < EfTera)		{max = EfTera ;}
		
		nbRegionMax = max;
		maj();
	}

	public void ajouterBonus( )
	{
		bonus +=2;
		System.out.println("dans le bonus");
		maj();
	}

	public void maj ()
	{
		if (nbRegion ==0) {verif = true;}

		System.out.println("verif :" + verif );
		scoreLigneActuelle = nbRegion*nbRegionMax+bonus;

		if (!verif)
		{
			scoreLigne1 = scoreLigneActuelle;
			scoreFinal  = scoreLigneActuelle;
		}
		
		else { scoreFinal = scoreFinal +scoreLigneActuelle; }

		this.ctrl.getFrameAccueil().getFrameSolo().getpanelDroit().getpanelScore().maj(""+nbRegion,""+nbRegionMax,""+(nbRegion*nbRegionMax),""+bonus,""+scoreLigneActuelle,""+scoreFinal);
	}

	public void prochainTour()
	{
		nbRegion = 0;
		nbRegionMax = 0;
		scoreLigneActuelle =0;
		bonus = 0;
		maj();
	}
}