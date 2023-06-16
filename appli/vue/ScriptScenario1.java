package vue;


import controleur.Controleur;
import modele.Arete;

public class ScriptScenario1 		//Demontrer que le pioche fonctionne
{
	private Controleur ctrl;

	public ScriptScenario1(Controleur ctrl)
	{
		this.ctrl =ctrl;


		this.ctrl.getJoueur().setRdmColor1(0); //Couleur rouge 
		this.ctrl.getPioche().setIndex(0);	//Carte jaune Brun 
		this.ctrl.getFrameAccueil().getFrameSolo().getpanelDroit().getPanelPioche().click();
		
		
	}
}
