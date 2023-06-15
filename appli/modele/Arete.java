package modele;

import java.awt.Color;
import java.util.List;
import controleur.Controleur;

public class Arete
{
	private int	    num;
	private Ile 	ile1;
	private Ile 	ile2;
	private int 	valeur;
	private Color 	couleur;

	public Arete(int num, Ile ile1, Ile ile2) 
	{
		this.num 	= num;
		this.ile1	= ile1;
		this.ile2	= ile2;
		this.valeur	= 0;
		this.couleur= new Color(188,188,180);
	}

	public Arete(int num, Ile ile1, Ile ile2, Color couleur) 
	{
		this.num 	= num;
		this.ile1	= ile1;
		this.ile2	= ile2;
		this.valeur	= 0;
		this.couleur= couleur;
	}


	public int 		getNum()                  {return this.num              ;}
	public Ile 	    getIle1()                 {return this.ile1             ;}
	public Ile	    getIle2()                 {return this.ile2             ;}
	public int	    getValeur()               {return this.valeur           ;}
	public Color	getCouleur()              {return this.couleur          ;}
	public Color    setCouleur(Color couleur) {return this.couleur = couleur;}

	public String toString() 
	{
		return "Arete [num=" + num + ", ile1=" + ile1 + ", ile2=" + ile2 + ", valeur=" + valeur + ", couleur="
				+ couleur + "]";
	}

	public boolean intersection(List<Arete> lstArete) 
	{
		double nx1 = this.getIle2().getCoCentreX();
		double ny1 = this.getIle2().getCoCentreY();

		// Vecteur
		double vx1 = this.getIle1().getCoCentreX() - this.getIle2().getCoCentreX();
		double vy1 = this.getIle1().getCoCentreY() - this.getIle2().getCoCentreY();

		for (Arete arete : lstArete) 
		{
			double nx2 = arete.getIle2().getCoCentreX();
			double ny2 = arete.getIle2().getCoCentreY();

			// Vecteur
			double vx2 = arete.getIle1().getCoCentreX() - arete.getIle2().getCoCentreX();
			double vy2 = arete.getIle1().getCoCentreY() - arete.getIle2().getCoCentreY();

			if (vx1 * vy2 - vy1 * vx2 != 0) 
			{
				double v1 = -(-vx1 * ny1 + vx1 * ny2 + vy1 * nx1 - vy1 * nx2) / (vx1 * vy2 - vy1 * vx2);
				double v2 = -( nx1 * vy2 - nx2 * vy2 - vx2 * ny1 + vx2 * ny2) / (vx1 * vy2 - vy1 * vx2);

				if (v1 > 0 && v1 < 1 && v2 > 0 && v2 < 1) { return true; }
			}
		}
		return false;
	}

	public boolean estLieeExtremite(Ile ile) 
	{
		if (this.getIle1().equals(ile) || this.getIle2().equals(ile)) { return true; }
		return false;
	}

	public boolean bonneCouleur(Controleur ctrl)
	{
		// Vérification de la couleur de l'ile avec la carte
		String couleur = ctrl.getFrameAccueil().getFrameSolo().getpanelDroit().getpanelPioche().getTypeCouleur();
		System.out.println("Couleur : " + couleur);
		if (((this.getIle1().getCouleur().equals(couleur) && (this.getIle2() == ctrl.getGraphe().getIleArrivee() 
			|| this.getIle2() == ctrl.getGraphe().getIleDepart()))
			|| (this.getIle2().getCouleur().equals(couleur) && (this.getIle1() == ctrl.getGraphe().getIleArrivee() 
			|| this.getIle1() == ctrl.getGraphe().getIleDepart()))) && couleur != "Joker") {
			System.out.println("Nom île 1: " + this.getIle1().getNom() + ", couleur: " + this.getIle1().getCouleur());
			System.out.println("Nom île 2: " + this.getIle2().getNom() + ", couleur: " + this.getIle2().getCouleur());
			System.out.println("La couleur de l'île n'est pas la même que la carte ou l'île n'est pas l'île de départ/arrivée");
			return true ;
		}
		else if (this.getIle1().getNom().equals("Mutaa") && this.getIle2().getCouleur().equals(couleur) 
			|| this.getIle2().getNom().equals("Mutaa") && this.getIle1().getCouleur().equals(couleur))
			return true;
		else if (this.getIle1().getNom().equals("Ticó") && this.getIle2().getCouleur().equals(couleur) 
			|| this.getIle2().getNom().equals("Ticó") && this.getIle1().getCouleur().equals(couleur))
			return true;

		return false;
	}
}