package vue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import controleur.Controleur;
import modele.Arete;

public class ScriptScenario1 
{
	private Controleur ctrl;

	public ScriptScenario1(Controleur ctrl)
	{
		this.ctrl =ctrl;


		this.ctrl.getJoueur().setRdmColor1(0);

		this.ctrl.getFrameAccueil().getFrameSolo().getpanelDroit().getpanelPioche().click();
		
		
	}
}
