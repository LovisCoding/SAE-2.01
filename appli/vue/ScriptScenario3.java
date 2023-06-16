/* Classe ScriptScenario3 qui permet de charger le 3eme scénario du jeu
 *@author Louis Marouard, Maxime Galmant, Evan Cnaepelnickx, Arthur Lecomte
*/

package vue;

import controleur.Controleur;
import modele.Arete;
import modele.Graphe;
import modele.Ile;
import java.awt.Color;

public class ScriptScenario3
{
	private Controleur ctrl;

	public ScriptScenario3(Controleur ctrl)
	{
		this.ctrl = ctrl;

		this.ctrl.getJoueur().setCouleurJoueur(Color.BLUE); //Couleur bleu
		this.ctrl.getFrameAccueil().getFrameSolo().getPanelDroit().getPanelPioche().click();

		Graphe g = this.ctrl.getGraphe();

		for (Ile i : g.getEnsIle())
		{
			if (i.getNom().equals("Mutaa")) { g.setIleDepart(i); }
			
			for (Ile i2 : g.getEnsIle())
			{
				if (i.getNom().equals("Mutaa") && i2.getNom().equals("Massao")
					|| i.getNom().equals("Massao") && i2.getNom().equals("Mutaa"))
				{
					Arete a = new Arete(1,i, i2, Color.BLUE);
					g.ajouterAreteColorer(a);
				}
			}
		}

		for (Ile i : g.getEnsIle())
		{
			for (Ile i2 : g.getEnsIle())
			{
				if (i.getNom().equals("Milaù") && i2.getNom().equals("Massao") 
					|| i.getNom().equals("Massao") && i2.getNom().equals("Milaù"))
				{
					Arete a = new Arete(2,i, i2, Color.BLUE);
					g.ajouterAreteColorer(a);
				}
			}
		}

		this.ctrl.getFrameAccueil().getFrameSolo().getPanelIles().repaint();
	}
}