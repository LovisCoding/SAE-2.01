/*Classe Score qui permet de calculer le score du Joueur
 *@author Louis Marouard, Maxime Galmant, Evan Cnaepelnickx, Arthur Lecomte
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
	private static int scoreTour1;
	private static int scoreLigneActuelle;
	private static int scoreFinal;

	private static List<Arete> ensAreteColoree;

	private boolean verif = false;
	
	private Controleur ctrl;

	public Score(Controleur ctrl) 
	{ 
		this.ctrl = ctrl; 
		ensAreteColoree = this.ctrl.getGraphe().getEnsAreteScore();
	}
	
	public void ajouterRegion()
	{
		nbRegion ++;
		maj();
	}

	public void CalculRegions()  //Calculer le nombre de région et le nombre de région max
	{
		ArrayList<Ile> listeIle = new ArrayList<Ile>();
		int tabGroupIles[] = new int [6];
		int compter = 0;

		for (Arete a : ensAreteColoree) 
		{
			if (!listeIle.contains(a.getIle1())) { listeIle.add(a.getIle1()); }
			if (!listeIle.contains(a.getIle2())) { listeIle.add(a.getIle2()); }
		}

		for (Ile ile : listeIle) 
		{
			if (ile.getGroupIles()==1)	{tabGroupIles[1]++;}
			if (ile.getGroupIles()==2)	{tabGroupIles[2]++;}
			if (ile.getGroupIles()==3)	{tabGroupIles[3]++;}
			if (ile.getGroupIles()==4)	{tabGroupIles[4]++;}
			if (ile.getGroupIles()==5)	{tabGroupIles[5]++;}
		}

		//Calculer le maximum du tableau
		for (int i = 1; i < tabGroupIles.length; i++) 
		{
			if (tabGroupIles[i]>nbRegionMax) {nbRegionMax = tabGroupIles[i];}
		}

		//compter le nombre de groupe d'ile > 0
		for (int i = 1; i < tabGroupIles.length; i++) 
		{
			if (tabGroupIles[i]>0) {compter++;}
		}

		nbRegion = compter;
	}
	
	public void ajouterBonus()
	{
		bonus +=2;
		System.out.println("dans le bonus");
		maj();
	}

	public void maj()
	{
		CalculRegions();
		scoreLigneActuelle = nbRegion*nbRegionMax+bonus;

		if (!verif)
		{
			scoreFinal  = scoreTour1 = scoreLigneActuelle;
		}
		
		else { scoreFinal = scoreTour1 +scoreLigneActuelle; }

		this.ctrl.getFrameAccueil().getFrameSolo().getpanelDroit().getPanelScore().maj(""+nbRegion,""+nbRegionMax,""+(nbRegion*nbRegionMax),""+bonus,""+scoreLigneActuelle,""+scoreFinal);
	}

	public void prochainTour()
	{
		nbRegion = 0;
		nbRegionMax = 0;
		scoreLigneActuelle =0;
		bonus = 0;
		verif = true;
		ensAreteColoree.clear(); //vide pour le deuxieme tour
		this.ctrl.getFrameAccueil().getFrameSolo().getpanelIles().setTour1True(); 
		maj();
	}

	public int getScoreFinal() { return scoreFinal; }
}