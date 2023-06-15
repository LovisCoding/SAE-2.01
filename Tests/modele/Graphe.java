/*Classe Graphe qui permet de créer de créer le graphe
 *Auteurs : Louis Marouard, Maxime Galmant, Evan Cnaepelnickx, Arthur Lecomte
*/

package modele;

import java.util.List;
import java.awt.Color;
import java.util.ArrayList;

import controleur.Controleur;

public class Graphe 
{
	
	private List<Arete>  	ensArete ;
	private List<Ile> 		ensIles;
	private List<Arete>		ensAreteColorer;
	private String 			nom;
	private List<Ile> 		ensIlesVisite;
	private Ile 			ileDepart;
	private Ile 			ileArrivee;
	private Controleur 		ctrl;

	public Graphe(String nom,Controleur ctlr) 
	{
		this.nom             	= nom;
		this.ctrl 				= ctlr;
		this.ensArete        	= new ArrayList<Arete>	();
		this.ensIles       		= new ArrayList<Ile>	();
		this.ensAreteColorer 	= new ArrayList<Arete>	();
		this.ensIlesVisite 		= new ArrayList<Ile>	();
		this.ileDepart 			= new Ile("Depart", "Blanc" , 0, 0, 0, 0, 0);
		this.ileArrivee 		= new Ile("Arrivee", "Blanc", 0, 0, 0, 0, 0);
	}

	public void ajouterIles(Ile ile)		 {this.ensIles.add(ile)		;}
	public void ajouterArete (Arete  arete ) {this.ensArete.add(arete)  	;}

	public void ajouterAreteColorer(Arete arete)
	{
		if (this.ensIlesVisite.size() < 1)
		{
			System.out.println(arete.getIle1().getNom() + " " + arete.getIle2().getNom());

			if (this.ctrl.getJoueur().getCouleurJoueur() == Color.RED && (arete.getIle1().getNom().equals("Ticó")
				||arete.getIle2().getNom().equals("Ticó")))
			{
				this.ileArrivee = arete.getIle2();
				this.ileDepart  = arete.getIle1();
				this.ensAreteColorer.add(arete);
				this.ensIlesVisite.add(arete.getIle2());
				this.ensIlesVisite.add(arete.getIle1());

				arete.setCouleur(this.ctrl.getJoueur().getCouleurJoueur());
			}

			if (this.ctrl.getJoueur().getCouleurJoueur() == Color.BLUE && (arete.getIle1().getNom().equals("Mutaa")
				||arete.getIle2().getNom().equals("Mutaa")))
			{
				this.ileArrivee = arete.getIle2();
				this.ileDepart  = arete.getIle1();
				this.ensAreteColorer.add(arete);
				this.ensIlesVisite.add(arete.getIle2());
				this.ensIlesVisite.add(arete.getIle1());

				arete.setCouleur(this.ctrl.getJoueur().getCouleurJoueur());
			}
		}

		else
		{
			System.out.println(arete.getIle1().getNom() + " c passé " + arete.getIle2().getNom());

			if (arete.getIle1()  == this.ileDepart)
			{
				this.ileDepart = arete.getIle2();
				System.out.println("Ile depart : " + this.ileDepart.getNom());
				this.ensAreteColorer.add(arete);
				arete.setCouleur(this.ctrl.getJoueur().getCouleurJoueur());

			}
			
			else if (arete.getIle2() == this.ileDepart)
			{
				this.ileDepart = arete.getIle1();
				System.out.println("Ile depart : " + this.ileDepart.getNom());
				this.ensAreteColorer.add(arete);
				arete.setCouleur(this.ctrl.getJoueur().getCouleurJoueur());
			}

			if (arete.getIle1() == this.ileArrivee)
			{
				this.ileArrivee = arete.getIle2();
				System.out.println("Ile arrivee : " + this.ileArrivee.getNom());
				this.ensAreteColorer.add(arete);
				arete.setCouleur(this.ctrl.getJoueur().getCouleurJoueur());
			}

			else if (arete.getIle2() == this.ileArrivee)
			{
				this.ileArrivee = arete.getIle1();
				System.out.println("Ile arrivee : " + this.ileArrivee.getNom());
				this.ensAreteColorer.add(arete);
				arete.setCouleur(this.ctrl.getJoueur().getCouleurJoueur());
			}
			
			this.ensIlesVisite.add(arete.getIle2());
			this.ensIlesVisite.add(arete.getIle1());
		}
	}

	public List<Arete>  getEnsArete () 			{return this.ensArete 		;}
	public List<Ile> 	getEnsIle() 			{return this.ensIles		;}
	public List<Arete>  getEnsAreteColorer() 	{return this.ensAreteColorer;}
	public String 		getNom() 				{return this.nom			;}
	public List<Ile> 	getEnsIlesVisite() 		{return this.ensIlesVisite	;}
	public Ile 			getIleDepart() 			{return this.ileDepart		;}
	public Ile 			getIleArrivee() 		{return this.ileArrivee		;}
	
	public void setEnsSommetVisite(List<Ile> ensSommetVisite) {this.ensIlesVisite = ensSommetVisite;}
	public void setIleDepart(Ile ileDepart) 				  {this.ileDepart = ileDepart		   ;}

	public boolean formeCycle(Arete tmp)
	{
		if (this.ensIlesVisite.contains(tmp.getIle1()) && this.ensIlesVisite.contains(tmp.getIle2())) { return true; }
		return false;
	}

	public boolean estAdjacent(Ile ile1, Ile ile2)
	{
		for (Arete arete : ensArete)
		{
			if ((arete.getIle1() == ile1 && arete.getIle2() == ile2) || (arete.getIle1() == ile2 && arete.getIle2() == ile1)) { return true; }
		}
		return false;
	}

	public void reset()
	{
		this.ensIlesVisite.clear();
		
		this.ileArrivee = new Ile("Arrivee", "Blanc", 0, 0, 0, 0, 0);
		this.ileDepart  = new Ile("Depart", "Blanc" , 0, 0, 0, 0, 0);
	}
}