package vue;

import controleur.Controleur;
import modele.Arete;
import modele.Graphe;
import modele.Ile;
import java.awt.Color;

public class ScriptScenario2
{
	private Controleur ctrl;

	public ScriptScenario2(Controleur ctrl)
	{
		this.ctrl =ctrl;


		this.ctrl.getJoueur().setCouleurJoueur(Color.RED); //Couleur rouge
		this.ctrl.getFrameAccueil().getFrameSolo().getpanelDroit().getPanelPioche().click();

		Graphe g = this.ctrl.getGraphe();
		for (Ile i : g.getEnsIle())
		{
			if (i.getNom().equals("Ticó"))
				g.setIleDepart(i);
			for (Ile i2 : g.getEnsIle())
			{
				if (i.getNom().equals("Ticó") && i2.getNom().equals("Laçao") 
					|| i.getNom().equals("Laçao") && i2.getNom().equals("Ticó"))
				{
					Arete a = new Arete(1,i, i2, Color.RED);
					g.ajouterAreteColorer(a);
				}
			}
		}

		for (Ile i : g.getEnsIle())
		{
			for (Ile i2 : g.getEnsIle())
			{
				if (i.getNom().equals("Milaù") && i2.getNom().equals("Laçao") 
					|| i.getNom().equals("Laçao") && i2.getNom().equals("Milaù"))
				{
					Arete a = new Arete(2,i, i2, Color.RED);
					g.ajouterAreteColorer(a);
				}
			}
		}

		for (Ile i : g.getEnsIle())
		{
			for (Ile i2 : g.getEnsIle())
			{
				if (i.getNom().equals("Milaù") && i2.getNom().equals("Mutaa") 
					|| i.getNom().equals("Mutaa") && i2.getNom().equals("Milaù"))
				{
					Arete a = new Arete(3,i, i2, Color.RED);
					g.ajouterAreteColorer(a);
				}
			}
		}

		for (Ile i : g.getEnsIle())
		{
			for (Ile i2 : g.getEnsIle())
			{
				if (i.getNom().equals("Khont-Rolah") && i2.getNom().equals("Mutaa") 
					|| i.getNom().equals("Mutaa") && i2.getNom().equals("Khont-Rolah"))
				{
					Arete a = new Arete(4,i, i2, Color.RED);
					g.ajouterAreteColorer(a);
				}
			}
		}

		for (Ile i : g.getEnsIle())
		{
			for (Ile i2 : g.getEnsIle())
			{
				if (i.getNom().equals("Khont-Rolah") && i2.getNom().equals("Kita") 
					|| i.getNom().equals("Kita") && i2.getNom().equals("Khont-Rolah"))
				{
					Arete a = new Arete(5,i, i2, Color.RED);
					g.ajouterAreteColorer(a);
				}
			}
		}

		this.ctrl.getFrameAccueil().getFrameSolo().getpanelIles().repaint();
	}

}
