/* Classe ScriptScenario1 qui permet de charger le 1er scénario du jeu
 *@author Louis Marouard, Maxime Galmant, Evan Cnaepelnickx, Arthur Lecomte
*/
package vue;


import controleur.Controleur;
import modele.Arete;
import modele.Ile;

public class ScriptScenario1 		//Demontrer que la pioche fonctionne
{
	private Controleur ctrl;

	public ScriptScenario1(Controleur ctrl)
	{
		Ile ile1  = this.ctrl.getGraphe().getEnsIle().get(3);
		Ile ile2  = this.ctrl.getGraphe().getEnsIle().get(4);
		this.ctrl = ctrl;


		this.ctrl.getJoueur      ().setRdmColor1(0);											//Couleur rouge 
		this.ctrl.getPioche      ().setIndex    (0);											//Carte jaune Brun 
		this.ctrl.getFrameAccueil().getFrameSolo().getPanelDroit().getPanelPioche().click();
		
		//this.ctrl.getFrameAccueil().getFrameSolo().getPanelIles().ajouterAreteManuellement(ile1, ile2,this.ctrl.getJoueur().getCouleurJoueur());
	}
}
