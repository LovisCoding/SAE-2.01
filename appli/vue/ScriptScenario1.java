package vue;

import controleur.Controleur;
import modele.Arete;
import modele.Graphe;
import modele.Ile;
import java.awt.Color;

public class ScriptScenario1
{
	private Controleur ctrl;

	public ScriptScenario1(Controleur ctrl)
	{
		this.ctrl =ctrl;

		this.ctrl.getJoueur().setCouleurJoueur(Color.RED); //Couleur rouge

		Graphe g = this.ctrl.getGraphe();
		for (Arete ac : g.getEnsArete())
		{
			if (ac.getIle1().getNom().equals("Ticó"))
				g.setIleDepart(ac.getIle1());

			if (ac.getIle1().getNom().equals("Ticó") && ac.getIle2().getNom().equals("Laçao")
				|| ac.getIle1().getNom().equals("Laçao") && ac.getIle2().getNom().equals("Ticó"))
			{
				g.ajouterAreteColorer(ac);
			}
		}

		for (Arete ac : g.getEnsArete())
		{
			if (ac.getIle1().getNom().equals("Milaù") && ac.getIle2().getNom().equals("Mutaa")
				|| ac.getIle1().getNom().equals("Laçao") && ac.getIle2().getNom().equals("Milaù"))
			{
				g.ajouterAreteColorer(ac);
			}
		}

		for (Arete ac : g.getEnsArete())
		{
			if (ac.getIle1().getNom().equals("Milaù") && ac.getIle2().getNom().equals("Laçao")
				|| ac.getIle1().getNom().equals("Laçao") && ac.getIle2().getNom().equals("Milaù"))
			{
				g.ajouterAreteColorer(ac);
			}
		}
	

		//this.ctrl.get

		this.ctrl.getFrameAccueil().getFrameSolo().getPanelIles().repaint();
	}

}
