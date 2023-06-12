/*Classe Graphe qui permet de créer de créer le graphe
 *Auteurs : Louis Marouard, Maxime Galmant, Evan Cnaepelnickx, Arthur Lecomte
*/

package modele;

import java.util.List;
import java.util.ArrayList;

public class Graphe 
{
	private List<Arete>  		ensArete ;
	private List<Ile> 			ensIles;
	private List<Arete>			ensAreteColorer;
	private String 				nom;
	private List<Ile> 			ensIlesVisite;


	public Graphe(String nom) 
	{
		this.nom             	= nom;
		this.ensArete        	= new ArrayList<Arete>();
		this.ensIles       		= new ArrayList<Ile>();
		this.ensAreteColorer 	= new ArrayList<Arete>();
		this.ensIlesVisite 		= new ArrayList<Ile>();
	}

	public void ajouterIles(Ile ile)			{this.ensIles.add(ile)		;}
	public void ajouterArete (Arete  arete )	{this.ensArete.add(arete)  	;}
	
	public void ajouterAreteColorer(Arete arete) 
	{
		this.ensAreteColorer.add(arete);
		this.ensIlesVisite.add(arete.getIle1());
		this.ensIlesVisite.add(arete.getIle2());
	}

	public List<Arete>  getEnsArete () 			{return this.ensArete 		;}
	public List<Ile> 	getEnsIle() 			{return this.ensIles		;}
	public List<Arete>  getEnsAreteColorer() 	{return this.ensAreteColorer;}
	public String 		getNom() 				{return this.nom			;}
	
	public void setEnsSommetVisite(List<Ile> ensSommetVisite) {this.ensIlesVisite = ensSommetVisite;}

	public boolean formeCycle(Arete tmp)
	{
		for (Ile ile : this.ensIles)
		{
			System.out.println("Liste sommet visité : " + ile.getNom());
		}

		if (this.ensIlesVisite.contains(tmp.getIle1()) && this.ensIlesVisite.contains(tmp.getIle2()))
		{
			return true;
		}
		return false;
	}
}