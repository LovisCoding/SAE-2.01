/* Classe ScriptScenario2 qui permet de charger le 2eme scénario du jeu
 *@author Louis Marouard, Maxime Galmant, Evan Cnaepelnickx, Arthur Lecomte
*/

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

		Graphe g = this.ctrl.getGraphe();
		for (Ile i : g.getEnsIle())
		{
			if (i.getNom().equals("Ticó")) { g.setIleDepart(i); }

			for (Ile i2 : g.getEnsIle())
			{
				if (i.getNom().equals("Ticó") && i2.getNom().equals("Laçao"))
				{
					Arete a = new Arete(1,i, i2);
					g.ajouterAreteColorer(a);
					g.setIleDepart(i);
					g.setIleArrivee(i2);
				}
			}
		}

		for (Ile i : g.getEnsIle())
		{
			for (Ile i2 : g.getEnsIle())
			{
				if (i.getNom().equals("Milaù") && i2.getNom().equals("Laçao"))
				{
					Arete a = new Arete(2,i, i2);
					g.ajouterAreteColorer(a);
					g.setIleArrivee(i);
				}
			}
		}

		for (Ile i : g.getEnsIle())
		{
			for (Ile i2 : g.getEnsIle())
			{
				if (i.getNom().equals("Milaù") && i2.getNom().equals("Mutaa"))
				{
					Arete a = new Arete(3,i, i2);
					g.ajouterAreteColorer(a);
					g.setIleArrivee(i2);
				}
			}
		}

		for (Ile i : g.getEnsIle())
		{
			for (Ile i2 : g.getEnsIle())
			{
				if (i.getNom().equals("Khont-Rolah") && i2.getNom().equals("Mutaa"))
				{
					Arete a = new Arete(4,i, i2);
					g.ajouterAreteColorer(a);
					g.setIleArrivee(i);
				}
			}
		}

		for (Ile i : g.getEnsIle())
		{
			for (Ile i2 : g.getEnsIle())
			{
				if (i.getNom().equals("Khont-Rolah") && i2.getNom().equals("Kita"))
				{
					Arete a = new Arete(5,i, i2);
					g.ajouterAreteColorer(a);
					g.setIleArrivee(i2);
				}
			}
		}

		this.ctrl.getFrameAccueil().getFrameSolo().getPanelIles().update();
	}
}