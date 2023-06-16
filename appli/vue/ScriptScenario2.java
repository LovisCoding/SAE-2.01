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

		this.ctrl.getJoueur().setRdmColor1(0); //Couleur rouge

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
			if (ac.getIle1().getNom().equals("Milaù") && ac.getIle2().getNom().equals("Laçao")
				|| ac.getIle1().getNom().equals("Laçao") && ac.getIle2().getNom().equals("Milaù"))
			{
				g.ajouterAreteColorer(ac);
			}
		}

		for (Arete ac : g.getEnsArete())
		{
			if (ac.getIle1().getNom().equals("Ticó") && ac.getIle2().getNom().equals("Kita")
				|| ac.getIle1().getNom().equals("Kita") && ac.getIle2().getNom().equals("Ticó"))
			{
				g.ajouterAreteColorer(ac);
			}
		}

		for (Arete ac : g.getEnsArete())
		{
			if (ac.getIle1().getNom().equals("Khont-Rolah") && ac.getIle2().getNom().equals("Kita")
				|| ac.getIle1().getNom().equals("Kita") && ac.getIle2().getNom().equals("Khont-Rolah"))
			{
				g.ajouterAreteColorer(ac);
			}
		}

		for (Arete ac : g.getEnsArete())
		{
				if (ac.getIle1().getNom().equals("Khont-Rolah") && ac.getIle2().getNom().equals("Mutaa")
					|| ac.getIle1().getNom().equals("Mutaa") && ac.getIle2().getNom().equals("Khont-Rolah"))
				{
					g.ajouterAreteColorer(ac);
				}
		}

		this.ctrl.getPioche().getLstImageP().add(this.ctrl.getPioche().getLstImageP().remove(1));
		this.ctrl.getPioche().getLstImageS().clear();

		for (int i = 0; i < 4; i++)
			this.ctrl.getPioche().getLstImageS().add(this.ctrl.getPioche().getLstImageP().remove(0));

		this.ctrl.getFrameAccueil().getFrameSolo().getPanelIles().repaint();
	}

}
